package controller;

import dao.AyakkabiNoDao;
import entity.AyakkabiNo;
import java.io.Serializable;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

@Named(value="aykbnoc")
@SessionScoped
public class AyakkabiNoController implements Serializable {

    private AyakkabiNo aykn;
    private AyakkabiNoDao ayknoDao;

    public AyakkabiNoController() {
    }
    
    public List<AyakkabiNo> getListaykbno() {
        return this.getAyknoDao().getAyakkabiNoList();
    }

    public void submitaykbno() {
        this.getAyknoDao().addAyakkabiNo(this.aykn);
        this.clearForm();
    }

    public void updateaykbno() {
        this.getAyknoDao().updateAyakkabiNo(this.aykn);
        this.clearForm();
    }

    public void clearForm() {
        this.aykn = new AyakkabiNo();
    }

    public void editaykbno(AyakkabiNo ano) {
        this.aykn = ano;
    }

    public void deleteaykbno(AyakkabiNo ano) {
        this.getAyknoDao().deleteAyakkabiNo(ano);        
    }

    public AyakkabiNo getAykn() {
        if(this.aykn==null)
            this.aykn=new AyakkabiNo();
        return aykn;
    }

    public AyakkabiNoDao getAyknoDao() {
        if(this.ayknoDao==null)
            this.ayknoDao=new AyakkabiNoDao();
        return ayknoDao;
    }



    
}
