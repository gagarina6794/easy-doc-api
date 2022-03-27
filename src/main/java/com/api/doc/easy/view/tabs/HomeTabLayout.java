package com.api.doc.easy.view.tabs;

import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;

public class HomeTabLayout extends VerticalLayout {

    public HomeTabLayout() {
        this.setSizeFull();
        this.add(new Label("HOME"));
    }
}
