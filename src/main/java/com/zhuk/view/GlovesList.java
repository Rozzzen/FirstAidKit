package com.zhuk.view;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;
import com.zhuk.domain.Bandage;
import com.zhuk.domain.Gloves;
import com.zhuk.service.GlovesService;

@Route(value = "gloves", layout = MainLayout.class)
public class GlovesList extends VerticalLayout {

    private final GlovesService glovesService;
    private final Grid<Gloves> grid = new Grid<>(Gloves.class);
    private final GlovesForm form;

    public GlovesList(GlovesService glovesService) {

        this.glovesService = glovesService;
        addClassName("main-view");
        setSizeFull();
        configureGrid();

        form = new GlovesForm();

        form.addListener(GlovesForm.SaveEvent.class, this::saveGloves);
        form.addListener(GlovesForm.DeleteEvent.class, this::deleteGloves);
        form.addListener(GlovesForm.CloseEvent.class, e -> closeEditor());

        Div content = new Div(grid, form);

        content.addClassName("content");
        content.setSizeFull();

        add(getToolBar(), content);
        updateList();

        closeEditor();
    }

    private HorizontalLayout getToolBar() {
        Button addContactButton = new Button("Add Gloves");
        addContactButton.addClickListener(click -> addGloves());
        HorizontalLayout toolbar = new HorizontalLayout(addContactButton);
        toolbar.addClassName("toolbar");
        return toolbar;
    }

    private void addGloves() {
        grid.asSingleSelect().clear();
        editGloves(new Gloves());
    }

    private void saveGloves(GlovesForm.SaveEvent event) {
        glovesService.save(event.getGloves());
        updateList();
        closeEditor();
    }



    private void deleteGloves(GlovesForm.DeleteEvent event) {
        glovesService.delete(event.getGloves().getId());
        updateList();
        closeEditor();
    }

    private void closeEditor() {
        form.setGloves(null);
        form.setVisible(false);
        removeClassName("editing");
    }

    private void updateList() {
        grid.setItems(glovesService.findAll());
    }

    private void configureGrid() {
        grid.addClassName("aidkit-grid");
        grid.setSizeFull();
        grid.removeAllColumns();
        grid.addColumn(Gloves::getId).setHeader("#");

        grid.addColumn(Gloves::getName).setHeader("Name");
        grid.addColumn(Gloves::getMaterial).setHeader("Material");

        grid.getColumns().forEach(col -> col.setAutoWidth(true));

        grid.asSingleSelect().addValueChangeListener(event ->
                editGloves(event.getValue()));
    }

    private void editGloves(Gloves value) {
        if (value == null) {
            closeEditor();
        } else {
            form.setGloves(value);
            form.setVisible(true);
            addClassName("editing");
        }
    }
}

