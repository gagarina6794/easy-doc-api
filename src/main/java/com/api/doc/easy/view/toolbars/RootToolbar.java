package com.api.doc.easy.view.toolbars;

import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;

public class RootToolbar extends HorizontalLayout {

    public RootToolbar() {
        super();
        init();
    }

    private void init() {
        this.setWidthFull();
        this.setMargin(false);
        this.setPadding(true);
        this.setSpacing(true);
        this.setDefaultVerticalComponentAlignment(Alignment.CENTER);
        this.setJustifyContentMode(JustifyContentMode.START);

        Icon versionsIcon = new Icon(VaadinIcon.CONNECT_O);
        versionsIcon.addClassName("toolbar-icon");
        Icon rolesIcon = new Icon(VaadinIcon.USERS);
        rolesIcon.addClassName("toolbar-icon");
        Icon permissionsIcon = new Icon(VaadinIcon.KEY);
        permissionsIcon.addClassName("toolbar-icon");
        this.add(versionsIcon, rolesIcon, permissionsIcon);

    }
}
