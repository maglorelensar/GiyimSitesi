package controller;

import dao.KullaniciDao;
import dao.KullaniciGirisiDao;
import entity.Kullanici;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;


@Named
@SessionScoped
public class KullaniciController implements Serializable {

    private KullaniciDao kulDao;
    private Kullanici k;
     KullaniciGirisiDao kgd;
     private List<Kullanici> aramalist;
     private int page=1;
private int pageSize=5;
private int pageCount;
private String aranan;
    public KullaniciController() {
    }
    public void ileri(){
        if(this.page==this.getPageCount())
            this.page=1;
        else
    this.page++;}
   public void geri(){
       if(this.page==1)
           this.page=this.getPageCount();
       else
   this.page--;}
     public void delete(Kullanici k){
        this.getKulDao().delete(k);
        this.k=new Kullanici();
    }
    public void güncelle(){
        this.getKulDao().update(k);
         this.k=new Kullanici();
    }
     public void ara(){
         this.setAramalist(null);
       this.setAramalist(this.getKulDao().ara(aranan)); ;
    }
    public void güncelle2(){
        k.setKul_id(getKgd().getSimdiki_id());
        this.getKulDao().update2(k);
         this.k=new Kullanici();
    }
    public void update(Kullanici k){
        this.k=k;
    }    
   public void formutemizle(){
        this.k=new Kullanici();
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
       
     return this.getKulDao().getList(page,pageSize);
     
    }
    
 public Kullanici getBaginti(int sepet_id) {
       
        return this.getKulDao().getBaginti(sepet_id);
     
    }

    public KullaniciGirisiDao getKgd() {
        if(this.kgd==null)
            this.kgd=new KullaniciGirisiDao();
        return kgd;
    }
 public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getPageCount() {
        this.pageCount=(int)Math.ceil(this.getKulDao().count()/(double)pageSize);
        return pageCount;
    }

    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }

    public List<Kullanici> getAramalist() {
        if(this.aramalist==null)
            this.aramalist=new ArrayList<>();
        return aramalist;
    }

    public void setAramalist(List<Kullanici> aramalist) {
        this.aramalist = aramalist;
    }

    public String getAranan() {
        return aranan;
    }

    public void setAranan(String aranan) {
        this.aranan = aranan;
    }
}
