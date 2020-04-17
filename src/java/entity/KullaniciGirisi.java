/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import dao.*;
import java.io.Serializable;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

/**
 *
 * @author user
 */

@Named(value="kg")
@SessionScoped
public class KullaniciGirisi implements Serializable{
    private int kk_id;
    private String kk_adi;
    private String kk_sifre;
    KullaniciGirisiDao kgd=new KullaniciGirisiDao();

    public int getKk_id() {
        return kk_id;
    }

    public void setKk_id(int kk_id) {
        this.kk_id = kk_id;
    }

    public String getKk_adi() {
        return kk_adi;
    }

    public void setKk_adi(String kk_adi) {
        this.kk_adi = kk_adi;
    }

    public String getKk_sifre() {
        return kk_sifre;
    }

    public void setKk_sifre(String kk_sifre) {
        this.kk_sifre = kk_sifre;
    }

    public KullaniciGirisiDao getKgd() {
        return kgd;
    }

    public void setKgd(KullaniciGirisiDao kgd) {
        this.kgd = kgd;
    }
    
    
    
}