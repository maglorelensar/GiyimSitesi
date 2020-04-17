
package controller;

import dao.*;
import entity.*;
import java.io.Serializable;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;


@Named(value="bedc")
@SessionScoped
public class BedenlerController implements Serializable{
    Bedenler bed;
    BedenlerDao beddao;
    
    public BedenlerController() {
    }
    
public List<Bedenler>getListbeden() {
        return this.getBeddao().getBedenList();
    }
    
public void kaydetbeden() {
        this.getBeddao().add(this.bed);
         this.bed=new Bedenler();
    }

public void guncellebeden(){
        this.getBeddao().guncelle(this.bed);
         this.bed=new Bedenler();
    }
public void formtemizle(){
this.bed=new Bedenler();
}
    public void updatebeden(Bedenler b){
        this.bed=b;
    } 
    public void deletebeden(Bedenler b){
        this.getBeddao().delete(b);
        
    }
    
    public Bedenler getBed() {
        if(this.bed==null)
            this.bed=new Bedenler();
        return bed;
    }

    public BedenlerDao getBeddao() {
        if(this.beddao==null)
            this.beddao=new BedenlerDao();
        return beddao;
    }

    
}