/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entity.Renkler;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import util.DBConnection;


public class RenklerDao {
private Connection c;
    public List<Renkler> getRenkList() {
        List<Renkler> renklist = new ArrayList<>();
        try {
            c=DBConnection.getConnection();
            PreparedStatement pst = c.prepareStatement("select * from renkler");
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                renklist.add(new Renkler(rs.getInt("r_id"), rs.getString("r_adi")));
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }finally {
            DBConnection.closeConnection(c);
        }
        return renklist;
    }
    public Renkler getRenkList(int id) {
        Renkler rnk=new Renkler();
        try {
            c=DBConnection.getConnection();
            PreparedStatement pst = c.prepareStatement("select * from renkler where r_id="+id);
            ResultSet rs = pst.executeQuery();
            rs.next();
            rnk.setR_id(rs.getInt("r_id"));
            rnk.setR_adi(rs.getString("r_adi"));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }finally {
            DBConnection.closeConnection(c);
        }
        return rnk;
    }

    public void add(Renkler renk) {
       try {
            c=DBConnection.getConnection();
            PreparedStatement pst = c.prepareStatement("insert into renkler values(default,?)");
            pst.setString(1, renk.getR_adi());    
            pst.executeUpdate();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        finally {
            DBConnection.closeConnection(c);
        }
    }

    public void guncelle(Renkler renk) {
         try {
            c=DBConnection.getConnection();
            PreparedStatement pst = c.prepareStatement("Update renkler set r_adi=? where r_id=?");
            pst.setString(1, renk.getR_adi());
            pst.setInt(2, renk.getR_id());
            pst.executeUpdate();
           
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }finally {
            DBConnection.closeConnection(c);
        }
    }

    public void delete(Renkler r) {
        try {
            c=DBConnection.getConnection();
            PreparedStatement pst = c.prepareStatement("delete from renkler where r_id=?");
            pst.setInt(1, r.getR_id());
            pst.executeUpdate();

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }finally {
            DBConnection.closeConnection(c);
        }
    }
    
    public Renkler getBaginti(int renk_id) {
       Renkler renk = null;
        try {
            c=DBConnection.getConnection();
            PreparedStatement pst = c.prepareStatement("select * from renkler where r_id="+renk_id);
            ResultSet rs = pst.executeQuery();
            rs.next();
            renk=new Renkler();
            renk.setR_id(rs.getInt("r_id"));
            renk.setR_adi(rs.getString("r_adi"));
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }finally {
            DBConnection.closeConnection(c);
        }
        return renk;
    }
    
}
