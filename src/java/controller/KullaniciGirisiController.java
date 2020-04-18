/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.*;
import entity.*;
import java.io.Serializable;
import java.sql.SQLException;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

/**
 *
 * @author user
 */
@Named(value="kgc")
@SessionScoped
public class KullaniciGirisiController implements Serializable{
    private KullaniciGirisi kulgi;
    private KullaniciGirisiDao kulgidao;
    private boolean icerde=false;
    
    public String girisyap() throws SQLException{
        if(this.kulgi==null){
        this.kulgi=new KullaniciGirisi();}
        this.getKulgidao().girisyap(kulgi);
    return "/secret/secret?faces-redirect=true";   
    }

    public KullaniciGirisi getKulgi() {
        if(this.kulgi==null){
        this.kulgi=new KullaniciGirisi();
        }
        return kulgi;
    }

    public void setKulgi(KullaniciGirisi kulgi) {
        this.kulgi = kulgi;
    }

    public KullaniciGirisiDao getKulgidao() {
        if(this.kulgidao==null){
        this.kulgidao=new KullaniciGirisiDao();}
        return kulgidao;
    }

    public void setKulgidao(KullaniciGirisiDao kulgidao) {
        this.kulgidao = kulgidao;
    }

    public boolean isIcerde() {
     return getKulgidao().getIcerdemi();
    }

}

