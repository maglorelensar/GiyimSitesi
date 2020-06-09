package entity;

import java.util.Objects;


public class Markalar {
    private Long marka_id;
    private String marka_adi;

    public Markalar() {
    }

    
    public Markalar(Long marka_id, String marka_adi) {
        this.marka_id = marka_id;
        this.marka_adi = marka_adi;
    }

    
    public Long getMarka_id() {
        return marka_id;
    }

    public void setMarka_id(Long marka_id) {
        this.marka_id = marka_id;
    }

    public String getMarka_adi() {
        return marka_adi;
    }

    public void setMarka_adi(String marka_adi) {
        this.marka_adi = marka_adi;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 23 * hash + Objects.hashCode(this.marka_id);
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
        final Markalar other = (Markalar) obj;
        if (!Objects.equals(this.marka_id, other.marka_id)) {
            return false;
        }
        return true;
    }
    
    
}
