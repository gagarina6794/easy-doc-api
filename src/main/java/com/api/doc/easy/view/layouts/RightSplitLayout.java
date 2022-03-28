package com.api.doc.easy.view.layouts;

import com.api.doc.easy.view.components.VerticalLayout;
import com.api.doc.easy.view.toolbars.NavigationToolbar;
import com.api.doc.easy.view.toolbars.RootToolbar;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;

import static com.api.doc.easy.R.styles.BOTTOM_BORDERED;

public class RightSplitLayout extends VerticalLayout {

    public RightSplitLayout() {
        super();
        init();
    }

    private void init() {
        this.setSizeFull();
        this.setDefaultHorizontalComponentAlignment(Alignment.START);

        RootToolbar rootToolbar = new RootToolbar();
        NavigationToolbar searchToolbar = new NavigationToolbar();

        HorizontalLayout toolbarLayout = new HorizontalLayout();
        toolbarLayout.setWidthFull();
        toolbarLayout.setHeight("40px");
        toolbarLayout.addClassName(BOTTOM_BORDERED);

        toolbarLayout.setJustifyContentMode(JustifyContentMode.START);
        toolbarLayout.add(rootToolbar, searchToolbar);

        this.add(toolbarLayout);

        DocumentationLayout documentationLayout = new DocumentationLayout();
        this.add(documentationLayout);
    }
}
