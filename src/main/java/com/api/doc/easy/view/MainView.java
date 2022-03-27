package com.api.doc.easy.view;

import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

@PageTitle("easy-doc-api")
@Route(value = "")
public class MainView extends VerticalLayout {

    private Header header;
    private Body body;

    public MainView(Header header, Body body) {
        this.header = header;
        this.body = body;

        this.setSizeFull();
        this.setJustifyContentMode(JustifyContentMode.START);

        this.add(header, body);
    }
}
