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
import javax.inject.Inject;
import javax.inject.Named;

@Named(value="urunc")
@SessionScoped
public class UrunlerController implements Serializable{
private Urunler urun;
   private UrunlerDao urundao;


    public UrunlerController() {
    }
    @Inject
    private KategoriController katcon;
public List<Urunler>getListurun() {
        return this.getUrundao().getUrunLists();
    }
public void filtre(Kategori k){
this.getUrundao().setUrunlist(null);
filtrele(k);
}
     public List<Urunler> filtrele(Kategori k){
         if(k==null){
         return this.getUrundao().getUrunLists();
         }
         else{
         this.getUrundao().setUrunlist(null);
         this.getUrundao().setUrunlist(this.getUrundao().getFiltrele(k));
         return this.getUrundao().getUrunlist();
         }
    }
    
public void kaydeturun() {
        this.getUrundao().add(this.urun);
         this.urun=new Urunler();
    }

public void guncelleurun(){
        this.getUrundao().guncelle(this.urun);
         this.urun=new Urunler();
    }
    public void updateurun(Urunler u){
        this.urun=u;
    } 
    public void formtemizle(){
this.urun=new Urunler();
}
    public void deleteurun(Urunler u){
        this.getUrundao().delete(u);
        
    }    

    public Urunler getUrun() {
        if(this.urun==null)
            this.urun=new Urunler();
        return urun;
    }

    public UrunlerDao getUrundao() {
        if(this.urundao==null)
            this.urundao=new UrunlerDao();
        return urundao;
    }

    public KategoriController getKatcon() {
        if(this.katcon==null)
            this.katcon=new KategoriController();
        return katcon;
    }

    
}
