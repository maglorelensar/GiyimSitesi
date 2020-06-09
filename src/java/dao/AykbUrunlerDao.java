package dao;

import entity.AykbUrunler;
import entity.Markalar;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import util.DBConnection;

public class AykbUrunlerDao {

    private Connection c;
    private RenklerDao renkdao;
    private AyakkabiNoDao aykbnodao;
    private MarkalarDao markadao;
    private DocumentDao documentdao;
    private List<AykbUrunler> aykburunlist;

  

    public List<AykbUrunler> getAUrunList(int page,int pageSize) {
        int start=(page-1)*pageSize;
        try {
            c = DBConnection.getConnection();
            PreparedStatement pst = c.prepareStatement("select * from ayakkabiurunler order by u_id asc limit "+start+","+pageSize);
            ResultSet rs = pst.executeQuery();
            this.aykburunlist = new ArrayList<>();
            while (rs.next()) {
                AykbUrunler tmp = new AykbUrunler();
                tmp.setAurn_id(rs.getInt("u_id"));
                tmp.setAurn_adi(rs.getString("u_adi"));                
                tmp.setAurn_fiyat(rs.getDouble("u_fiyat"));
                tmp.setAurn_adedi(rs.getInt("u_adet"));     
                tmp.setRenk(getRenkdao().getBaginti(rs.getLong("u_renk")));
                tmp.setAyakkabino(getAykbnodao().getAyakkabiNo(rs.getInt("u_no")));
                tmp.setUrunmarkalari(this.getMarkadao().getUrunMarkasi(tmp.getAurn_id()));
                                 
                getAykburunlist().add(tmp);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            DBConnection.closeConnection(c);
        }
        return getAykburunlist();
    }

       public int count() {
           int count=0;
        try {
            
            c = DBConnection.getConnection();
            PreparedStatement pst = c.prepareStatement("select count(u_id) as au_count from ayakkabiurunler");
            ResultSet rs = pst.executeQuery();
            rs.next();
            count=rs.getInt("au_count");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            DBConnection.closeConnection(c);
        }
        return  count;
    }
    public void addAUrun(AykbUrunler a) {
        try {
            c = DBConnection.getConnection();
            PreparedStatement ps = c.prepareStatement("insert into ayakkabiurunler  values(default,?,?,?,?,?)");
            ps.setString(1, a.getAurn_adi());
            ps.setDouble(2, a.getAurn_fiyat());
            ps.setInt(3, a.getAurn_adedi());   
            ps.setLong(4, a.getRenk().getR_id());
            ps.setLong(5, a.getAyakkabino().getAno_id());
            ps.executeUpdate();
            
            Long aurunid = null;          
            ResultSet gk = ps.getGeneratedKeys();
            if (gk.next()) {
                aurunid = gk.getLong(1);
            }

            for (Markalar m : a.getUrunmarkalari()) {
                PreparedStatement pst2 = c.prepareStatement("insert into aurun_marka values(?,?)");
                pst2.setLong(1, aurunid);
                pst2.setLong(2, m.getMarka_id());
                pst2.executeUpdate();
            }

        } catch (Exception e) {
            System.out.println("KAYDETMEDE SORUN !");
            System.out.println(e.getLocalizedMessage());
        } finally {
            DBConnection.closeConnection(c);
        }
    }

    public void updateAUrun(AykbUrunler au) {
        try {
            c = DBConnection.getConnection();
            PreparedStatement pst = c.prepareStatement("Update ayakkabiurunler set u_adi=?,u_fiyat=?,u_adet=?,u_renk=?,u_no=? where u_id=?");
            pst.setString(1, au.getAurn_adi());
            pst.setDouble(2, au.getAurn_fiyat());
            pst.setInt(3, au.getAurn_adedi());
            pst.setLong(4, au.getRenk().getR_id());        
            pst.setLong(5, au.getAyakkabino().getAno_id());
            pst.setLong(6, au.getAurn_id());
            
            pst.executeUpdate();
            
            pst = c.prepareStatement("delete from aurun_marka where au_id=?");
            pst.setLong(1, au.getAurn_id());
            
            pst.executeUpdate();
            
             for (Markalar m : au.getUrunmarkalari()) {
                PreparedStatement pst2 = c.prepareStatement("insert into aurun_marka values(?,?)");
                pst2.setLong(1, au.getAurn_id());
                pst2.setLong(2, m.getMarka_id());
                pst2.executeUpdate();
            }

        } catch (Exception e) {
            System.out.println("Güncellemede SORUN");
            System.out.println(e.getMessage());
        } finally {
            DBConnection.closeConnection(c);
        }
    }

    public void delete(AykbUrunler au) {
        try {
            c = DBConnection.getConnection();
           PreparedStatement pst = c.prepareStatement("delete from aurun_marka where au_id=?");
           pst.setLong(1, au.getAurn_id());
            pst.executeUpdate();
            
           pst = c.prepareStatement("delete from ayakkabiurunler where u_id=?");
            pst.setLong(1, au.getAurn_id());
            
            pst.executeUpdate();

        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            DBConnection.closeConnection(c);
        }
    }

    public AykbUrunler getAUMBaginti(int aurun_id) {
        AykbUrunler aurun = null;
        try {
            c = DBConnection.getConnection();
            PreparedStatement pst = c.prepareStatement("select * from ayakkabiurunler where u_id=" + aurun_id);
            ResultSet rs = pst.executeQuery();
            rs.next();
            aurun = new AykbUrunler();
            aurun.setAurn_id(rs.getInt("u_id"));
            aurun.setAurn_adi(rs.getString("u_adi"));
            aurun.setAurn_fiyat(rs.getInt("u_fiyat"));
            aurun.setAurn_adedi(rs.getInt("u_adet"));
            aurun.getRenk().setR_id(rs.getLong("u_renk"));
            aurun.setUrunmarkalari(this.getMarkadao().getUrunMarkasi(aurun_id));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return aurun;
    }

 
      public List<AykbUrunler> getAykburunlist() {
        if(this.aykburunlist==null)
            this.aykburunlist=new ArrayList<>();
        return aykburunlist;
    }

    public AyakkabiNoDao getAykbnodao() {
        if(this.aykbnodao==null)
            this.aykbnodao=new AyakkabiNoDao();
        return aykbnodao;
    }

    public DocumentDao getDocumentdao() {
        if(this.documentdao==null)
            this.documentdao=new DocumentDao();
        return documentdao;
    }
  
    public RenklerDao getRenkdao() {
        if (this.renkdao == null) {
            this.renkdao = new RenklerDao();
        }
        return renkdao;
    }

    public MarkalarDao getMarkadao() {
        if(this.markadao==null)
            this.markadao=new MarkalarDao();
        return markadao;
    }
    

}



