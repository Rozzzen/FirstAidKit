package com.zhuk.view;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;
import com.zhuk.domain.Bandage;
import com.zhuk.domain.FirstAidKit;
import com.zhuk.domain.Garrot;
import com.zhuk.domain.Gloves;
import com.zhuk.service.BandageService;
import com.zhuk.service.FirstAidKitService;
import com.zhuk.service.GarrotService;
import com.zhuk.service.GlovesService;

//@PWA(name = "My App", shortName = "My App", enableInstallPrompt = false)
@Route(value = "", layout = MainLayout.class)
public class AidKitList extends VerticalLayout {
    
    private final FirstAidKitService firstAidKitService;
    private final BandageService bandageService;
    private final GarrotService garrotService;
    private final GlovesService glovesService;
    private final Grid<FirstAidKit> grid = new Grid<>(FirstAidKit.class);
    private final AidkitForm form;

    public AidKitList(FirstAidKitService aidKitService,
                      BandageService bandageService,
                      GarrotService garrotService,
                      GlovesService glovesService) {

        this.firstAidKitService = aidKitService;
        this.bandageService = bandageService;
        this.garrotService = garrotService;
        this.glovesService = glovesService;
        addClassName("main-view");
        setSizeFull();
        configureGrid();

        form = new AidkitForm(bandageService.findAll(),
                    glovesService.findAll(),
                    garrotService.findAll());
        
        form.addListener(AidkitForm.SaveEvent.class, this::saveAidkit);
        form.addListener(AidkitForm.DeleteEvent.class, this::deleteAidkit);
        form.addListener(AidkitForm.CloseEvent.class, e -> closeEditor());

        Div content = new Div(grid, form);

        content.addClassName("content");
        content.setSizeFull();

        add(getToolBar(), content);
        updateList();
        
        closeEditor();
    }

    private HorizontalLayout getToolBar() {
        Button addContactButton = new Button("Add aidkit");
        addContactButton.addClickListener(click -> addAidkit());
        HorizontalLayout toolbar = new HorizontalLayout(addContactButton);
        toolbar.addClassName("toolbar");
        return toolbar;
    }

    private void addAidkit() {
        grid.asSingleSelect().clear();
        editAidkit(new FirstAidKit());
    }

    private void saveAidkit(AidkitForm.SaveEvent event) {
        firstAidKitService.save(event.getFirstAidKit());
        updateList();
        closeEditor();
    }

    

    private void deleteAidkit(AidkitForm.DeleteEvent event) {
        firstAidKitService.delete(event.getFirstAidKit().getId());
        updateList();
        closeEditor();
    }

    private void closeEditor() {
        form.setAidkit(null);
        form.setVisible(false);
        removeClassName("editing");
    }

    private void updateList() {
        grid.setItems(firstAidKitService.findAll());
    }

    private void configureGrid() {
        grid.addClassName("aidkit-grid");
        grid.setSizeFull();
        grid.removeAllColumns();
        grid.addColumn(FirstAidKit::getId).setHeader("#");

        grid.addColumn(aidkit -> {
            String name = aidkit.getName();
            return name == null ? "-" : name;
        }).setHeader("Name");

        grid.addColumn(aidkit -> {
            Bandage bandage = aidkit.getBandage();
            return bandage == null ? "-" : bandage.getName();
        }).setHeader("Bandage");

        grid.addColumn(aidkit -> {
            Garrot garrot = aidkit.getGarrot();
            return garrot == null ? "-" : garrot.getName();
        }).setHeader("Garrot");

        grid.addColumn(aidkit -> {
            Gloves gloves = aidkit.getGloves();
            return gloves == null ? "-" : gloves.getName();
        }).setHeader("Gloves");

        grid.addComponentColumn(action -> new Button("Order",
                click -> Notification.show("Successfully ordered"))).setHeader("Action");

        grid.getColumns().forEach(col -> col.setAutoWidth(true));

        grid.asSingleSelect().addValueChangeListener(event ->
                editAidkit(event.getValue()));
    }

    private void editAidkit(FirstAidKit value) {
        if (value == null) {
            closeEditor();
        } else {
            form.setAidkit(value);
            form.setVisible(true);
            addClassName("editing");
        }
    }
}
