package controller;

import dao.KullaniciDao;
import entity.Kullanici;
import java.io.Serializable;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;


@Named
@SessionScoped
public class KullaniciController implements Serializable {

    private KullaniciDao kulDao;
    private Kullanici k;
     
    public KullaniciController() {
    }
        
    public String geriDönüs(){
        this.k=new Kullanici();
        return"index";
    }
    public String deleteConfirm(Kullanici k){
        this.k=k;        
        return "confirm_delete";
    }
     public String delete(){
        this.getKulDao().delete(this.k);
        this.k=new Kullanici();
       return "index";
    }
    public void güncelle(){
        this.getKulDao().update(k);
         this.k=new Kullanici();
    }
    public void update(Kullanici k){
        this.k=k;
    }    
   
  
    public Kullanici getK() {
        if(this.k==null)
           this.k=new Kullanici();
        return k;
    }

    public void setK(Kullanici k) {
        this.k = k;
    }

    public KullaniciDao getKulDao() {
        if (this.kulDao == null) {
            this.kulDao = new KullaniciDao();
        }
        return kulDao;
    }

    public void setKulDao(KullaniciDao kulDao) {
        this.kulDao = kulDao;
    }

     public void kayit() {
       //Kullanici kk=new Kullanici(this.getK().getKul_adi(), this.getK().getKul_sifre());
        this.getKulDao().addToList(this.k);
         this.k=new Kullanici();
    }

    public List<Kullanici>getList() {
       
        return this.getKulDao().getList();
     
    }

}
