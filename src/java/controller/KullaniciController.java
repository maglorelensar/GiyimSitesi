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
   
     public void delete(Kullanici k){
        this.getKulDao().delete(k);
        this.k=new Kullanici();
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
        this.getKulDao().addToList(this.k);
         this.k=new Kullanici();
    }

    public List<Kullanici>getList() {
       
        return this.getKulDao().getList();
     
    }
 public Kullanici getBaginti(int sepet_id) {
       
        return this.getKulDao().getBaginti(sepet_id);
     
    }
}
