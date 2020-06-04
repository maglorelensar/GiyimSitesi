/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;


public class Sepet {
    private int sepet_id;
    private Kullanici k;
    private Urunler u;
    private int urun_adet;
    private Renkler r;
    private Bedenler b;
    private Photos p;
    
    public Sepet() {
    }

    public Sepet(int sepet_id, Kullanici k, Urunler u, int urun_adet, Renkler r, Bedenler b,Photos p) {
        this.sepet_id = sepet_id;
        this.k = k;
        this.u = u;
        this.urun_adet = urun_adet;
        this.r = r;
        this.b = b;
        this.p=p;
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
        if(this.b==null)
            this.b=new Bedenler();
        return b;
    }

    public void setB(Bedenler b) {
        this.b = b;
    }

    public Renkler getR() {
        if(this.r==null)
            this.r=new Renkler();
        return r;
    }

    public void setR(Renkler r) {
        this.r = r;
    }

    public Urunler getU() {
        if(this.u==null)
            this.u=new Urunler();
        return u;
    }

    public void setU(Urunler u) {
        this.u = u;
    }

    public Photos getP() {
        if(this.p==null)
            this.p=new Photos();
        return p;
    }

    public void setP(Photos p) {
        this.p = p;
    }
    
    
}
