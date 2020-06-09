
package dao;

import entity.AyakkabiNo;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import util.DBConnection;


public class AyakkabiNoDao {

    private Connection c;
 
    public List<AyakkabiNo> getAyakkabiNoList() {
        List<AyakkabiNo> ayakkabinolist = new ArrayList<>();
        try {
            c = DBConnection.getConnection();
            PreparedStatement pst = c.prepareStatement("select * from ayakkabi_no");
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                ayakkabinolist.add(new AyakkabiNo(rs.getLong("a_no_id"), rs.getInt("a_no")));
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            DBConnection.closeConnection(c);
        }
        return ayakkabinolist;
    }

    public AyakkabiNo getAyakkabiNo(int id) {
        AyakkabiNo aykbn = null;
        try {
            c = DBConnection.getConnection();
            PreparedStatement pst = c.prepareStatement("select * from ayakkabi_no where a_no_id=" + id);
            ResultSet rs = pst.executeQuery();
            rs.next();
            aykbn=new AyakkabiNo();
            aykbn.setAno_id(rs.getLong("a_no_id"));
            aykbn.setA_no(rs.getInt("a_no"));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            DBConnection.closeConnection(c);
        }
        return aykbn;
    }

    public void addAyakkabiNo(AyakkabiNo aykb_no) {
        try {
            c = DBConnection.getConnection();
            PreparedStatement pst = c.prepareStatement("insert into ayakkabi_no values(default,?)");
            pst.setLong(1, aykb_no.getA_no());
            pst.executeUpdate();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            DBConnection.closeConnection(c);
        }
    }

    public void updateAyakkabiNo(AyakkabiNo aykb_no) {
        try {
            c = DBConnection.getConnection();
            PreparedStatement pst = c.prepareStatement("Update ayakkabi_no set a_no=? where a_no_id=?");
            pst.setLong(1, aykb_no.getA_no());
            pst.setLong(2, aykb_no.getAno_id());
            pst.executeUpdate();

        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            DBConnection.closeConnection(c);
        }
    }

    public void deleteAyakkabiNo(AyakkabiNo anoid) {
        try {
            c = DBConnection.getConnection();
            PreparedStatement pst = c.prepareStatement("delete from ayakkabi_no where a_no_id=?");
            pst.setLong(1, anoid.getAno_id());
            pst.executeUpdate();

        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            DBConnection.closeConnection(c);
        }
    }

    public AyakkabiNo getANoBaginti(Long a_no_id) {
        AyakkabiNo aykbn = null;
        try {
            c = DBConnection.getConnection();
            PreparedStatement pst = c.prepareStatement("select * from ayakkabi_no where a_no_id=" + a_no_id);
            ResultSet rs = pst.executeQuery();
            rs.next();
            aykbn = new AyakkabiNo();
            aykbn.setAno_id(rs.getLong("a_no_id"));
            aykbn.setA_no(rs.getInt("a_no"));

        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            DBConnection.closeConnection(c);
        }
        return aykbn;
    }
}
