package com.api.doc.easy.view.tab;

import com.api.doc.easy.view.components.VerticalLayout;
import com.vaadin.flow.component.html.Label;

public class HomeTabLayout extends VerticalLayout {

    public HomeTabLayout() {
        super();
        this.setSizeFull();
        this.add(new Label("HOME"));
    }
}
