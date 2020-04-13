/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

/**
 *
 * @author LENOVO
 */
public class Sepet {
    private int sepet_id;
    private int urun_adet;
    private Kullanici k;
    private Bedenler b;
    private Renkler r;
    private Urunler u;

    public Sepet() {
    }

    public Sepet(int sepet_id,  int urun_adet,Kullanici k) {
        this.sepet_id = sepet_id;
        this.urun_adet = urun_adet;
       this.k=k;
      
    }

  
   
    public Sepet(int sepet_id, int urun_adet, Kullanici k, Bedenler b, Renkler r, Urunler u) {
        this.sepet_id = sepet_id;
        this.urun_adet = urun_adet;
        this.k = k;
        this.b = b;
        this.r = r;
        this.u = u;
    }

    public int getSepet_id() {
        return sepet_id;
    }

    public void setSepet_id(int sepet_id) {
        this.sepet_id = sepet_id;
    }

    public int getUrun_adet() {
        return urun_adet;
    }

    public void setUrun_adet(int urun_adet) {
        this.urun_adet = urun_adet;
    }

    public Kullanici getK() {
        if(this.k==null)
            this.k=new Kullanici();
        return k;
    }

    public void setK(Kullanici k) {
        this.k = k;
    }

    public Bedenler getB() {
        return b;
    }

    public void setB(Bedenler b) {
        this.b = b;
    }

    public Renkler getR() {
        return r;
    }

    public void setR(Renkler r) {
        this.r = r;
    }

    public Urunler getU() {
        return u;
    }

    public void setU(Urunler u) {
        this.u = u;
    }
    
    
}
