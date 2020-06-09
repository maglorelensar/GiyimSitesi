package converter;

import dao.MarkalarDao;
import entity.Markalar;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;


@FacesConverter(value = "markaConverter")
public class MarkaConverter implements Converter{
    private MarkalarDao mrkdao;

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        return this.getMrkdao().getMarka(Long.valueOf(value));
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
            Markalar mrk=(Markalar) value;   
    return mrk.getMarka_id().toString();
    }

    public MarkalarDao getMrkdao() {
        if(this.mrkdao==null)
            this.mrkdao=new MarkalarDao();
        return mrkdao;
    }
    
}
