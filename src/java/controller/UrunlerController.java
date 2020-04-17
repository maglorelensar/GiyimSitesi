/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.UrunlerDao;
import entity.Urunler;
import java.io.Serializable;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

@Named(value="urunc")
@SessionScoped
public class UrunlerController implements Serializable{
Urunler urun;
    UrunlerDao urundao;

    public UrunlerController() {
    }
    
public List<Urunler>getListurun() {
        return this.getUrundao().getUrunList();
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
}
