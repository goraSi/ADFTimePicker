package view;

import javax.faces.component.UIComponent;
import javax.faces.event.ActionEvent;

import oracle.adf.view.rich.component.rich.input.RichInputText;
import oracle.adf.view.rich.component.rich.nav.RichButton;
import oracle.adf.view.rich.context.AdfFacesContext;

public class TimePickerBean {
    private Long time;
    private String hours;
    private String minutes;
    private RichInputText timePicker;

    public TimePickerBean() {
        time = Long.valueOf(100);
    }

    private void calculateTime() {
        time = (Long.valueOf(hours != null ? hours : "0") * 60) + Long.valueOf(minutes != null ? minutes : "0");
    }

    public void selectHours(ActionEvent actionEvent) {
        RichButton component = (RichButton) actionEvent.getComponent();
        hours = component.getText();
        calculateTime();
        AdfFacesContext.getCurrentInstance().addPartialTarget(timePicker);
    }

    public void selectMinutes(ActionEvent actionEvent) {
        RichButton component = (RichButton) actionEvent.getComponent();
        minutes = component.getText();
        calculateTime();
        AdfFacesContext.getCurrentInstance().addPartialTarget(timePicker);
    }

    public void setTime(Long time) {
        this.time = time;
    }

    public Long getTime() {
        return time;
    }

    public void setHours(String hours) {
        this.hours = hours;
    }

    public String getHours() {
        return hours;
    }

    public void setMinutes(String minutes) {
        this.minutes = minutes;
    }

    public String getMinutes() {
        return minutes;
    }

    public void setTimePicker(RichInputText timePicker) {
        this.timePicker = timePicker;
    }

    public RichInputText getTimePicker() {
        return timePicker;
    }
}
