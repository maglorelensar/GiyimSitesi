/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package converter;

import dao.KategoriDao;
import entity.Kategori;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

/**
 *
 * @author user
 */
@FacesConverter(value="kategoriConverter")
public class KategoriConverter implements Converter{
    private KategoriDao katdao;

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
    return this.getKatdao().getKategori(Long.valueOf(value));
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        Kategori ka=(Kategori) value;   
    return ka.getKat_id().toString();
    }

    public KategoriDao getKatdao() {
        if(this.katdao==null)
            this.katdao=new KategoriDao();
            return katdao;
    }
    
}
