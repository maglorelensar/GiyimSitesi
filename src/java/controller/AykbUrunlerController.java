package controller;

import dao.AykbUrunlerDao;
import entity.AykbUrunler;
import java.io.Serializable;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

@Named(value = "ac")
@SessionScoped
public class AykbUrunlerController implements Serializable {

    private AykbUrunler aurn;
    private AykbUrunlerDao aurndao;

    private int page = 1;
    private int pageSize = 5;
    private int pageCount;

    public void next() {
        if (this.page == this.getPageCount()) {
            this.page = 1;
        } else {
            this.page++;
        }
    }

    public void previous() {
        if (this.page == 1) {
            this.page = this.getPageCount();
        } else {
            this.page--;
        }
    }

    public AykbUrunlerController() {
    }

    @Inject
    private MarkalarController mrkc;

    public List<AykbUrunler> getListaurun() {
        return this.getAurndao().getAUrunList(page, pageSize);
    }

    public void submitaurun() {
        this.getAurndao().addAUrun(this.aurn);
        this.clearForm();
    }

    public void updateaurun() {
        this.getAurndao().updateAUrun(this.aurn);
        this.clearForm();
    }

    public void editaurun(AykbUrunler au) {
        this.aurn = au;
    }

    public void clearForm() {
        this.aurn = new AykbUrunler();
    }

    public void deletaurun(AykbUrunler au) {
        this.getAurndao().delete(au);

    }

    public AykbUrunler getAurn() {
        if (this.aurn == null) {
            this.aurn = new AykbUrunler();
        }
        return aurn;
    }

    public AykbUrunlerDao getAurndao() {
        if (this.aurndao == null) {
            this.aurndao = new AykbUrunlerDao();
        }
        return aurndao;
    }

    public MarkalarController getMrkc() {
        if (this.mrkc == null) {
            this.mrkc = new MarkalarController();
        }
        return mrkc;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getPageCount() {
        this.pageCount = (int) Math.ceil(getAurndao().count() / (double) pageSize);
        return pageCount;
    }

    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }

}
