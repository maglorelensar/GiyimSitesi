
package entity;

import java.util.Objects;


public class Renkler {
    private Long r_id;
    private String r_adi;

    public Renkler() {
    }

    public Renkler(Long r_id, String r_adi) {
        this.r_id = r_id;
        this.r_adi = r_adi;
    }

    
    public Long getR_id() {
        return r_id;
    }

    public void setR_id(Long r_id) {
        this.r_id = r_id;
    }

    public String getR_adi() {
        return r_adi;
    }

    public void setR_adi(String r_adi) {
        this.r_adi = r_adi;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + Objects.hashCode(this.r_id);
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
        final Renkler other = (Renkler) obj;
        if (!Objects.equals(this.r_id, other.r_id)) {
            return false;
        }
        return true;
    }

    
}
