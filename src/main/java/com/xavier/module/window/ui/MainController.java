package com.xavier.module.window.ui;

import de.felixroske.jfxsupport.FXMLController;
import javafx.event.ActionEvent;
import com.xavier.GenerateApplication;
import com.xavier.module.generate.ui.GenerateView;


@FXMLController
public class MainController {

    public void showGenerate(ActionEvent actionEvent) {
        GenerateApplication.showView(GenerateView.class);
    }


}
