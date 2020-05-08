/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package converter;

import dao.RenklerDao;
import entity.Renkler;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

/**
 *
 * @author user
 */
@FacesConverter(value="renklerConverter")
public class RenklerConverter implements Converter{
    private RenklerDao renkdao;
    

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
       return this.getRenkdao().getBaginti(Long.valueOf(value));
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
       Renkler re=(Renkler) value;   
    return re.getR_id().toString();
    }

    public RenklerDao getRenkdao() {
        if(this.renkdao==null)
            this.renkdao=new RenklerDao();
        return renkdao;
    }
    
}