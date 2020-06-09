package controller;

import dao.MarkalarDao;
import entity.Markalar;
import java.io.Serializable;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

@Named(value = "markc")
@SessionScoped
public class MarkalarController implements Serializable {

    private Markalar mrk;
    private MarkalarDao mrkDao;

    public MarkalarController() {
    }

    public List<Markalar> getListmarka() {
        return this.getMrkDao().getMarkaList();
    }

    public void submitmarka() {
        this.getMrkDao().addMarka(this.mrk);
        this.clearform();
    }

    public void updatemark() {
        this.getMrkDao().updateMarka(this.mrk);
        this.clearform();
    }

    public void clearform() {
        this.mrk = new Markalar();
    }

    public void editmarka(Markalar mk) {
        this.mrk = mk;
    }

    public void deletemarka(Markalar mk) {
        this.getMrkDao().delete(mk);

    }

    public Markalar getMrk() {
        if (this.mrk == null) {
            this.mrk = new Markalar();
        }
        return mrk;
    }

    public void setMrk(Markalar mrk) {
        this.mrk = mrk;
    }

    public MarkalarDao getMrkDao() {
        if (this.mrkDao == null) {
            this.mrkDao = new MarkalarDao();
        }
        return mrkDao;
    }

    public void setMrkDao(MarkalarDao mrkDao) {
        this.mrkDao = mrkDao;
    }

}
