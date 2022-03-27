package com.api.doc.easy.view.toolbars;

import com.api.doc.easy.view.components.HorizontalLayout;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.icon.VaadinIcon;

public class EditTabToolbar extends HorizontalLayout {

    public EditTabToolbar() {
        super();
        init();
    }

    private void init() {
        this.setWidthFull();
        this.setSpacing(true);
        this.setDefaultVerticalComponentAlignment(Alignment.CENTER);

        Label label = new Label("Application tab");
        label.getStyle().set("margin-left", "10px");
        Icon splitIcon = new Icon(VaadinIcon.LINE_V);
        Icon editIcon = new Icon(VaadinIcon.EDIT);
        editIcon.addClassName("toolbar-icon");
        Icon deleteIcon = new Icon(VaadinIcon.CLOSE);
        deleteIcon.addClassName("toolbar-icon");
        this.add(label, splitIcon, editIcon, deleteIcon);
    }
}
