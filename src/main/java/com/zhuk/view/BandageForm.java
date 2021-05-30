package com.zhuk.view;

import com.vaadin.flow.component.ComponentEvent;
import com.vaadin.flow.component.ComponentEventListener;
import com.vaadin.flow.component.Key;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.textfield.IntegerField;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.binder.BeanValidationBinder;
import com.vaadin.flow.data.binder.Binder;
import com.vaadin.flow.data.binder.ValidationException;
import com.vaadin.flow.shared.Registration;
import com.zhuk.domain.Bandage;
import com.zhuk.domain.Material;

public class BandageForm extends FormLayout {

    private Bandage bandage;

    TextField name = new TextField("Name");
    IntegerField width = new IntegerField("Width");
    IntegerField length = new IntegerField("Length");
    private ComboBox<Material> material = new ComboBox<>("Bandage");

    private Button save = new Button("Save");
    private Button delete = new Button("Delete");
    private Button close = new Button("Cancel");

    private Binder<Bandage> binder = new BeanValidationBinder<>(Bandage.class);

    public BandageForm() {
        addClassName("aidkit-form");
        binder.bindInstanceFields(this);

        material.setItems(Material.values());

        add(
                name,
                width,
                length,
                material,
                createButtonsLayout());
    }

    private HorizontalLayout createButtonsLayout() {
        save.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
        delete.addThemeVariants(ButtonVariant.LUMO_ERROR);
        close.addThemeVariants(ButtonVariant.LUMO_TERTIARY);

        save.addClickShortcut(Key.ENTER);
        close.addClickShortcut(Key.ESCAPE);

        save.addClickListener(event -> validateAndSave());
        delete.addClickListener(event -> fireEvent(new DeleteEvent(this, bandage)));
        close.addClickListener(event -> fireEvent(new CloseEvent(this)));

        binder.addStatusChangeListener(e -> save.setEnabled(binder.isValid()));

        return new HorizontalLayout(save, delete, close);
    }

    private void validateAndSave() {
        try {
            binder.writeBean(bandage);
            fireEvent(new SaveEvent(this,bandage));
        } catch (ValidationException e) {
            e.printStackTrace();
        }
    }

    public void setBandage(Bandage bandage) {
        this.bandage = bandage;
        binder.readBean(bandage);
    }

    public static abstract class BandageFormEvent extends ComponentEvent<BandageForm> {
        private Bandage bandage;

        protected BandageFormEvent(BandageForm source, Bandage bandage) {
            super(source, false);
            this.bandage = bandage;
        }

        public Bandage getBandage() {
            return bandage;
        }
    }

    public static class SaveEvent extends BandageFormEvent {
        SaveEvent(BandageForm source, Bandage bandage) {
            super(source, bandage);
        }
    }

    public static class DeleteEvent extends BandageFormEvent {
        DeleteEvent(BandageForm source, Bandage bandage) {
            super(source, bandage);
        }

    }

    public static class CloseEvent extends BandageFormEvent {
        CloseEvent(BandageForm source) {
            super(source, null);
        }
    }

    public <T extends ComponentEvent<?>> Registration addListener(Class<T> eventType,
                                                                  ComponentEventListener<T> listener) {
        return getEventBus().addListener(eventType, listener);
    }
}
