/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.RenklerDao;
import entity.Renkler;
import java.io.Serializable;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

@Named(value="renkc")
@SessionScoped
public class RenklerController implements Serializable{
    Renkler renk;
    RenklerDao renkdao;
    public List<Renkler>getListrenk() {
        return this.getRenkdao().getRenkList();
    }
    
public void kaydetrenk() {
        this.getRenkdao().add(this.renk);
         this.renk=new Renkler();
    }

public void guncellerenk(){
        this.getRenkdao().guncelle(this.renk);
         this.renk=new Renkler();
    }
public void formtemizle(){
this.renk=new Renkler();
}
    public void updaterenk(Renkler r){
        this.renk=r;
    } 
    public void deleterenk(Renkler r){
        this.getRenkdao().delete(r);
        
    }
    
    public Renkler getRenk() {
        if(this.renk==null)
            this.renk=new Renkler();
        return renk;
    }

    public RenklerDao getRenkdao() {
        if(this.renkdao==null)
            this.renkdao=new RenklerDao();
        return renkdao;
    }
}
