package com.api.doc.easy.view.layouts;

import com.vaadin.flow.component.splitlayout.SplitLayout;

public class MainSplitLayout extends SplitLayout {

    private final LeftSplitLayout leftSplitLayout = new LeftSplitLayout();
    private final RightSplitLayout rightSplitLayout = new RightSplitLayout();

    public MainSplitLayout() {
        init();
    }

    private void init() {
        this.setSizeFull();
        this.setSplitterPosition(20d);
        this.addToPrimary(leftSplitLayout);
        this.addToSecondary(rightSplitLayout);
    }
}
