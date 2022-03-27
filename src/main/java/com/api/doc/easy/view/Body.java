package com.api.doc.easy.view;

import com.api.doc.easy.model.ApplicationItem;
import com.api.doc.easy.view.tabs.HomeTabLayout;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;

import javax.annotation.Nullable;

import static com.api.doc.easy.view.CreateApplicationForm.HOME_TAB_STR_ID;
import static com.api.doc.easy.view.CreateApplicationForm.PLUS_TAB_STR_ID;

public class Body extends HorizontalLayout {

    private final MainView mainView;

    public Body(MainView mainView) {
        this.mainView = mainView;
        init();
    }

    private void init() {
        this.setSizeFull();
        this.setDefaultVerticalComponentAlignment(Alignment.START);
        this.setJustifyContentMode(JustifyContentMode.CENTER);
        this.add(new HomeTabLayout());
    }

    public void reload(@Nullable String applicationId, @Nullable String previousSelectedTabId) {
        if (PLUS_TAB_STR_ID.equals(applicationId)) {
            CreateApplicationForm createApplicationForm = new CreateApplicationForm(mainView.getApplicationService(), mainView.getHeader(), previousSelectedTabId);
            this.removeAll();
            this.add(createApplicationForm);
        } else if (HOME_TAB_STR_ID.equals(applicationId) || applicationId == null) {
            this.removeAll();
            this.add(new Label("HOME"));
        } else {
            ApplicationItem applicationItem = mainView.getApplicationService().getById(Long.parseLong(applicationId));
            this.removeAll();
            if (applicationItem != null) {
                this.add(new Label(applicationItem.getName() + " " + applicationItem.getDate()));
            } else {
                this.add(new Label("HOME"));
            }
        }

    }


}
