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
import com.zhuk.domain.Bandage;
import com.zhuk.domain.FirstAidKit;
import com.zhuk.domain.Garrot;
import com.zhuk.domain.Gloves;

import java.util.List;

public class AidkitForm extends FormLayout {

    private FirstAidKit firstAidKit;

    TextField name = new TextField("Name");
    private ComboBox<Bandage> bandage = new ComboBox<>("Bandage");
    private ComboBox<Gloves> gloves = new ComboBox<>("Gloves");
    private ComboBox<Garrot> garrot = new ComboBox<>("Garrot");

    private Button save = new Button("Save");
    private Button delete = new Button("Delete");
    private Button close = new Button("Cancel");

    private Binder<FirstAidKit> binder = new BeanValidationBinder<>(FirstAidKit.class);

    public AidkitForm(List<Bandage> bandages,
                      List<Gloves> gloves,
                      List<Garrot> garrots
    ) {
        addClassName("aidkit-form");
        binder.bindInstanceFields(this);

        bandage.setItems(bandages);
        bandage.setItemLabelGenerator(Bandage::getName);

        garrot.setItems(garrots);
        garrot.setItemLabelGenerator(Garrot::getName);

        this.gloves.setItems(gloves);
        this.gloves.setItemLabelGenerator(Gloves::getName);

        add(
                name,
                bandage,
                garrot,
                this.gloves,
                createButtonsLayout());
    }

    private HorizontalLayout createButtonsLayout() {
        save.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
        delete.addThemeVariants(ButtonVariant.LUMO_ERROR);
        close.addThemeVariants(ButtonVariant.LUMO_TERTIARY);


        save.addClickShortcut(Key.ENTER);
        close.addClickShortcut(Key.ESCAPE);

        save.addClickListener(event -> validateAndSave());
        delete.addClickListener(event -> fireEvent(new DeleteEvent(this, firstAidKit)));
        close.addClickListener(event -> fireEvent(new CloseEvent(this)));

        binder.addStatusChangeListener(e -> save.setEnabled(binder.isValid()));

        return new HorizontalLayout(save, delete, close);
    }

    private void validateAndSave() {
        try {
            binder.writeBean(firstAidKit);
            fireEvent(new SaveEvent(this,firstAidKit));
        } catch (ValidationException e) {
            e.printStackTrace();
        }
    }

    public void setAidkit(FirstAidKit firstAidKit) {
        this.firstAidKit = firstAidKit;
        binder.readBean(firstAidKit);
    }

    public static abstract class AidkitFormEvent extends ComponentEvent<AidkitForm> {
        private FirstAidKit firstAidKit;

        protected AidkitFormEvent(AidkitForm source, FirstAidKit firstAidKit) {
            super(source, false);
            this.firstAidKit = firstAidKit;
        }

        public FirstAidKit getFirstAidKit() {
            return firstAidKit;
        }
    }

    public static class SaveEvent extends AidkitFormEvent {
        SaveEvent(AidkitForm source, FirstAidKit firstAidKit) {
            super(source, firstAidKit);
        }
    }

    public static class DeleteEvent extends AidkitFormEvent {
        DeleteEvent(AidkitForm source, FirstAidKit firstAidKit) {
            super(source, firstAidKit);
        }

    }

    public static class CloseEvent extends AidkitFormEvent {
        CloseEvent(AidkitForm source) {
            super(source, null);
        }
    }

    public <T extends ComponentEvent<?>> Registration addListener(Class<T> eventType,
                                                                  ComponentEventListener<T> listener) {
        return getEventBus().addListener(eventType, listener);
    }
}
