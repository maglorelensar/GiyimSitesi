/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entity.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import util.DBConnection;

/**
 *
 * @author LENOVO
 */
public class SepetDao {

    private Connection c;
    private KullaniciDao kd;

    public KullaniciDao getKd() {
        if (this.kd == null) {
            this.kd = new KullaniciDao();
        }
        return kd;
    }

    public Connection getC() {
        this.c = new DBConnection().getConnection();
        return c;
    }

    public List<Sepet> getList() {
        List<Sepet> kullist = new ArrayList<>();
        try {
            Statement st = this.getC().createStatement();
            ResultSet rs = st.executeQuery("select * from sepet");

            while (rs.next()) {
                kullist.add(new Sepet(rs.getInt("sepet_id"), rs.getInt("urun_adedi"),getKd().getBaginti(rs.getInt("kul_id"))));

            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return kullist;
    }

}
