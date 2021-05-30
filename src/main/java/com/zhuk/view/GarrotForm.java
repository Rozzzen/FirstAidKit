package com.zhuk.view;

import com.vaadin.flow.component.ComponentEvent;
import com.vaadin.flow.component.ComponentEventListener;
import com.vaadin.flow.component.Key;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.textfield.IntegerField;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.binder.BeanValidationBinder;
import com.vaadin.flow.data.binder.Binder;
import com.vaadin.flow.data.binder.ValidationException;
import com.vaadin.flow.shared.Registration;
import com.zhuk.domain.Garrot;

public class GarrotForm extends FormLayout {

    private Garrot garrot;

    TextField name = new TextField("Name");
    IntegerField width = new IntegerField("Width");
    IntegerField length = new IntegerField("Length");

    private Button save = new Button("Save");
    private Button delete = new Button("Delete");
    private Button close = new Button("Cancel");

    private Binder<Garrot> binder = new BeanValidationBinder<>(Garrot.class);

    public GarrotForm() {
        addClassName("aidkit-form");
        binder.bindInstanceFields(this);

        add(
                name,
                width,
                length,
                createButtonsLayout());
    }

    private HorizontalLayout createButtonsLayout() {
        save.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
        delete.addThemeVariants(ButtonVariant.LUMO_ERROR);
        close.addThemeVariants(ButtonVariant.LUMO_TERTIARY);

        save.addClickShortcut(Key.ENTER);
        close.addClickShortcut(Key.ESCAPE);

        save.addClickListener(event -> validateAndSave());
        delete.addClickListener(event -> fireEvent(new DeleteEvent(this, garrot)));
        close.addClickListener(event -> fireEvent(new CloseEvent(this)));

        binder.addStatusChangeListener(e -> save.setEnabled(binder.isValid()));

        return new HorizontalLayout(save, delete, close);
    }

    private void validateAndSave() {
        try {
            binder.writeBean(garrot);
            fireEvent(new SaveEvent(this,garrot));
        } catch (ValidationException e) {
            e.printStackTrace();
        }
    }

    public void setGarrot(Garrot garrot) {
        this.garrot = garrot;
        binder.readBean(garrot);
    }

    public static abstract class GarrotFormEvent extends ComponentEvent<GarrotForm> {
        private Garrot garrot;

        protected GarrotFormEvent(GarrotForm source, Garrot garrot) {
            super(source, false);
            this.garrot = garrot;
        }

        public Garrot getGarrot() {
            return garrot;
        }
    }

    public static class SaveEvent extends GarrotFormEvent {
        SaveEvent(GarrotForm source, Garrot garrot) {
            super(source, garrot);
        }
    }

    public static class DeleteEvent extends GarrotFormEvent {
        DeleteEvent(GarrotForm source, Garrot garrot) {
            super(source, garrot);
        }

    }

    public static class CloseEvent extends GarrotFormEvent {
        CloseEvent(GarrotForm source) {
            super(source, null);
        }
    }

    public <T extends ComponentEvent<?>> Registration addListener(Class<T> eventType,
                                                                  ComponentEventListener<T> listener) {
        return getEventBus().addListener(eventType, listener);
    }
}

