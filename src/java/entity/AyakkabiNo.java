package entity;

import java.util.Objects;


public class AyakkabiNo {
    private Long ano_id;
    private int a_no;

    public AyakkabiNo() {
    }

    public AyakkabiNo(Long ano_id, int a_no) {
        this.ano_id = ano_id;
        this.a_no = a_no;
    }

    public Long getAno_id() {
        return ano_id;
    }

    public void setAno_id(Long ano_id) {
        this.ano_id = ano_id;
    }

    public int getA_no() {
        return a_no;
    }

    public void setA_no(int a_no) {
        this.a_no = a_no;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 19 * hash + Objects.hashCode(this.ano_id);
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
        final AyakkabiNo other = (AyakkabiNo) obj;
        if (!Objects.equals(this.ano_id, other.ano_id)) {
            return false;
        }
        return true;
    }

    

 

   

}
