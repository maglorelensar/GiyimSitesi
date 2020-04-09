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
                kullist.add(new Kullanici(rs.getInt("kul_id"), rs.getString("kul_adi"), rs.getString("kul_sifre")));
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
            st.executeUpdate("delete from kullanici where kul_id=" + k.getKul_id());

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    public void update(Kullanici k) {
        try {
            Statement st = this.getC().createStatement();
          
            st.executeUpdate("Update kullanici set kul_adi='" + k.getKul_adi() + "',kul_sifre='" + k.getKul_sifre() + "' where kul_id='" + k.getKul_id() + "'");
           
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

}
