package dao;

import entity.Kullanici;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import util.DBConnection;


public class KullaniciDao {

    private Connection c;
 
    public List<Kullanici> getList() {
        List<Kullanici> kullist = new ArrayList<>();
        try {
            c=DBConnection.getConnection();
            PreparedStatement pst = c.prepareStatement("select * from kullanici");
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                kullist.add(new Kullanici(rs.getInt("k_id"), rs.getString("k_adi"), rs.getString("k_sifre")));
                
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }finally {
            DBConnection.closeConnection(c);
        }
        return kullist;
    }

    public void addToList(Kullanici k) {
        
        try {
            c=DBConnection.getConnection();
            PreparedStatement pst = c.prepareStatement("insert into kullanici values(default,?,?,?)");
            pst.setString(1, k.getKul_adi());       
            pst.setString(2, k.getKul_sifre());
            pst.setInt(3, 1);
            pst.executeUpdate();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        finally {
            DBConnection.closeConnection(c);
        }
    }

    public void delete(Kullanici k) {

        try {
            c=DBConnection.getConnection();
            PreparedStatement pst = c.prepareStatement("delete from kullanici where k_id=?");
            pst.setInt(1, k.getKul_id());
            pst.executeUpdate();

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }finally {
            DBConnection.closeConnection(c);
        }

    }

    public void update(Kullanici k) {
        try {
            c=DBConnection.getConnection();
            PreparedStatement pst = c.prepareStatement("Update kullanici set k_adi=?,k_sifre=? where k_id=?");
            pst.setString(1, k.getKul_adi());
            pst.setString(2, k.getKul_sifre());
            pst.setInt(3, k.getKul_id());
            pst.executeUpdate();
           
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }finally {
            DBConnection.closeConnection(c);
        }
    }

    public Kullanici getBaginti(int kullanici_id) {
       Kullanici kul = null;
        try {
            c=DBConnection.getConnection();
            PreparedStatement pst = c.prepareStatement("select * from kullanici where k_id="+kullanici_id);
            ResultSet rs = pst.executeQuery();
            rs.next();
            kul=new Kullanici();
            kul.setKul_id(rs.getInt("k_id"));
            kul.setKul_adi(rs.getString("k_adi"));
            kul.setKul_sifre(rs.getString("k_sifre"));
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }finally {
            DBConnection.closeConnection(c);
        }
        return kul;
    }

}
