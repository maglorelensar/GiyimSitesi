/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entity.Bedenler;
import entity.Kategori;
import entity.Urunler;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import util.DBConnection;

/**
 *
 * @author user
 */
public class UrunlerDao {
private Connection c;
private RenklerDao renkdao;
private BedenlerDao bedendao;
private PhotosDao phdao;
private KategoriDao katdao;
    public List<Urunler> getUrunList() {
        List<Urunler> urunlist = new ArrayList<>();
        try {
            c=DBConnection.getConnection();
            PreparedStatement pst = c.prepareStatement("select * from urunler");
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                Urunler temp=new Urunler();
                temp.setUrun_id(rs.getInt("urun_id"));
                temp.setUrun_adi(rs.getString("urun_adi"));
                temp.setUrun_fiyat(rs.getDouble("urun_fiyat"));
                temp.setUrun_stok_adedi(rs.getInt("urun_stok_adedi"));
                temp.setRenk(getRenkdao().getRenkList(rs.getInt("urun_rengi")));
                temp.setBeden(getBedendao().getBaginti(rs.getLong("urun_bedeni")));
                temp.setPhoto(getPhdao().getPhotoList(rs.getInt("urun_resim")));
                temp.setUrunkategorileri(this.getKatdao().getUrunKategorisi(temp.getUrun_id()));
                urunlist.add(temp);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }finally {
            DBConnection.closeConnection(c);
        }
        return urunlist;
    }
    
    public void add(Urunler urun) {
        try {
            c=DBConnection.getConnection();
            PreparedStatement pst = c.prepareStatement("insert into urunler values(default,?,?,?,?,?,?)",Statement.RETURN_GENERATED_KEYS);
            pst.setString(1, urun.getUrun_adi());    
            pst.setDouble(2, urun.getUrun_fiyat());   
            pst.setInt(3, urun.getUrun_stok_adedi()); 
            pst.setLong(4, urun.getRenk().getR_id()); 
            pst.setLong(5, urun.getBeden().getB_id()); 
            pst.setInt(6, urun.getPhoto().getD_id());
            int urunid=0;
            pst.executeUpdate();
            ResultSet gk=pst.getGeneratedKeys();
            if(gk.next()){
            urunid=gk.getInt(1);
            }
            
            for (Kategori u:urun.getUrunkategorileri()){
            PreparedStatement pst2 = c.prepareStatement("insert into urun_kategori values(?,?)");
            pst2.setInt(1, urunid);
            pst2.setLong(2, u.getKat_id());
            pst2.executeUpdate();
            }
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        finally {
            DBConnection.closeConnection(c);
        }
    }

    public void guncelle(Urunler urun) {
         try {
            c=DBConnection.getConnection();
            PreparedStatement pst = c.prepareStatement("Update urunler set urun_adi=?,urun_fiyat=?,urun_stok_adedi=?,urun_rengi=?,urun_bedeni=?,urun_resim=? where urun_id=?");
            pst.setString(1, urun.getUrun_adi());
            pst.setDouble(2, urun.getUrun_fiyat());
            pst.setInt(3, urun.getUrun_stok_adedi());
            pst.setLong(4, urun.getRenk().getR_id());
            pst.setLong(5, urun.getBeden().getB_id());
            pst.setInt(6, urun.getPhoto().getD_id());
            pst.setInt(7, urun.getUrun_id());
            pst.executeUpdate();
            pst=c.prepareStatement("delete from urun_kategori where urun_id=?");
            pst.setLong(1, urun.getUrun_id());
            pst.executeUpdate();
            for (Kategori u:urun.getUrunkategorileri()){
            pst = c.prepareStatement("insert into urun_kategori values(?,?)");
            pst.setInt(1, urun.getUrun_id());
            pst.setLong(2, u.getKat_id());
            pst.executeUpdate();
            }
           
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }finally {
            DBConnection.closeConnection(c);
        }
    }

    public void delete(Urunler u) {
        try {
            c=DBConnection.getConnection();
            PreparedStatement pst=c.prepareStatement("delete from urun_kategori where urun_id=?");
            pst.setLong(1, u.getUrun_id());
            pst.executeUpdate();
            pst = c.prepareStatement("delete from urunler where urun_id=?");
            pst.setInt(1, u.getUrun_id());
            pst.executeUpdate();
            getPhdao().sil(u.getPhoto());
             } catch (Exception e) {
            System.out.println(e.getMessage());
        }finally {
            DBConnection.closeConnection(c);
        }
    }
    public Urunler getBaginti(int urun_id) {
       Urunler urun = null;
        try {
            c=DBConnection.getConnection();
            PreparedStatement pst = c.prepareStatement("select * from urunler where urun_id="+urun_id);
            ResultSet rs = pst.executeQuery();
            rs.next();
            urun=new Urunler();
            urun.setUrun_id(rs.getInt("urun_id"));
            urun.setUrun_adi(rs.getString("urun_adi"));
            urun.setUrun_fiyat(rs.getInt("urun_fiyat"));
            urun.setUrun_stok_adedi(rs.getInt("urun_stok_adedi"));
            urun.getRenk().setR_id(rs.getLong("urun_rengi"));
            urun.getBeden().setB_id(rs.getLong("urun_bedeni"));
            urun.getPhoto().setD_id(rs.getInt("urun_resim"));
            urun.setUrunkategorileri(this.getKatdao().getUrunKategorisi(urun_id));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }finally {
            DBConnection.closeConnection(c);
        }
        return urun;
    }

    public RenklerDao getRenkdao() {
        if(this.renkdao==null)
            this.renkdao=new RenklerDao();
        return renkdao;
    }

    public BedenlerDao getBedendao() {
        if(this.bedendao==null)
            this.bedendao=new BedenlerDao();
        return bedendao;
    }

    public PhotosDao getPhdao() {
        if(this.phdao==null)
            this.phdao=new PhotosDao();
        return phdao;
    }

    public KategoriDao getKatdao() {
        if(this.katdao==null)
            this.katdao=new KategoriDao();
        return katdao;
    }
    
}
