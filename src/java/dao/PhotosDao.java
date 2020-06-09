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

/**
 *
 * @author user
 */
public class PhotosDao {
    private Connection c;
    public List<Photos> pListgetir(){
    List <Photos> pList=new ArrayList<>();
    try {
            c=DBConnection.getConnection();
            PreparedStatement pst = c.prepareStatement("select * from photos");
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                Photos pp=new Photos();
                pp.setD_id(rs.getInt("photo_id"));
                pp.setDosyayolu(rs.getString("photo_path"));
                pp.setDosyaadi(rs.getString("photo_name"));
                pp.setDosyatipi(rs.getString("photo_type"));
                pList.add(pp);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }finally {
            DBConnection.closeConnection(c);
        }
    return pList;
    }
    public void ekle(Photos yeni){
    try {
            c=DBConnection.getConnection();
            PreparedStatement pst = c.prepareStatement("insert into photos values(default,?,?,?)");
            pst.setString(1, yeni.getDosyayolu());
            pst.setString(2, yeni.getDosyaadi());
            pst.setString(3, yeni.getDosyatipi());
              pst.executeUpdate();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }finally {
            DBConnection.closeConnection(c);
        }
    }

    public Photos getBaginti(int id) {
        Photos pht=new Photos();
        try {
            c=DBConnection.getConnection();
            PreparedStatement pst = c.prepareStatement("select * from photos where photo_id="+id);
            ResultSet rs = pst.executeQuery();
            rs.next();
             pht.setD_id(rs.getInt("photo_id"));
             pht.setDosyayolu(rs.getString("photo_path"));            
             pht.setDosyaadi(rs.getString("photo_name"));
             pht.setDosyatipi(rs.getString("photo_type"));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }finally {
            DBConnection.closeConnection(c);
        }
        return pht;
    }
    public void sil(Photos sil){
    try {
            c=DBConnection.getConnection();
            PreparedStatement pst = c.prepareStatement("delete from photos where photo_id=?");
            pst.setInt(1, sil.getD_id());
              pst.executeUpdate();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }finally {
            DBConnection.closeConnection(c);
        }
    }
}
