/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entity.Kategori;
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
public class KategoriDao {
    
private Connection c;
private UrunlerDao urdao;
    public List<Kategori> getKategoriList() {
       List<Kategori> kategorilist = new ArrayList<>();
        try {
            c=DBConnection.getConnection();
            PreparedStatement pst = c.prepareStatement("select * from kategori");
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                kategorilist.add(new Kategori(rs.getLong("kategori_id"), rs.getString("kategori_adi")));
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }finally {
            DBConnection.closeConnection(c);
        }
        return kategorilist;
    }
public Kategori getKategori(Long id) {
        Kategori kate=null;
        try {
            c=DBConnection.getConnection();
            PreparedStatement pst = c.prepareStatement("select * from kategori where kategori_id="+id);
            ResultSet rs = pst.executeQuery();
            rs.next();
            kate=new Kategori();
             kate.setKat_id(rs.getLong("kategori_id"));
             kate.setKat_adi(rs.getString("kategori_adi"));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }finally {
            DBConnection.closeConnection(c);
        }
        return kate;
    }
    
    
    
    public void add(Kategori kat) {
        try {
            c=DBConnection.getConnection();
            PreparedStatement pst = c.prepareStatement("insert into kategori values(default,?)");
            pst.setString(1, kat.getKat_adi());    
            pst.executeUpdate();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        finally {
            DBConnection.closeConnection(c);
        }
    }

    public void guncelle(Kategori kat) {
        try {
            c=DBConnection.getConnection();
            PreparedStatement pst = c.prepareStatement("Update kategori set kategori_adi=? where kategori_id=?");
            pst.setString(1, kat.getKat_adi());
            pst.setLong(2, kat.getKat_id());
            pst.executeUpdate();
           
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }finally {
            DBConnection.closeConnection(c);
        }
    }

    public void delete(Kategori ka) {
    try {
            c=DBConnection.getConnection();
            PreparedStatement pst = c.prepareStatement("delete from kategori where kategori_id=?");
            pst.setLong(1, ka.getKat_id());
            pst.executeUpdate();

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }finally {
            DBConnection.closeConnection(c);
        }   
    }
 public List<Kategori> getUrunKategorisi(int urun_id) {
        List<Kategori> urunkategorisi =new ArrayList<>();
        try {
            c=DBConnection.getConnection();
            PreparedStatement pst = c.prepareStatement("select * from urun_kategori where urun_id=?");
            pst.setInt(1, urun_id);
            ResultSet rs=pst.executeQuery();
            while(rs.next()){
            urunkategorisi.add(this.getKategori(rs.getLong("kategori_id")));
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }finally {
            DBConnection.closeConnection(c);
        }   
        return urunkategorisi;
    }

   

    public UrunlerDao getUrdao() {
        if(this.urdao==null)
            this.urdao=new UrunlerDao();
        return urdao;
    }
    
}
