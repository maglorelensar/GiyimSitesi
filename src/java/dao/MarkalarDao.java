package dao;

import entity.Markalar;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import util.DBConnection;

public class MarkalarDao {
    private Connection c;

    private UrunlerDao urndao;
    
    public List<Markalar> getMarkaList() {
       List<Markalar> markalist = new ArrayList<>();
        try {
            c=DBConnection.getConnection();
            PreparedStatement pst = c.prepareStatement("select * from markalar");
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                markalist.add(new Markalar(rs.getLong("marka_id"), rs.getString("marka_adi")));
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }finally {
            DBConnection.closeConnection(c);
        }
        return markalist;
    }

   
    public void addMarka(Markalar mrk) {
        try {
            c=DBConnection.getConnection();
            PreparedStatement pst = c.prepareStatement("insert into markalar values(default,?)");
            pst.setString(1, mrk.getMarka_adi());    
            pst.executeUpdate();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        finally {
            DBConnection.closeConnection(c);
        }
    }

    public void updateMarka(Markalar mrk) {
        try {
            c=DBConnection.getConnection();
            PreparedStatement pst = c.prepareStatement("Update markalar set marka_adi=? where marka_id=?");
            pst.setString(1, mrk.getMarka_adi());
            pst.setLong(2, mrk.getMarka_id());
            pst.executeUpdate();
           
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }finally {
            DBConnection.closeConnection(c);
        }
    }

    public void delete(Markalar mrk) {
    try {
            c=DBConnection.getConnection();
            PreparedStatement pst = c.prepareStatement("delete from markalar where marka_id=?");
            pst.setLong(1, mrk.getMarka_id());
            pst.executeUpdate();

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }finally {
            DBConnection.closeConnection(c);
        }   
    }
 public List<Markalar> getUrunMarkasi(int aurun_id) {
        List<Markalar> aurunmarkasi =new ArrayList<>();
        try {
            c=DBConnection.getConnection();
            PreparedStatement pst = c.prepareStatement("select * from aurun_marka where au_id=?");
            pst.setInt(1, aurun_id);
            ResultSet rs=pst.executeQuery();
            while(rs.next()){
            aurunmarkasi.add(this.getMarka(rs.getLong("marka_id")));
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }finally {
            DBConnection.closeConnection(c);
        }   
        return aurunmarkasi;
    }
 public Markalar getMarka(Long id) {
        Markalar mark=null;
        try {
            c=DBConnection.getConnection();
            PreparedStatement pst = c.prepareStatement("select * from markalar where marka_id="+id);
            ResultSet rs = pst.executeQuery();
            rs.next();
            mark=new Markalar();
             mark.setMarka_id(rs.getLong("marka_id"));
             mark.setMarka_adi(rs.getString("marka_adi"));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }finally {
            DBConnection.closeConnection(c);
        }
        return mark;
    }
    
   
    public UrunlerDao getUrndao() {
        if(this.urndao==null)
            this.urndao=new UrunlerDao();
        return urndao;
    }
}
