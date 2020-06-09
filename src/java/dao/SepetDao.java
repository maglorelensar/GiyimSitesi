/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entity.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import util.DBConnection;

public class SepetDao {

    private Connection c;
    private KullaniciDao kd;
    private UrunlerDao ud;
    private RenklerDao rd;
    private BedenlerDao bd;
    private PhotosDao pd;
    private KullaniciGirisiDao kgdao;
    public List<Sepet> getSepetList() {
        List<Sepet> sepetlist = new ArrayList<>();
        try {
            c = DBConnection.getConnection();
            PreparedStatement pst = c.prepareStatement("select * from sepet where kul_id=?");
            pst.setInt(1, getKgdao().getSimdiki_id());
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                Sepet temp = new Sepet();
                temp.setSepet_id(rs.getInt("sepet_id"));
                temp.setK(getKd().getBaginti(rs.getInt("kul_id")));
                temp.setU(getUd().getBaginti(rs.getInt("urun_id")));
                temp.setUrun_adet(rs.getInt("urun_adedi"));
                temp.setR(getRd().getBaginti(rs.getLong("urun_renk")));
                temp.setB(getBd().getBaginti(rs.getLong("urun_beden")));
                sepetlist.add(temp);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            DBConnection.closeConnection(c);
        }
        return sepetlist;
    }

    public void add(Sepet s) {
        try {
            c = DBConnection.getConnection();
            
            PreparedStatement pst = c.prepareStatement("select * from sepet where kul_id=? and urun_id=? and urun_renk=? and urun_beden=?");
            pst.setInt(1, getKgdao().getSimdiki_id());
            pst.setInt(2, s.getU().getUrun_id());
            pst.setLong(3, s.getR().getR_id());
            pst.setLong(4, s.getB().getB_id());
            ResultSet rs = pst.executeQuery();
            int sayac=0;
            while (rs.next()) {
                sayac=sayac+1;
            }
            if(sayac==0){
            PreparedStatement pst2=c.prepareStatement("insert into sepet values(default,?,?,?,?,?)");
            pst2.setInt(1, getKgdao().getSimdiki_id());
            pst2.setInt(2, s.getU().getUrun_id());
            pst2.setInt(3, 1);
            pst2.setLong(4, s.getR().getR_id());
            pst2.setLong(5, s.getB().getB_id());
            pst2.executeUpdate();
            }
            else{
                guncelle(s);
            }
            
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            DBConnection.closeConnection(c);
        }
    }

    public void guncelle(Sepet s) {
try {
            PreparedStatement pst = c.prepareStatement("select * from sepet where kul_id=? and urun_id=? and urun_renk=? and urun_beden=?");
            pst.setInt(1, getKgdao().getSimdiki_id());
            pst.setInt(2, s.getU().getUrun_id());
            pst.setLong(3, s.getR().getR_id());
            pst.setLong(4, s.getB().getB_id());
            ResultSet rs = pst.executeQuery();
            int sepet_id;
            int urun_adedi;
            rs.next();
            sepet_id=rs.getInt("sepet_id");
            urun_adedi=rs.getInt("urun_adedi");
            PreparedStatement pst2 = c.prepareStatement("update sepet set urun_adedi=? where sepet_id=?");
            pst2.setInt(1, urun_adedi+1);
            pst2.setInt(2, sepet_id);
            pst2.executeUpdate();
            } catch (Exception e) {
            System.out.println(e.getMessage());
        }finally {
            DBConnection.closeConnection(c);
        }
    }

    public void delete(Sepet s) {
try {
            c=DBConnection.getConnection();
            PreparedStatement pst = c.prepareStatement("delete from sepet where sepet_id=?");
            pst.setInt(1, s.getSepet_id());
            pst.executeUpdate();

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }finally {
            DBConnection.closeConnection(c);
        }
    }

    public KullaniciDao getKd() {
        if (this.kd == null) {
            this.kd = new KullaniciDao();
        }
        return kd;
    }

    public UrunlerDao getUd() {
        if (this.ud == null) {
            this.ud = new UrunlerDao();
        }
        return ud;
    }

    public RenklerDao getRd() {
        if (this.rd == null) {
            this.rd = new RenklerDao();
        }
        return rd;
    }

    public BedenlerDao getBd() {
        if (this.bd == null) {
            this.bd = new BedenlerDao();
        }
        return bd;
    }

    public KullaniciGirisiDao getKgdao() {
        if(this.kgdao==null)
            this.kgdao=new KullaniciGirisiDao();
        return kgdao;
    }

    public PhotosDao getPd() {
        if(this.pd==null)
            this.pd=new PhotosDao();
        return pd;
    }

   

}
