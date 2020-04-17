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

    public List<Sepet> getSepetList() {
        List<Sepet> sepetlist = new ArrayList<>();
        try {
            c = DBConnection.getConnection();
            PreparedStatement pst = c.prepareStatement("select * from sepet");
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                Sepet temp = new Sepet();
                temp.setSepet_id(rs.getInt("sepet_id"));
                temp.setK(getKd().getBaginti(rs.getInt("kul_id")));
                temp.setU(getUd().getBaginti(rs.getInt("urun_id")));
                temp.setUrun_adet(rs.getInt("urun_adedi"));
                temp.setR(getRd().getBaginti(rs.getInt("urun_renk")));
                temp.setB(getBd().getBaginti(rs.getInt("urun_beden")));
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
            PreparedStatement pst = c.prepareStatement("insert into sepet values(default,?,?,?,?,?)");
            pst.setInt(1, 1);//sonra değişecek
            pst.setInt(2, s.getU().getUrun_id());
            pst.setInt(3, 1);//sonra değişecek
            pst.setInt(4, s.getR().getR_id());
            pst.setInt(5, s.getB().getB_id());
            System.out.println("burda");
            pst.executeUpdate();
            System.out.println("burd1a");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            DBConnection.closeConnection(c);
        }
    }

    public void guncelle(Sepet s) {

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

}
