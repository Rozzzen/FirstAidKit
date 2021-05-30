package com.zhuk.view;

import com.vaadin.flow.component.ComponentEvent;
import com.vaadin.flow.component.ComponentEventListener;
import com.vaadin.flow.component.Key;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.binder.BeanValidationBinder;
import com.vaadin.flow.data.binder.Binder;
import com.vaadin.flow.data.binder.ValidationException;
import com.vaadin.flow.shared.Registration;
import com.zhuk.domain.Gloves;
import com.zhuk.domain.Material;

public class GlovesForm extends FormLayout {

    private Gloves gloves;

    TextField name = new TextField("Name");
    private ComboBox<Material> material = new ComboBox<>("Bandage");

    private Button save = new Button("Save");
    private Button delete = new Button("Delete");
    private Button close = new Button("Cancel");

    private Binder<Gloves> binder = new BeanValidationBinder<>(Gloves.class);

    public GlovesForm() {
        addClassName("aidkit-form");
        binder.bindInstanceFields(this);

        material.setItems(Material.values());

        add(
                name,
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
        delete.addClickListener(event -> fireEvent(new DeleteEvent(this, gloves)));
        close.addClickListener(event -> fireEvent(new CloseEvent(this)));

        binder.addStatusChangeListener(e -> save.setEnabled(binder.isValid()));

        return new HorizontalLayout(save, delete, close);
    }

    private void validateAndSave() {
        try {
            binder.writeBean(gloves);
            fireEvent(new SaveEvent(this,gloves));
        } catch (ValidationException e) {
            e.printStackTrace();
        }
    }

    public void setGloves(Gloves gloves) {
        this.gloves = gloves;
        binder.readBean(gloves);
    }

    public static abstract class GlovesFormEvent extends ComponentEvent<GlovesForm> {
        private Gloves gloves;

        protected GlovesFormEvent(GlovesForm source, Gloves gloves) {
            super(source, false);
            this.gloves = gloves;
        }

        public Gloves getGloves() {
            return gloves;
        }
    }

    public static class SaveEvent extends GlovesFormEvent {
        SaveEvent(GlovesForm source, Gloves gloves) {
            super(source, gloves);
        }
    }

    public static class DeleteEvent extends GlovesFormEvent {
        DeleteEvent(GlovesForm source, Gloves gloves) {
            super(source, gloves);
        }

    }

    public static class CloseEvent extends GlovesFormEvent {
        CloseEvent(GlovesForm source) {
            super(source, null);
        }
    }

    public <T extends ComponentEvent<?>> Registration addListener(Class<T> eventType,
                                                                  ComponentEventListener<T> listener) {
        return getEventBus().addListener(eventType, listener);
    }
}
