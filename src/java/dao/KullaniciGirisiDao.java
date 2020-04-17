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
import java.sql.SQLException;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import util.*;

/**
 *
 * @author user
 */
public class KullaniciGirisiDao {
    
    private static int simdiki_id; 
    private static int simdiki_kk; 
    private static boolean icerdemi=false;
    private Connection c;
    private static boolean kontrol;
    public String girisyap(KullaniciGirisi current){
    try {
        c=DBConnection.getConnection();
        PreparedStatement pst=c.prepareStatement("select * from kullanici where k_adi=?");
        pst.setString(1,current.getKk_adi());
          ResultSet rs = pst.executeQuery();
            String b = null;
            while (rs.next()) {
                String tmp;
                tmp = rs.getString("k_adi");
                b = tmp;
                int tmp1;
                tmp1=rs.getInt("k_id");
                setSimdiki_id(tmp1);
                }if (b == null) {
                FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Sistemde Bu Adda Biri Mevcut Değil!!!!", null);
                FacesContext.getCurrentInstance().addMessage(null, msg);
                return "/kullanicigirisi?faces-redirect=true";
                }
            else {
                pst=c.prepareStatement("select k_sifre from kullanici where k_adi=?");
            pst.setString(1, current.getKk_adi());
            ResultSet rs1 = pst.executeQuery();
            rs1.next();
            String sifre=rs1.getString("k_sifre");
            if(sifre.equals(current.getKk_sifre())){
            pst=c.prepareStatement("select k_sifre from kullanici where k_adi=?");
            pst.setString(1, current.getKk_adi());
            ResultSet rs2 = pst.executeQuery();
            rs2.next();
                setKontrol(false);
                FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("simdiki_kul",current);
                setIcerdemi(true);
                return "/secret/secret?faces-redirect=true";
                }
            else{
                FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Şifre Yanlış!!!!", null);
                FacesContext.getCurrentInstance().addMessage(null, msg);
            return "/kullanicigirisi?faces-redirect=true";
            }
            
            }}

         catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    finally {
            DBConnection.closeConnection(c);
        }
    return "/secret/secret?faces-redirect=true";
}
    
    public int getSimdiki_id() {
        return simdiki_id;
    }

    public void setSimdiki_id(int simdiki_id) {
        this.simdiki_id = simdiki_id;
    }

    public boolean isKontrol() {
        return kontrol;
    }

    public void setKontrol(boolean kontrol) {
        this.kontrol = kontrol;
    }
    public boolean getIcerdemi() {
        return icerdemi;
    }

    public void setIcerdemi(boolean icerdemi) {
        this.icerdemi = icerdemi;
    }
    
    public int getSimdiki_kk() {
    return simdiki_kk;
    }

    public void setSimdiki_kk(int simdiki_kk) {
        this.simdiki_kk = simdiki_kk;
    }

   }