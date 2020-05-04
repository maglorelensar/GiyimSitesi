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
    private static boolean adminmi=false;
    private Connection c;
    private NavigationBean nvgb;
    public void girisyap(KullaniciGirisi current){
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
                getNvgb().modulepage("kullanicigirisi");
                }
            else {
                pst=c.prepareStatement("select k_sifre from kullanici where k_adi=?");
            pst.setString(1, current.getKk_adi());
            ResultSet rs1 = pst.executeQuery();
            rs1.next();
            String sifre=rs1.getString("k_sifre");
            if(sifre.equals(current.getKk_sifre())){
                 pst=c.prepareStatement("select k_yetki from kullanici where k_adi=?");
            pst.setString(1, current.getKk_adi());
            ResultSet rs2 = pst.executeQuery();
            rs2.next();
            int yetki =rs2.getInt("k_yetki");
                if(yetki==1){//admin
                FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("simdiki_kul",current);
                setAdminmi(true);
                setIcerdemi(true);
                getNvgb().adminpage("admin");
                }
                else//user
                {FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("simdiki_kul",current);
                setAdminmi(false);
                setIcerdemi(true);
                getNvgb().secretpage("secret");
                }
                }
            else{
                FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Şifre Yanlış!!!!", null);
                FacesContext.getCurrentInstance().addMessage(null, msg);
                 System.out.println(isAdminmi());
            getNvgb().modulepage("kullanicigirisi");
            }
            
            }}

         catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    finally {
            DBConnection.closeConnection(c);
        }
    
}

    public NavigationBean getNvgb() {
        if(this.nvgb==null)
            this.nvgb=new NavigationBean();
        return nvgb;
    }
    
    public int getSimdiki_id() {
        return simdiki_id;
    }

    public void setSimdiki_id(int simdiki_id) {
        this.simdiki_id = simdiki_id;
    }

   
    public boolean getIcerdemi() {
        return icerdemi;
    }

    public void setIcerdemi(boolean icerdemi) {
        this.icerdemi = icerdemi;
    }

    public boolean isAdminmi() {
        return adminmi;
    }

    public void setAdminmi(boolean adminmi) {
        this.adminmi = adminmi;
    }
    
    public int getSimdiki_kk() {
    return simdiki_kk;
    }

    public void setSimdiki_kk(int simdiki_kk) {
        this.simdiki_kk = simdiki_kk;
    }

   }