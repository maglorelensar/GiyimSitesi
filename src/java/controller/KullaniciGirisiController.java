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
import util.NavigationBean;

/**
 *
 * @author user
 */
@Named(value="kgc")
@SessionScoped
public class KullaniciGirisiController implements Serializable{
    private KullaniciGirisi kulgi;
    private KullaniciGirisiDao kulgidao;
   private NavigationBean nvgb;
    
    public void girisyap() throws SQLException{
        if(this.kulgi==null){
        this.kulgi=new KullaniciGirisi();}
        this.getKulgidao().girisyap(kulgi);
    }
    public String yonlendir() throws SQLException{
       this.girisyap();
    if(getKulgidao().getIcerdemi()==true&&getKulgidao().isAdminmi()==true){
    return getNvgb().adminpage("admin");
    }
    else if(getKulgidao().getIcerdemi()==true&&getKulgidao().isAdminmi()==false)
    {
    return getNvgb().secretpage("secret");
    }
    else{
        return getNvgb().modulepage("kullanicigirisi");
    }
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
       public boolean isAdminmi() {
     return getKulgidao().isAdminmi();
    }

    public NavigationBean getNvgb() {
        if(this.nvgb==null)
this.nvgb=new NavigationBean();
            return nvgb;
    }

}

