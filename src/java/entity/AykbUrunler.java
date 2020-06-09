package entity;

import java.util.ArrayList;
import java.util.List;


public class AykbUrunler {
    private int aurn_id;    
    private String aurn_adi;
    private double aurn_fiyat;
    private int aurn_adedi;    
    private Renkler renk;
    private AyakkabiNo ayakkabino;
   private List<Markalar> urunmarkalari;
    
    public AykbUrunler() {
    }

    public AykbUrunler(int aurn_id, String aurn_adi, double aurn_fiyat, int aurn_adedi, Renkler renk, AyakkabiNo ayakkabino) {
        this.aurn_id = aurn_id;
        this.aurn_adi = aurn_adi;
        this.aurn_fiyat = aurn_fiyat;
        this.aurn_adedi = aurn_adedi;
        this.renk = renk;
        this.ayakkabino = ayakkabino;
    }

    public int getAurn_id() {
        return aurn_id;
    }

    public void setAurn_id(int aurn_id) {
        this.aurn_id = aurn_id;
    }
   
    

    public String getAurn_adi() {
        return aurn_adi;
    }

    public void setAurn_adi(String aurn_adi) {
        this.aurn_adi = aurn_adi;
    }

    public double getAurn_fiyat() {
        return aurn_fiyat;
    }

    public void setAurn_fiyat(double aurn_fiyat) {
        this.aurn_fiyat = aurn_fiyat;
    }

    public int getAurn_adedi() {
        return aurn_adedi;
    }

    public void setAurn_adedi(int aurn_adedi) {
        this.aurn_adedi = aurn_adedi;
    }

    public AyakkabiNo getAyakkabino() {
        if(this.ayakkabino==null)
            this.ayakkabino=new AyakkabiNo();
        return ayakkabino;
    }

    public void setAyakkabino(AyakkabiNo ayakkabino) {
        this.ayakkabino = ayakkabino;
    }
    
    
    public Renkler getRenk() {
        if(this.renk==null)
            this.renk=new Renkler();
        return renk;
    }

    public void setRenk(Renkler renk) {
        this.renk = renk;
    }
    
    
    public List<Markalar> getUrunmarkalari() {
          if(this.urunmarkalari==null)
            this.urunmarkalari=new ArrayList<>();
        return urunmarkalari;
    }

    public void setUrunmarkalari(List<Markalar> urunmarkalari) {
        this.urunmarkalari = urunmarkalari;
    }

    

    
}

