package com.api.doc.easy.view;

import com.api.doc.easy.model.ApplicationItem;
import com.api.doc.easy.service.ApplicationService;
import com.api.doc.easy.view.tabs.HomeTabLayout;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import javax.annotation.Nullable;

import static com.api.doc.easy.view.CreateApplicationForm.HOME_TAB_STR_ID;
import static com.api.doc.easy.view.CreateApplicationForm.PLUS_TAB_STR_ID;

@Component
public class Body extends HorizontalLayout {

    private final ApplicationService applicationService;
    private final ApplicationContext context;

    public Body(ApplicationService applicationService, ApplicationContext context) {
        this.applicationService = applicationService;
        this.context = context;
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
            CreateApplicationForm createApplicationForm = new CreateApplicationForm(applicationService, context.getBean(Header.class), previousSelectedTabId);
            this.removeAll();
            this.add(createApplicationForm);
        } else if (HOME_TAB_STR_ID.equals(applicationId) || applicationId == null) {
            this.removeAll();
            this.add(new Label("HOME"));
        } else {
            ApplicationItem applicationItem = applicationService.getById(Long.parseLong(applicationId));
            this.removeAll();
            if (applicationItem != null) {
                this.add(new Label(applicationItem.getName() + " " + applicationItem.getDate()));
            } else {
                this.add(new Label("HOME"));
            }
        }

    }


}
