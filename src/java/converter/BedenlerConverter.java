/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package converter;

import dao.BedenlerDao;
import entity.Bedenler;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

/**
 *
 * @author user
 */
@FacesConverter(value="bedenlerConverter")
public class BedenlerConverter implements Converter{
    private BedenlerDao beddao;

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
     return this.getBeddao().getBaginti(Long.valueOf(value));
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
    Bedenler be=(Bedenler) value;   
    return be.getB_id().toString();
    }

    public BedenlerDao getBeddao() {
        if(this.beddao==null)
            this.beddao=new BedenlerDao();
        return beddao;
    }
    
}
    