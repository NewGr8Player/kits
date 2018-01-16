package com.xavier.controller;

import com.xavier.view.CodeGeneratorView;
import de.felixroske.jfxsupport.FXMLController;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.scene.layout.Pane;
import org.springframework.beans.factory.annotation.Autowired;

@FXMLController
public class MainController {

	@FXML
	Pane myDynamicPane;

	@Autowired
	CodeGeneratorView codeGeneratorView;

	public void showCodeGeneratorView(final Event e){
		myDynamicPane.getChildren().clear();
		myDynamicPane.getChildren().add(codeGeneratorView.getView());
	}
}
