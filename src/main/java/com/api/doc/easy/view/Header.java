package com.api.doc.easy.view;

import com.api.doc.easy.service.ApplicationService;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.tabs.Tab;
import com.vaadin.flow.component.tabs.Tabs;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import javax.annotation.Nullable;
import java.util.HashMap;
import java.util.Map;

import static com.api.doc.easy.view.CreateApplicationForm.*;

@Component
public class Header extends HorizontalLayout {

    private final ApplicationService applicationService;
    private final ApplicationContext context;

    private final Map<String, Tab> tabsMap = new HashMap<>();
    private String lastSelectedTabId = null;

    private Tabs tabs;

    public Header(ApplicationService applicationService, ApplicationContext context) {
        this.applicationService = applicationService;
        this.context = context;
        init();
    }

    private void init() {
        this.setWidthFull();
        this.setDefaultVerticalComponentAlignment(Alignment.CENTER);
        this.setJustifyContentMode(JustifyContentMode.START);

        Image logoImage = new Image("icons/logo.png", "");
        logoImage.setWidth("200px");

        tabs = new Tabs();
        tabs.setWidthFull();
        tabs.addSelectedChangeListener(selectedChangeEvent -> {
            Tab selectedTab = selectedChangeEvent.getSelectedTab();
            String selectedTabId = selectedTab == null ? null : selectedTab.getId().orElse(null);

            if (context != null) {
                Body bodyBean = context.getBean(Body.class);
                bodyBean.reload(selectedTabId, lastSelectedTabId);
            }
            lastSelectedTabId = selectedTabId;
        });

        initTabs(tabs);

        this.add(logoImage, tabs);
    }

    private void initTabs(Tabs tabs) {
        tabs.add(getHomeTab());
        if (applicationService != null) {
            applicationService.getAll().forEach(applicationItem -> {
                Tab tab = new Tab(applicationItem.getName());
                String tabId = String.valueOf(applicationItem.getId());
                tab.setId(tabId);
                tabsMap.put(tabId, tab);
                tabs.add(tab);
            });
        }
        tabs.add(getPlusTab());
    }

    private Tab getHomeTab() {
        Icon addTabIcon = new Icon(VaadinIcon.HOME);
        addTabIcon.setColor("#709fdc");
        Tab tab = new Tab(addTabIcon);
        String homeTabId = String.valueOf(HOME_TAB_ID);
        tab.setId(homeTabId);
        tabsMap.put(homeTabId, tab);
        return tab;
    }

    private Tab getPlusTab() {
        Icon addTabIcon = new Icon(VaadinIcon.PLUS);
        addTabIcon.setColor("#709fdc");
        Tab tab = new Tab(addTabIcon);
        String plusTabId = String.valueOf(PLUS_TAB_ID);
        tab.setId(plusTabId);
        tabsMap.put(plusTabId, tab);
        return tab;
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
            tabs.setSelectedTab(tabsMap.get(HOME_TAB_STR_ID));
        }
    }
}
