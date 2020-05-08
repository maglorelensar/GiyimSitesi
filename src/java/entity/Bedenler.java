
package entity;

import java.util.Objects;



public class Bedenler {
    private Long b_id;
    private String b_tipi;

    public Bedenler() {
    }

    
    public Bedenler(Long b_id, String b_tipi) {
        this.b_id = b_id;
        this.b_tipi = b_tipi;
    }
    

    public Long getB_id() {
        return b_id;
    }

    public void setB_id(Long b_id) {
        this.b_id = b_id;
    }

    public String getB_tipi() {
        return b_tipi;
    }

    public void setB_tipi(String b_tipi) {
        this.b_tipi = b_tipi;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 59 * hash + Objects.hashCode(this.b_id);
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
        final Bedenler other = (Bedenler) obj;
        if (!Objects.equals(this.b_id, other.b_id)) {
            return false;
        }
        return true;
    }

    
    
}
