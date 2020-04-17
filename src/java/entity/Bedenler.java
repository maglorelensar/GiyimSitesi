
package entity;



public class Bedenler {
    private int b_id;
    private String b_tipi;

    public Bedenler() {
    }

    
    public Bedenler(int b_id, String b_tipi) {
        this.b_id = b_id;
        this.b_tipi = b_tipi;
    }
    

    public int getB_id() {
        return b_id;
    }

    public void setB_id(int b_id) {
        this.b_id = b_id;
    }

    public String getB_tipi() {
        return b_tipi;
    }

    public void setB_tipi(String b_tipi) {
        this.b_tipi = b_tipi;
    }
    
    
}
