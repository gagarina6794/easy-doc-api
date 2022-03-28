package com.api.doc.easy.view.toolbars;

import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.textfield.TextField;

import java.util.List;

public class NavigationToolbar extends HorizontalLayout {

    public NavigationToolbar() {
        super();
        init();
    }

    private void init() {
        this.setWidthFull();
        this.setMargin(false);
        this.setPadding(true);
        this.setSpacing(true);
        this.setJustifyContentMode(JustifyContentMode.END);
        this.setDefaultVerticalComponentAlignment(Alignment.CENTER);

        TextField textField = new TextField();
        textField.setWidth("250px");
        textField.setPrefixComponent(new Icon(VaadinIcon.SEARCH));

        ComboBox<String> versionCombobox = new ComboBox<>();
        versionCombobox.setWidth("200px");
        versionCombobox.setItems(List.of("1", "2", "3"));

        this.add(textField, versionCombobox);
    }
}
