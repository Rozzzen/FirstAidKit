package com.zhuk.view;

import com.vaadin.flow.component.applayout.AppLayout;
import com.vaadin.flow.component.applayout.DrawerToggle;
import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.HighlightConditions;
import com.vaadin.flow.router.RouterLink;

@CssImport("./styles/shared-styles.css")
public class MainLayout extends AppLayout {

    public MainLayout() {
        createHeader();
        createDrawer();
    }

    private void createHeader() {
        H1 logo = new H1("AidKit Application");
        logo.addClassName("logo");

        HorizontalLayout header = new HorizontalLayout(new DrawerToggle(), logo);

        header.expand(logo);

        header.setDefaultVerticalComponentAlignment(
                FlexComponent.Alignment.CENTER);
        header.setWidth("100%");
        header.addClassName("header");


        addToNavbar(header);

    }

    private void createDrawer() {
        RouterLink aidkitLink = new RouterLink("Aidkits", AidKitList.class);
        RouterLink bandageLink = new RouterLink("Bandages", BandageList.class);
        RouterLink garrotLink = new RouterLink("Garrots", GarrotList.class);
        RouterLink glovesLink = new RouterLink("Gloves", GlovesList.class);
        aidkitLink.setHighlightCondition(HighlightConditions.sameLocation());

        addToDrawer(new VerticalLayout(aidkitLink, bandageLink, garrotLink, glovesLink));
    }
}
