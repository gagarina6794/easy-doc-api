package com.api.doc.easy.view;

import com.api.doc.easy.model.ApplicationItem;
import com.api.doc.easy.view.components.HorizontalLayout;
import com.api.doc.easy.view.tab.ApplicationTabLayout;
import com.api.doc.easy.view.tab.FormTabLayout;

import javax.annotation.Nullable;
import java.util.List;

import static com.api.doc.easy.R.styles.TOP_BORDERED;
import static com.api.doc.easy.view.tab.FormTabLayout.PLUS_TAB_STR_ID;

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
        this.addClassName(TOP_BORDERED);

        List<ApplicationItem> applicationItems = mainView.getApplicationService().getAll();
        if (applicationItems != null && !applicationItems.isEmpty()) {
            reload(String.valueOf(applicationItems.get(0).getId()), null);
        } else {
            reload(null, null);
        }
    }

    public void reload(@Nullable String applicationId, @Nullable String previousSelectedTabId) {
        FormTabLayout createApplicationForm = new FormTabLayout(mainView.getApplicationService(), mainView.getHeader(), previousSelectedTabId);

        if (PLUS_TAB_STR_ID.equals(applicationId) || applicationId == null) {
            this.removeAll();
            this.add(createApplicationForm);
        } else {
            ApplicationItem applicationItem = mainView.getApplicationService().getById(Long.parseLong(applicationId));
            this.removeAll();
            if (applicationItem != null) {
                this.add(new ApplicationTabLayout());
            } else {
                this.add(createApplicationForm);
            }
        }

    }


}
