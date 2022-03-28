package com.api.doc.easy.view.layouts;

import com.api.doc.easy.view.components.VerticalLayout;

import static com.api.doc.easy.R.styles.RIGHT_BORDERED;

public class SideBarLayout extends VerticalLayout {

    public SideBarLayout() {
        super();
        init();
    }

    private void init() {
        this.setWidth("300px");
        this.setHeightFull();
        this.addClassName(RIGHT_BORDERED);
    }
}
