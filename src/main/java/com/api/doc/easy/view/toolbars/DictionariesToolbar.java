package com.api.doc.easy.view.toolbars;

import com.api.doc.easy.view.components.HorizontalLayout;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.icon.VaadinIcon;

public class DictionariesToolbar extends HorizontalLayout {

    public DictionariesToolbar() {
        super();
        init();
    }

    private void init() {
        this.setWidthFull();
        this.setSpacing(true);
        this.setDefaultVerticalComponentAlignment(Alignment.CENTER);

        Label label = new Label("Dictionary");
        label.getStyle().set("margin-left", "10px");
        Icon splitIcon = new Icon(VaadinIcon.LINE_V);
        Icon rolesIcon = new Icon(VaadinIcon.USERS);
        rolesIcon.addClassName("toolbar-icon");
        Icon permissionsIcon = new Icon(VaadinIcon.KEY);
        permissionsIcon.addClassName("toolbar-icon");
        this.add(label, splitIcon, rolesIcon, permissionsIcon);
    }
}
