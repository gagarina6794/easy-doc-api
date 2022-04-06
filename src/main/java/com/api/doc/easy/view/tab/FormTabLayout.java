package com.api.doc.easy.view.tab;

import com.api.doc.easy.model.ApplicationItem;
import com.api.doc.easy.service.ApplicationService;
import com.api.doc.easy.view.Header;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.textfield.TextField;

import javax.annotation.Nullable;
import javax.validation.constraints.NotNull;

public class FormTabLayout extends FormLayout {

    public static final Long PLUS_TAB_ID = -1L;
    public static final String PLUS_TAB_STR_ID = String.valueOf(PLUS_TAB_ID);

    private final ApplicationService applicationService;
    private final Header header;
    private String tabId;
    private String tabName;

    private TextField applicationNameField;

    public FormTabLayout(ApplicationService applicationService, Header header, String tabId) {
        this.applicationService = applicationService;
        this.header = header;
        this.tabId = tabId;
        init();
    }

    private void init() {
        this.setWidth("400px");

        applicationNameField = new TextField();
        applicationNameField.setWidthFull();
        this.addFormItem(applicationNameField, "Application name");

        Button createButton = new Button("Save", e -> {
            String applicationName = applicationNameField.getValue();
            if (applicationName != null && !applicationName.trim().isEmpty()) {
                Long applicationItemId;

                if (tabName == null) {
                    ApplicationItem saved = applicationService.save(new ApplicationItem(applicationName));
                    applicationItemId = saved.getId();
                } else {
                    applicationItemId = Long.parseLong(tabId);
                    applicationService.update(applicationItemId, applicationName);
                }

                header.reloadTabs();
                header.setActiveTab(String.valueOf(applicationItemId));
                clearForm();
            }
        });
        Button cancelButton = new Button("Cancel", e -> header.setActiveTab(tabId));
        HorizontalLayout buttonsLayout = new HorizontalLayout();
        buttonsLayout.setMargin(false);
        buttonsLayout.setPadding(false);
        buttonsLayout.setDefaultVerticalComponentAlignment(FlexComponent.Alignment.CENTER);
        buttonsLayout.setJustifyContentMode(FlexComponent.JustifyContentMode.END);
        buttonsLayout.add(cancelButton, createButton);
        this.addFormItem(buttonsLayout, "");
    }

    private void clearForm() {
        tabId = null;
        tabName = null;
        applicationNameField.clear();
    }

    public void updateApplicationItem(@NotNull String applicationItemId, @NotNull String applicationItemName) {
        this.tabId = applicationItemId;
        this.tabName = applicationItemName;
        applicationNameField.setValue(tabName);
    }
}
