package com.api.doc.easy.view;

import com.api.doc.easy.view.components.ConfirmDialog;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.tabs.Tab;
import com.vaadin.flow.component.tabs.Tabs;

import javax.annotation.Nullable;
import java.util.HashMap;
import java.util.Map;

import static com.api.doc.easy.view.tab.FormTabLayout.PLUS_TAB_ID;
import static com.api.doc.easy.view.tab.FormTabLayout.PLUS_TAB_STR_ID;

public class Header extends HorizontalLayout {

    private final MainView mainView;
    private Tab addTabForm;

    private final Map<String, Tab> tabsMap = new HashMap<>();
    private String lastSelectedTabId = null;

    private Tabs tabs;

    public Header(MainView mainView) {
        this.mainView = mainView;
        init();
    }

    private void init() {
        this.setWidthFull();
        this.setPadding(true);
        this.setDefaultVerticalComponentAlignment(Alignment.CENTER);
        this.setJustifyContentMode(JustifyContentMode.START);

        Image logoImage = new Image("icons/logo.svg", "");
        logoImage.setWidth("200px");

        tabs = new Tabs();
        tabs.setWidthFull();
        tabs.addSelectedChangeListener(selectedChangeEvent -> {
            Tab selectedTab = selectedChangeEvent.getSelectedTab();
            String selectedTabId = selectedTab == null ? null : selectedTab.getId().orElse(null);

            if (mainView != null) {
                Body body = mainView.getBody();
                if (body != null) {
                    body.reload(selectedTabId, lastSelectedTabId);
                }
            }
            lastSelectedTabId = selectedTabId;
        });

        initTabs(tabs);

        Icon editIcon = new Icon(VaadinIcon.EDIT);
        editIcon.addClassName("toolbar-icon");
        editIcon.setColor("#709fdc");
        editIcon.addClickListener(iconClickEvent -> {
            Tab selectedTab = tabs.getSelectedTab();

            if (selectedTab != null && mainView != null) {
                String selectedTabId = selectedTab.getId().orElse(null);

                if (String.valueOf(PLUS_TAB_ID).equals(selectedTabId) || selectedTabId == null) {
                    new Notification("Selected tab can't be changed", 2_000, Notification.Position.MIDDLE).open();
                } else {

                    String applicationItemName = selectedTab.getLabel();
                    tabs.setSelectedTab(addTabForm);
                    mainView.getBody().getCreateApplicationForm().updateApplicationItem(selectedTabId, applicationItemName);
                }
            }
        });

        Icon deleteIcon = new Icon(VaadinIcon.CLOSE);
        deleteIcon.addClassName("toolbar-icon");
        deleteIcon.setColor("#511932");
        deleteIcon.addClickListener(iconClickEvent -> {
            Tab selectedTab = tabs.getSelectedTab();

            if (selectedTab != null && mainView != null) {
                String selectedTabId = selectedTab.getId().orElse(null);

                if (String.valueOf(PLUS_TAB_ID).equals(selectedTabId) || selectedTabId == null) {
                    new Notification("Selected tab can't be removed", 2_000, Notification.Position.MIDDLE).open();
                } else {
                    new ConfirmDialog("Delete '" + selectedTab.getLabel() + "' application tab?",
                            () -> {
                                mainView.getApplicationService().delete(Long.parseLong(selectedTabId));
                                reloadTabs();
                            }
                    ).open();
                }
            }
        });

        this.add(logoImage, tabs, editIcon, deleteIcon);
    }

    private void initTabs(Tabs tabs) {
        if (mainView != null) {
            mainView.getApplicationService().getAll().forEach(applicationItem -> {
                Tab tab = new Tab(applicationItem.getName());
                String tabId = String.valueOf(applicationItem.getId());
                tab.setId(tabId);
                tabsMap.put(tabId, tab);
                tabs.add(tab);
            });
        }
        tabs.add(getPlusTab());
    }

    private Tab getPlusTab() {
        Icon addTabIcon = new Icon(VaadinIcon.PLUS);
        addTabIcon.setColor("#afca54");
        addTabForm = new Tab(addTabIcon);
        String plusTabId = String.valueOf(PLUS_TAB_ID);
        addTabForm.setId(plusTabId);
        tabsMap.put(plusTabId, addTabForm);
        return addTabForm;
    }

    public void reloadTabs() {
        tabsMap.clear();
        tabs.removeAll();
        initTabs(tabs);
    }

    public void setActiveTab(@Nullable String tabId) {
        Tab tab = tabsMap.get(tabId);
        if (tab != null) {
            tabs.setSelectedTab(tab);
        } else {
            tabs.setSelectedTab(tabsMap.get(PLUS_TAB_STR_ID));
        }
    }
}
