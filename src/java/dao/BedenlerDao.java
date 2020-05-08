
package dao;

import entity.Bedenler;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import util.DBConnection;


public class BedenlerDao {

    private Connection c;
    
    public List<Bedenler> getBedenList() {
        
        List<Bedenler> bedenlist = new ArrayList<>();
        try {
            c=DBConnection.getConnection();
            PreparedStatement pst = c.prepareStatement("select * from bedenler");
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                bedenlist.add(new Bedenler(rs.getLong("b_id"), rs.getString("b_tipi")));
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }finally {
            DBConnection.closeConnection(c);
        }
        return bedenlist;
    }
    public void add(Bedenler bed) {
        try {
            c=DBConnection.getConnection();
            PreparedStatement pst = c.prepareStatement("insert into bedenler values(default,?)");
            pst.setString(1, bed.getB_tipi());    
            pst.executeUpdate();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        finally {
            DBConnection.closeConnection(c);
        }
    }
    public void guncelle(Bedenler bed) {
        try {
            c=DBConnection.getConnection();
            PreparedStatement pst = c.prepareStatement("Update bedenler set b_tipi=? where b_id=?");
            pst.setString(1, bed.getB_tipi());
            pst.setLong(2, bed.getB_id());
            pst.executeUpdate();
           
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }finally {
            DBConnection.closeConnection(c);
        }
    }

    public void delete(Bedenler bed) {
        try {
            c=DBConnection.getConnection();
            PreparedStatement pst = c.prepareStatement("delete from bedenler where b_id=?");
            pst.setLong(1, bed.getB_id());
            pst.executeUpdate();

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }finally {
            DBConnection.closeConnection(c);
        }
    }
    public Bedenler getBaginti(Long beden_id) {
       Bedenler beden = null;
        try {
            c=DBConnection.getConnection();
            PreparedStatement pst = c.prepareStatement("select * from bedenler where b_id="+beden_id);
            ResultSet rs = pst.executeQuery();
            rs.next();
            beden=new Bedenler();
            beden.setB_id(rs.getLong("b_id"));
            beden.setB_tipi(rs.getString("b_tipi"));
           } catch (Exception e) {
            System.out.println(e.getMessage());
        }finally {
            DBConnection.closeConnection(c);
        }
        return beden;
    }
    }
    

