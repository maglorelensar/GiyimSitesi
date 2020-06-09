
package entity;

import java.util.ArrayList;
import java.util.List;


public class Urunler {
    private int urun_id;
    private String urun_adi;
    private double urun_fiyat;
    private int urun_stok_adedi;
    private Renkler renk;
    private Bedenler beden;
    private List<Kategori> urunkategorileri;
    
public Urunler() {
    }

    public Urunler(int urun_id, String urun_adi, double urun_fiyat, int urun_stok_adedi, Renkler renk, Bedenler beden) {
        this.urun_id = urun_id;
        this.urun_adi = urun_adi;
        this.urun_fiyat = urun_fiyat;
        this.urun_stok_adedi = urun_stok_adedi;
        this.renk = renk;
        this.beden = beden;
    }

    

    public Renkler getRenk() {
        if(this.renk==null)
            this.renk=new Renkler();
        return renk;
    }

    public void setRenk(Renkler renk) {
        this.renk = renk;
    }

    public Bedenler getBeden() {
        if(this.beden==null)
            this.beden=new Bedenler();
        return beden;
    }

    public void setBeden(Bedenler beden) {
        this.beden = beden;
    }
    
    public int getUrun_id() {
        return urun_id;
    }

    public void setUrun_id(int urun_id) {
        this.urun_id = urun_id;
    }

    public String getUrun_adi() {
        return urun_adi;
    }

    public void setUrun_adi(String urun_adi) {
        this.urun_adi = urun_adi;
    }

    public double getUrun_fiyat() {
        return urun_fiyat;
    }

    public void setUrun_fiyat(double urun_fiyat) {
        this.urun_fiyat = urun_fiyat;
    }

    public int getUrun_stok_adedi() {
        return urun_stok_adedi;
    }

    public void setUrun_stok_adedi(int urun_stok_adedi) {
        this.urun_stok_adedi = urun_stok_adedi;
    }

    

    public List<Kategori> getUrunkategorileri() {
        if(this.urunkategorileri==null)
            this.urunkategorileri=new ArrayList<>();
        return urunkategorileri;
    }

    public void setUrunkategorileri(List<Kategori> urunkategorileri) {
        this.urunkategorileri = urunkategorileri;
    }

    
   
}
