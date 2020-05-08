/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.util.Objects;

/**
 *
 * @author user
 */
public class Kategori {
    private Long kat_id;
    private String kat_adi;

    public Kategori() {
    }

    public Kategori(Long kat_id, String kat_adi) {
        this.kat_id = kat_id;
        this.kat_adi = kat_adi;
    }

    public Long getKat_id() {
        return kat_id;
    }

    public void setKat_id(Long kat_id) {
        this.kat_id = kat_id;
    }

    public String getKat_adi() {
        return kat_adi;
    }

    public void setKat_adi(String kat_adi) {
        this.kat_adi = kat_adi;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 29 * hash + Objects.hashCode(this.kat_id);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Kategori other = (Kategori) obj;
        if (!Objects.equals(this.kat_id, other.kat_id)) {
            return false;
        }
        return true;
    }

   
}
