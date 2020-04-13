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

/**
 *
 * @author LENOVO
 */
@Named
@SessionScoped
public class SepetController implements Serializable{

    private SepetDao sDao;
    private List<Sepet> sepetlist;
    private Sepet s;

    public SepetDao getsDao() {
        if(this.sDao==null)
        this.sDao=new SepetDao();
        return sDao;
    }

    public void setsDao(SepetDao sDao) {
        this.sDao = sDao;
    }

    public List<Sepet> getSepetlist() {
        this.sepetlist=this.getsDao().getList();
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

    public void setS(Sepet s) {
        this.s = s;
    }

}
