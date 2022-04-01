package com.api.doc.easy.view.components;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.dialog.Dialog;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.orderedlayout.FlexComponent;

import javax.validation.constraints.NotNull;

public class ConfirmDialog extends Dialog {

    public ConfirmDialog(@NotNull String question, DialogCallback callback) {
        this.setWidth("400px");

        VerticalLayout rootLayout = new VerticalLayout();
        rootLayout.setSpacing(true);
        this.add(rootLayout);

        Label questionLabel = new Label(question);
        rootLayout.add(questionLabel);

        Button cancelButton = new Button("Cancel", buttonClickEvent -> this.close());
        Button okButton = new Button("Ok", buttonClickEvent -> {
            callback.execute();
            this.close();
        });

        HorizontalLayout buttonsLayout = new HorizontalLayout();
        buttonsLayout.setSpacing(true);
        buttonsLayout.add(cancelButton, okButton);

        rootLayout.add(buttonsLayout);
        rootLayout.setHorizontalComponentAlignment(FlexComponent.Alignment.CENTER, questionLabel);
        rootLayout.setHorizontalComponentAlignment(FlexComponent.Alignment.END, buttonsLayout);
        rootLayout.setJustifyContentMode(FlexComponent.JustifyContentMode.CENTER);
    }

    @FunctionalInterface
    public interface DialogCallback {
        void execute();
    }
}
