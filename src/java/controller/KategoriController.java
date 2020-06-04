/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.*;
import entity.*;
import java.io.Serializable;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

/**
 *
 * @author user
 */
@Named(value="katc")
@SessionScoped
public class KategoriController implements Serializable{
    Kategori kat;
    KategoriDao katdao;
    
    public KategoriController() {
    }
public List<Kategori>getListkategori() {
        return this.getKatdao().getKategoriList();
    }
    
public void kaydetkategori() {
        this.getKatdao().add(this.kat);
         this.kat=new Kategori();
    }

public void guncellekategori(){
        this.getKatdao().guncelle(this.kat);
         this.kat=new Kategori();
    }
public void formtemizle(){
this.kat=new Kategori();
}
    public void updatekategori(Kategori ka){
      this.kat=ka;  
    } 
    public void deletekategori(Kategori ka){
        this.getKatdao().delete(ka);
        
    }
    public Kategori getKat() {
        if(this.kat==null)
            this.kat=new Kategori();
        return kat;
    }

    public void setKat(Kategori kat) {
        this.kat = kat;
    }

    public KategoriDao getKatdao() {
        if(this.katdao==null)
            this.katdao=new KategoriDao();
        return katdao;
    }

    public void setKatdao(KategoriDao katdao) {
        this.katdao = katdao;
    }
    
}
