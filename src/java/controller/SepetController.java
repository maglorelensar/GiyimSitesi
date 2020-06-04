/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.SepetDao;
import java.io.Serializable;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import entity.*;
import java.util.List;


@Named(value="sptc")
@SessionScoped
public class SepetController implements Serializable{

    private SepetDao sDao;
    private List<Sepet> sepetlist;
    private Sepet s;
    public List<Sepet>getListsepet() {
        return this.getsDao().getSepetList();
    }
    
public void sepeteekle(Urunler u) {
    Sepet s=new Sepet();
    s.setR(u.getRenk());
    s.setB(u.getBeden());
    s.setU(u);
        this.getsDao().add(s);
         this.s=new Sepet();
    }

public void guncellesepet(Sepet s){
        this.getsDao().guncelle(s);
         this.s=new Sepet();
    }
    public void sepettensil(Sepet s){
        this.getsDao().delete(s);
        
    }
    
    public SepetDao getsDao() {
        if(this.sDao==null)
        this.sDao=new SepetDao();
        return sDao;
    }

    public List<Sepet> getSepetlist() {
        this.sepetlist=this.getsDao().getSepetList();
        return sepetlist;
    }

    public void setSepetlist(List<Sepet> sepetlit) {
        this.sepetlist = sepetlit;
    }

    public Sepet getS() {
        if(this.s==null)
        this.s=new Sepet();
        return s;
    }


   
    
}
