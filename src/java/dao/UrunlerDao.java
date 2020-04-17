/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entity.Bedenler;
import entity.Urunler;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import util.DBConnection;

/**
 *
 * @author user
 */
public class UrunlerDao {
private Connection c;
RenklerDao renkdao;
BedenlerDao bedendao;
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
                temp.setBeden(getBedendao().getBedenList(rs.getInt("urun_bedeni")));
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
            PreparedStatement pst = c.prepareStatement("insert into urunler values(default,?,?,?,?,?)");
            pst.setString(1, urun.getUrun_adi());    
            pst.setDouble(2, urun.getUrun_fiyat());   
            pst.setInt(3, urun.getUrun_stok_adedi()); 
            pst.setInt(4, urun.getRenk().getR_id()); 
            pst.setInt(5, urun.getBeden().getB_id()); 
            pst.executeUpdate();
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
            PreparedStatement pst = c.prepareStatement("Update urunler set urun_adi=?,urun_fiyat=?,urun_stok_adedi=?,urun_rengi=?,urun_bedeni=? where urun_id=?");
            pst.setString(1, urun.getUrun_adi());
            pst.setDouble(2, urun.getUrun_fiyat());
            pst.setInt(3, urun.getUrun_stok_adedi());
            pst.setInt(4, urun.getRenk().getR_id());
            pst.setInt(5, urun.getBeden().getB_id());
            pst.setInt(6, urun.getUrun_id());
            pst.executeUpdate();
           
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }finally {
            DBConnection.closeConnection(c);
        }
    }

    public void delete(Urunler u) {
        try {
            c=DBConnection.getConnection();
            PreparedStatement pst = c.prepareStatement("delete from urunler where urun_id=?");
            pst.setInt(1, u.getUrun_id());
            pst.executeUpdate();

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
            urun.getRenk().setR_id(rs.getInt("urun_rengi"));
            urun.getBeden().setB_id(rs.getInt("urun_bedeni"));
            
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
    
}
