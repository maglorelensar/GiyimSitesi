package dao;

import entity.Document;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import util.DBConnection;

public class DocumentDao {

    private Connection c;

    public List<Document> getDocumentList() {
        List<Document> dlist = new ArrayList<>();
        try {
            c = DBConnection.getConnection();
            PreparedStatement pst = c.prepareStatement("select * from document");
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                Document d = new Document();
                d.setD_id(rs.getInt("doc_id"));
                d.setFilePath(rs.getString("doc_path"));
                d.setFileName(rs.getString("doc_name"));
                d.setFileType(rs.getString("doc_type"));
                dlist.add(d);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            DBConnection.closeConnection(c);
        }
        return dlist;
    }

    public void addDocument(Document dnew) {
        try {
            c = DBConnection.getConnection();
            PreparedStatement pst = c.prepareStatement("insert into document values(default,?,?,?)");
            pst.setString(1, dnew.getFilePath());
            pst.setString(2, dnew.getFileName());
            pst.setString(3, dnew.getFileType());
            pst.executeUpdate();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            DBConnection.closeConnection(c);
        }
    }

    public int getLastDocument() {
        int value = 0;
        try {
            c = DBConnection.getConnection();
            PreparedStatement pst = c.prepareStatement("select doc_id from document order by doc_id desc limit 1");
            ResultSet rs = pst.executeQuery();
            rs.next();
            value = rs.getInt("doc_id");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            DBConnection.closeConnection(c);
        }
        return value;
    }

    public Document getDocumentBaginti(int id) {
        Document dcmnt = new Document();
        try {
            c = DBConnection.getConnection();
            PreparedStatement pst = c.prepareStatement("select * from document where doc_id=" + id);
            ResultSet rs = pst.executeQuery();
            rs.next();
            dcmnt.setD_id(rs.getInt("doc_id"));
            dcmnt.setFilePath(rs.getString("doc_path"));
            dcmnt.setFileName(rs.getString("doc_name"));
            dcmnt.setFileType(rs.getString("doc_type"));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            DBConnection.closeConnection(c);
        }
        return dcmnt;
    }

    public void deleteDocument(Document delete) {
        try {
            c = DBConnection.getConnection();
            PreparedStatement pst = c.prepareStatement("delete from document where doc_id=?");
            pst.setInt(1, delete.getD_id());
            pst.executeUpdate();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            DBConnection.closeConnection(c);
        }
    }
}
