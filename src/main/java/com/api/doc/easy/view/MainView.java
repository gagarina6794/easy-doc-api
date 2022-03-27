package com.api.doc.easy.view;

import com.api.doc.easy.service.ApplicationService;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import org.springframework.context.ApplicationContext;

@PageTitle("easy-doc-api")
@Route(value = "")
public class MainView extends VerticalLayout {

    private final ApplicationService applicationService;
    private final ApplicationContext context;

    private final Header header;
    private final Body body;

    public MainView(ApplicationService applicationService, ApplicationContext context) {
        this.applicationService = applicationService;
        this.context = context;
        this.header = new Header(this);
        this.body = new Body(this);

        this.setSizeFull();
        this.setJustifyContentMode(JustifyContentMode.START);

        this.add(header, body);
    }

    public ApplicationService getApplicationService() {
        return applicationService;
    }

    public ApplicationContext getContext() {
        return context;
    }

    public Header getHeader() {
        return header;
    }

    public Body getBody() {
        return body;
    }
}
