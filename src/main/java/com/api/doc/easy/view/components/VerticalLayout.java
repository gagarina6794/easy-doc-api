package com.api.doc.easy.view.components;

import com.vaadin.flow.component.dependency.CssImport;

@CssImport("./themes/myapi/styles.css")
public abstract class VerticalLayout extends com.vaadin.flow.component.orderedlayout.VerticalLayout {

    public static final String BORDERED = "bordered";

    public VerticalLayout() {
        this.addClassName(BORDERED);
        this.setMargin(false);
        this.setPadding(false);
        this.setSpacing(false);
    }
}
