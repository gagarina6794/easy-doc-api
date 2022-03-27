package com.api.doc.easy.view.tab;

import com.api.doc.easy.view.components.HorizontalLayout;
import com.api.doc.easy.view.layouts.MainSplitLayout;
import com.api.doc.easy.view.layouts.SideBarLayout;

public class ApplicationTabLayout extends HorizontalLayout {

    private final SideBarLayout sideBarLayout = new SideBarLayout();
    private final MainSplitLayout mainSplitLayout = new MainSplitLayout();

    public ApplicationTabLayout() {
        super();
        init();
    }

    private void init() {
        this.setSizeFull();
        add(sideBarLayout, mainSplitLayout);
    }
}
