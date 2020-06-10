package dao;

import entity.Kullanici;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import util.DBConnection;


public class KullaniciDao {

    private Connection c;
    private List<Kullanici> arananliste;
 
    public List<Kullanici> getList(int page,int pageSize) {
        List<Kullanici> kullist = new ArrayList<>();
        int start=(page-1)*pageSize;
        try {
            c=DBConnection.getConnection();
            PreparedStatement pst = c.prepareStatement("select * from kullanici order by k_id asc limit "+start+","+pageSize);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                kullist.add(new Kullanici(rs.getInt("k_id"), rs.getString("k_adi"), rs.getString("k_sifre")));
                
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }finally {
            DBConnection.closeConnection(c);
        }
        return kullist;
    }

    public void addToList(Kullanici k) {
        
        try {
            c=DBConnection.getConnection();
            PreparedStatement pst=c.prepareStatement("select * from kullanici where k_adi=?");
        pst.setString(1,k.getKul_adi());
          ResultSet rs = pst.executeQuery();
            String b = null;
            while (rs.next()) {
                String tmp;
                tmp = rs.getString("k_adi");
                b = tmp;
                }if (b != null) {
                FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Sistemde Bu Adda Biri Zaten Mevcut!!!!", null);
                FacesContext.getCurrentInstance().addMessage(null, msg);
                }
                else{
                pst = c.prepareStatement("insert into kullanici values(default,?,?,?)");
            pst.setString(1, k.getKul_adi());       
            pst.setString(2, k.getKul_sifre());
            pst.setInt(3, 2);
            pst.executeUpdate();
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Kayıt Başarılı!Giriş Yapabilirsiniz!", null);
                FacesContext.getCurrentInstance().addMessage(null, msg);
                }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        finally {
            DBConnection.closeConnection(c);
        }
    }

    public void delete(Kullanici k) {

        try {
            c=DBConnection.getConnection();
            PreparedStatement pst = c.prepareStatement("delete from kullanici where k_id=?");
            pst.setInt(1, k.getKul_id());
            pst.executeUpdate();

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }finally {
            DBConnection.closeConnection(c);
        }

    }

    public void update(Kullanici k) {
        try {
            c=DBConnection.getConnection();
            PreparedStatement pst = c.prepareStatement("Update kullanici set k_adi=?,k_sifre=? where k_id=?");
            pst.setString(1, k.getKul_adi());
            pst.setString(2, k.getKul_sifre());
            pst.setInt(3, k.getKul_id());
            pst.executeUpdate();
           
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }finally {
            DBConnection.closeConnection(c);
        }
    }
public void update2(Kullanici k) {
        try {
            c=DBConnection.getConnection();
            //eski şifreyle uyumlu mu kontrolü
            PreparedStatement pst = c.prepareStatement("select * from kullanici where k_id=?");
            pst.setInt(1, k.getKul_id());
            ResultSet rs=pst.executeQuery();
            rs.next();
            String eskisifre=rs.getString("k_sifre");
            if(eskisifre.equals(k.getEski_sifre())){
            pst = c.prepareStatement("Update kullanici set k_sifre=? where k_id=?");
            pst.setString(1, k.getKul_sifre());
            pst.setInt(2, k.getKul_id());
            pst.executeUpdate();
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Güncelleme Başarılı!", null);
                FacesContext.getCurrentInstance().addMessage(null, msg);
            }
            else{
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Eski Şifreniz Hatalı!!!", null);
                FacesContext.getCurrentInstance().addMessage(null, msg);
            }
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }finally {
            DBConnection.closeConnection(c);
        }
    }
    public Kullanici getBaginti(int kullanici_id) {
       Kullanici kul = null;
        try {
            c=DBConnection.getConnection();
            PreparedStatement pst = c.prepareStatement("select * from kullanici where k_id="+kullanici_id);
            ResultSet rs = pst.executeQuery();
            rs.next();
            kul=new Kullanici();
            kul.setKul_id(rs.getInt("k_id"));
            kul.setKul_adi(rs.getString("k_adi"));
            kul.setKul_sifre(rs.getString("k_sifre"));
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }finally {
            DBConnection.closeConnection(c);
        }
        return kul;
    }

    public int count() {
        int count=0;
       try {
            c=DBConnection.getConnection();
            PreparedStatement pst = c.prepareStatement("select count(k_id) as kul_count from kullanici");
            ResultSet rs = pst.executeQuery();
            rs.next();
            count=rs.getInt("kul_count");
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }finally {
            DBConnection.closeConnection(c);
        }
        return count;
    }

  

    public List<Kullanici> ara(String aranann) {
         try {
            c=DBConnection.getConnection();
            PreparedStatement pst = c.prepareStatement("select *from kullanici where k_adi=?");
            pst.setString(1, aranann);
            ResultSet rs=pst.executeQuery();
            this.setArananliste(null);
            if(rs.next()){
             Kullanici aranan=new Kullanici();
            aranan.setKul_id(rs.getInt("k_id"));
            aranan.setKul_adi(rs.getString("k_adi"));
            aranan.setKul_sifre(rs.getString("k_sifre"));
            this.getArananliste().add(aranan);
            }
           
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }finally {
            DBConnection.closeConnection(c);
        }
         return getArananliste();
    }

    public List<Kullanici> getArananliste() {
        if(this.arananliste==null)
            this.arananliste=new ArrayList<>();
        return arananliste;
    }

    public void setArananliste(List<Kullanici> arananliste) {
        this.arananliste = arananliste;
    }

}
