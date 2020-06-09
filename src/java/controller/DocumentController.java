package controller;

import dao.DocumentDao;
import entity.Document;
import java.io.File;
import java.io.InputStream;
import java.io.Serializable;
import java.nio.file.Files;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import javax.servlet.http.Part;


@Named (value = "dc")
@SessionScoped
public class DocumentController implements Serializable {
    private Document document;
    private List<Document> documentList;
    private DocumentDao documentDao;

    private Part doc;
    
    private final String uploadTo ="C:\\Users\\user\\Desktop\\SOONNN\\GiyimSitesi\\Ayakkabi-Urunler\\";
    
    File f;
    public void upload(){
        try {
           InputStream input=doc.getInputStream();
             this.f=new File(uploadTo+doc.getSubmittedFileName());
            Files.copy(input,f.toPath());
            System.out.println("YÜKLEME BAŞARILI");
            
            document =this.getDocument();
            document.setFilePath(f.getParent());
            document.setFileName(f.getName());
            document.setFileType(doc.getContentType());
            
            this.getDocumentDao().addDocument(document);
            this.clearUpload();
//            this.f =new File("");
//            this.document=new Document();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Yükleme Başarısız");
        }
    }
   public void clearUpload() {
        this.setDoc(null);
    }
    public String getUploadTo() {
        return uploadTo;
    }
    
    public Document getDocument() {
        if(this.document==null)
            this.document=new Document();
        return document;
    }

    public void setDocument(Document document) {
        this.document = document;
    }

    public List<Document> getDocumentList() {
        this.documentList=this.getDocumentDao().getDocumentList();
        return documentList;
    }

    public void setDocumentList(List<Document> documentList) {
        this.documentList = documentList;
    }

    public DocumentDao getDocumentDao() {
        if(this.documentDao==null)
            this.documentDao=new DocumentDao();
        return documentDao;
    }

    public void setDocumentDao(DocumentDao documentDao) {
        this.documentDao = documentDao;
    }

    public Part getDoc() {
        return doc;
    }

    public void setDoc(Part doc) {
        this.doc = doc;
    }


    
}


