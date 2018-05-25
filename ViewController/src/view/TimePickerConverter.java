package view;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;

public class TimePickerConverter implements Converter {
    public static final String REGEX_TIME = "^(0[0-9]|1[0-9]|2[0-3]):[0-5][0-9]$";
    
    public TimePickerConverter() {
        super();
    }

    @Override
    public Object getAsObject(FacesContext facesContext, UIComponent comp, String string) {
        if (string != null && string.matches(REGEX_TIME)) {
            String hours = string.substring(0, 2);
            String minutes = string.substring(3, 5);
            return (Long.valueOf(hours != null ? hours : "0") * 60) + Long.valueOf(minutes != null ? minutes : "0");
        }
        facesContext.addMessage(comp.getId(), new FacesMessage(FacesMessage.SEVERITY_ERROR, "Oblika zapisa ni praivlna", "Vnesite ure in minute v obliki HH:MM"));
        facesContext.validationFailed();
        return null;
    }

    @Override
    public String getAsString(FacesContext facesContext, UIComponent uIComponent, Object object) {
        if (object != null) {
            long minute = Long.valueOf(object.toString());
            long ure = minute / 60;
            long ostanek = minute % 60;
            return String.format("%02d", ure) + ":" + String.format("%02d", ostanek);
        }
        return object != null ? object.toString() : null;
    }
}
