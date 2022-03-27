package com.api.doc.easy.view.layouts;


import com.api.doc.easy.view.components.VerticalLayout;
import com.api.doc.easy.view.toolbars.DictionariesToolbar;
import com.api.doc.easy.view.toolbars.EditTabToolbar;
import com.api.doc.easy.view.toolbars.NavigationToolbar;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;

public class RightSplitLayout extends VerticalLayout {

    public RightSplitLayout() {
        super();
        init();
    }

    private void init() {
        this.setSizeFull();
        this.setDefaultHorizontalComponentAlignment(Alignment.START);

        DictionariesToolbar dictionariesToolbar = new DictionariesToolbar();
        EditTabToolbar editTabToolbar = new EditTabToolbar();

        HorizontalLayout toolbarLayout = new HorizontalLayout();
        toolbarLayout.setWidthFull();
        toolbarLayout.setHeight("40px");
        toolbarLayout.setMargin(false);
        toolbarLayout.setPadding(false);
        toolbarLayout.setSpacing(false);
        toolbarLayout.setJustifyContentMode(JustifyContentMode.BETWEEN);
        toolbarLayout.add(dictionariesToolbar, editTabToolbar);

        this.add(toolbarLayout);

        NavigationToolbar navigationToolbar = new NavigationToolbar();
        this.add(navigationToolbar);

        DocumentationLayout documentationLayout = new DocumentationLayout();
        this.add(documentationLayout);
    }
}
