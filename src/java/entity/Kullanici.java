
package entity;


public class Kullanici {
    private int kul_id;
    private String kul_adi;
    private String kul_sifre;
    private String eski_sifre;

    public Kullanici() {
    }

    public Kullanici(int kul_id, String kul_adi, String kul_sifre) {
        this.kul_id = kul_id;
        this.kul_adi = kul_adi;
        this.kul_sifre = kul_sifre;
    }

   public void yazdir(){
       System.out.println(this.kul_id);
   }
   
    public String getKul_adi() {
        return kul_adi;
    }

    public void setKul_adi(String kul_adi) {
        this.kul_adi = kul_adi;
    }

    public String getKul_sifre() {
        return kul_sifre;
    }

    public void setKul_sifre(String kul_sifre) {
        this.kul_sifre = kul_sifre;
    }

    public int getKul_id() {
        return kul_id;
    }

    public void setKul_id(int kul_id) {
        this.kul_id = kul_id;
    }

    public String getEski_sifre() {
        return eski_sifre;
    }

    public void setEski_sifre(String eski_sifre) {
        this.eski_sifre = eski_sifre;
    }

    @Override
    public String toString() {
        return "Kullanici{" + "kul_id=" + kul_id + ", kul_adi=" + kul_adi + ", kul_sifre=" + kul_sifre + ", eski_sifre=" + eski_sifre + '}';
    }

    
}
