package com.zhuk.view;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;
import com.zhuk.domain.Bandage;
import com.zhuk.domain.Garrot;
import com.zhuk.service.GarrotService;

@Route(value = "garrots", layout = MainLayout.class)
public class GarrotList extends VerticalLayout {

    private final GarrotService garrotService;
    private final Grid<Garrot> grid = new Grid<>(Garrot.class);
    private final GarrotForm form;

    public GarrotList(GarrotService garrotService) {

        this.garrotService = garrotService;
        addClassName("main-view");
        setSizeFull();
        configureGrid();

        form = new GarrotForm();

        form.addListener(GarrotForm.SaveEvent.class, this::saveGarrot);
        form.addListener(GarrotForm.DeleteEvent.class, this::deleteGarrot);
        form.addListener(GarrotForm.CloseEvent.class, e -> closeEditor());

        Div content = new Div(grid, form);

        content.addClassName("content");
        content.setSizeFull();

        add(getToolBar(), content);
        updateList();

        closeEditor();
    }

    private HorizontalLayout getToolBar() {
        Button addContactButton = new Button("Add Garrot");
        addContactButton.addClickListener(click -> addGarrot());
        HorizontalLayout toolbar = new HorizontalLayout(addContactButton);
        toolbar.addClassName("toolbar");
        return toolbar;
    }

    private void addGarrot() {
        grid.asSingleSelect().clear();
        editGarrot(new Garrot());
    }

    private void saveGarrot(GarrotForm.SaveEvent event) {
        garrotService.save(event.getGarrot());
        updateList();
        closeEditor();
    }



    private void deleteGarrot(GarrotForm.DeleteEvent event) {
        garrotService.delete(event.getGarrot().getId());
        updateList();
        closeEditor();
    }

    private void closeEditor() {
        form.setGarrot(null);
        form.setVisible(false);
        removeClassName("editing");
    }

    private void updateList() {
        grid.setItems(garrotService.findAll());
    }

    private void configureGrid() {
        grid.addClassName("aidkit-grid");
        grid.setSizeFull();
        grid.removeAllColumns();
        grid.addColumn(Garrot::getId).setHeader("#");

        grid.addColumn(Garrot::getName).setHeader("Name");
        grid.addColumn(Garrot::getWidth).setHeader("Width(cm)");
        grid.addColumn(Garrot::getLength).setHeader("Length(cm)");

        grid.getColumns().forEach(col -> col.setAutoWidth(true));

        grid.asSingleSelect().addValueChangeListener(event ->
                editGarrot(event.getValue()));
    }

    private void editGarrot(Garrot value) {
        if (value == null) {
            closeEditor();
        } else {
            form.setGarrot(value);
            form.setVisible(true);
            addClassName("editing");
        }
    }
}

