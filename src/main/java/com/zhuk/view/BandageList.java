package com.zhuk.view;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;
import com.zhuk.domain.Bandage;
import com.zhuk.service.BandageService;

@Route(value = "bandages", layout = MainLayout.class)
public class BandageList extends VerticalLayout {

    private final BandageService bandageService;
    private final Grid<Bandage> grid = new Grid<>(Bandage.class);
    private final BandageForm form;

    public BandageList(BandageService bandageService) {

        this.bandageService = bandageService;
        addClassName("main-view");
        setSizeFull();
        configureGrid();

        form = new BandageForm();

        form.addListener(BandageForm.SaveEvent.class, this::saveBandage);
        form.addListener(BandageForm.DeleteEvent.class, this::deleteBandage);
        form.addListener(BandageForm.CloseEvent.class, e -> closeEditor());

        Div content = new Div(grid, form);

        content.addClassName("content");
        content.setSizeFull();

        add(getToolBar(), content);
        updateList();

        closeEditor();
    }

    private HorizontalLayout getToolBar() {
        Button addContactButton = new Button("Add Bandage");
        addContactButton.addClickListener(click -> addBandage());
        HorizontalLayout toolbar = new HorizontalLayout(addContactButton);
        toolbar.addClassName("toolbar");
        return toolbar;
    }

    private void addBandage() {
        grid.asSingleSelect().clear();
        editBandage(new Bandage());
    }

    private void saveBandage(BandageForm.SaveEvent event) {
        bandageService.save(event.getBandage());
        updateList();
        closeEditor();
    }



    private void deleteBandage(BandageForm.DeleteEvent event) {
        bandageService.delete(event.getBandage().getId());
        updateList();
        closeEditor();
    }

    private void closeEditor() {
        form.setBandage(null);
        form.setVisible(false);
        removeClassName("editing");
    }

    private void updateList() {
        grid.setItems(bandageService.findAll());
    }

    private void configureGrid() {
        grid.addClassName("aidkit-grid");
        grid.setSizeFull();
        grid.removeAllColumns();
        grid.addColumn(Bandage::getId).setHeader("#");

        grid.addColumn(Bandage::getName).setHeader("Name");
        grid.addColumn(Bandage::getWidth).setHeader("Width(cm)");
        grid.addColumn(Bandage::getLength).setHeader("Length(cm)");
        grid.addColumn(Bandage::getMaterial).setHeader("Material");

        grid.getColumns().forEach(col -> col.setAutoWidth(true));

        grid.asSingleSelect().addValueChangeListener(event ->
                editBandage(event.getValue()));
    }

    private void editBandage(Bandage value) {
        if (value == null) {
            closeEditor();
        } else {
            form.setBandage(value);
            form.setVisible(true);
            addClassName("editing");
        }
    }
}

