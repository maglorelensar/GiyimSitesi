/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;


/**
 *
 * @author user
 */
public class Photos {
    private int d_id;
    private String dosyayolu;
    private String dosyaadi;
    private String dosyatipi;

    public String getDosyayolu() {
        return dosyayolu;
    }

    public void setDosyayolu(String dosyayolu) {
        this.dosyayolu = dosyayolu;
    }

    public String getDosyaadi() {
        return dosyaadi;
    }

    public void setDosyaadi(String dosyaadi) {
        this.dosyaadi = dosyaadi;
    }

    public String getDosyatipi() {
        return dosyatipi;
    }

    public void setDosyatipi(String dosyatipi) {
        this.dosyatipi = dosyatipi;
    }

    public int getD_id() {
        return d_id;
    }

    public void setD_id(int d_id) {
        this.d_id = d_id;
    }
    
}
