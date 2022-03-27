package com.api.doc.easy.view;

import com.api.doc.easy.model.ApplicationItem;
import com.api.doc.easy.service.ApplicationService;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.textfield.TextField;

public class CreateApplicationForm extends FormLayout {

    public static final Long HOME_TAB_ID = -1L;
    public static final Long PLUS_TAB_ID = -2L;
    public static final String HOME_TAB_STR_ID = String.valueOf(HOME_TAB_ID);
    public static final String PLUS_TAB_STR_ID = String.valueOf(PLUS_TAB_ID);

    public CreateApplicationForm(ApplicationService applicationService, Header header, String selectedTabId) {
        this.setWidth("400px");

        TextField applicationNameField = new TextField();
        applicationNameField.setWidthFull();
        this.addFormItem(applicationNameField, "Application name");

        Button createButton = new Button("Create", e -> {
            String applicationName = applicationNameField.getValue();
            if (applicationName != null && !applicationName.trim().isEmpty()) {
                ApplicationItem saved = applicationService.save(new ApplicationItem(applicationName));
                header.reloadTabs();
                header.setActiveTab(String.valueOf(saved.getId()));
            }
        });
        Button cancelButton = new Button("Cancel", e -> header.setActiveTab(selectedTabId));
        HorizontalLayout buttonsLayout = new HorizontalLayout();
        buttonsLayout.setMargin(false);
        buttonsLayout.setPadding(false);
        buttonsLayout.setDefaultVerticalComponentAlignment(FlexComponent.Alignment.CENTER);
        buttonsLayout.setJustifyContentMode(FlexComponent.JustifyContentMode.END);
        buttonsLayout.add(cancelButton, createButton);
        this.addFormItem(buttonsLayout, "");
    }
}
