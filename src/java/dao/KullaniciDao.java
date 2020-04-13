package dao;

import entity.Kullanici;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import util.DBConnection;

/**
 * CRUD create read update delete
 *
 * @author LENOVO
 */
public class KullaniciDao {

   // private DBConnection db;
    private Connection c;
    //private Kullanici k;

//    public Kullanici getK() {
//        this.k=new Kullanici();
//        return k;
//    }
    

      public Connection getC() {
        this.c=new DBConnection().getConnection();
        return c;
    }

//    public DBConnection getDb() {
//        if (this.db == null) {
//            this.db = new DBConnection();
//        }
//        return db;
//    }

  
    public List<Kullanici> getList() {
        List<Kullanici> kullist = new ArrayList<>();
        try {
            Statement st = this.getC().createStatement();
            ResultSet rs = st.executeQuery("select * from kullanici");

            while (rs.next()) {
                kullist.add(new Kullanici(rs.getInt("k_id"), rs.getString("k_adi"), rs.getString("k_sifre")));
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return kullist;
    }

    public void addToList(Kullanici k) {
        List<Kullanici> kullist = new ArrayList<>();
        try {
            Statement st = this.getC().createStatement();
            st.executeUpdate("insert into kullanici values(default,'" + k.getKul_adi() + "','" + k.getKul_sifre() + "');");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        kullist.add(k);
    }

    public void delete(Kullanici k) {

        try {
            Statement st = this.getC().createStatement();
            st.executeUpdate("delete from kullanici where k_id=" + k.getKul_id());

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    public void update(Kullanici k) {
        try {
            Statement st = this.getC().createStatement();
          
            st.executeUpdate("Update kullanici set k_adi='" + k.getKul_adi() + "',k_sifre='" + k.getKul_sifre() + "' where k_id='" + k.getKul_id() + "'");
           
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public Kullanici getBaginti(int kullanici_id) {
       Kullanici kul = null;
        try {
            Statement st = this.getC().createStatement();
            ResultSet rs = st.executeQuery("select * from kullanici where k_id="+kullanici_id);
            rs.next();
            
            kul=new Kullanici();

            kul.setKul_id(rs.getInt("k_id"));
            kul.setKul_adi(rs.getString("k_adi"));
            kul.setKul_sifre(rs.getString("k_sifre"));
            
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return kul;
    }

}
