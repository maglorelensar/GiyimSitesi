
package entity;

import dao.DocumentDao;


public class Document {
    private int d_id;
    private String filePath;
    private String fileName;
    private String fileType;

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getFileType() {
        return fileType;
    }

    public void setFileType(String fileType) {
        this.fileType = fileType;
    }

    public int getD_id() {
        DocumentDao ddao=new DocumentDao();
        int d=ddao.getLastDocument();
        return d;
    }

    public void setD_id(int d_id) {
        this.d_id = d_id;
    }
   
    
}
