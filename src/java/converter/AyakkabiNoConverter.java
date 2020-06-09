package converter;

import dao.AyakkabiNoDao;
import entity.AyakkabiNo;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

@FacesConverter(value = "ayakkabinoConverter")
public class AyakkabiNoConverter implements Converter {

    private AyakkabiNoDao anodao;

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        return this.getAnodao().getANoBaginti(Long.valueOf(value));
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        AyakkabiNo ano = (AyakkabiNo) value;
        return ano.getAno_id().toString();
    }

    public AyakkabiNoDao getAnodao() {
        if (this.anodao == null) 
            this.anodao = new AyakkabiNoDao();
        return anodao;
    }

}
