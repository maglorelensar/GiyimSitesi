/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.PhotosDao;
import entity.Photos;
import java.io.File;
import java.io.InputStream;
import java.io.Serializable;
import java.nio.file.Files;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import javax.servlet.http.Part;

/**
 *
 * @author user
 */
@Named(value="phc")
@SessionScoped
public class PhotosController implements Serializable{
    private Part photo;
    private Photos photos;
    private List<Photos> phList;
    private PhotosDao phDao;
    private final String YKlasoru="C:\\Users\\user\\Desktop\\res\\";
public void yukle(){
try{
InputStream girdi=photo.getInputStream();
File r=new File(YKlasoru+photo.getSubmittedFileName());
Files.copy(girdi, r.toPath());
photos=this.getPhotos();
photos.setDosyayolu(r.getParent());
photos.setDosyaadi(r.getName());
photos.setDosyatipi(photo.getContentType());
this.getPhDao().ekle(photos);
}catch(Exception e){
    System.out.println("resim yüklenmedi");
    System.out.println(e.getMessage());
}
}

public void sil(Photos photo){
this.getPhDao().sil(photo);
}

    public String getYKlasoru() {
        return YKlasoru;
    }

    public Photos getPhotos() {
        if(this.photos==null)
            this.photos=new Photos();
        return photos;
    }

    public void setPhotos(Photos photos) {
        this.photos = photos;
    }

    public List<Photos> getPhList() {
        this.phList=getPhDao().pListgetir();
        return phList;
    }

    public void setPhList(List<Photos> phList) {
        this.phList = phList;
    }

    public PhotosDao getPhDao() {
        if(this.phDao==null)
            this.phDao=new PhotosDao();
        return phDao;
    }

    public void setPhDao(PhotosDao phDao) {
        this.phDao = phDao;
    }

    public Part getPhoto() {
        return photo;
    }

    public void setPhoto(Part photo) {
        this.photo = photo;
    }
    
}
