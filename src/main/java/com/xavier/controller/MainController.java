package com.xavier.controller;

import de.felixroske.jfxsupport.FXMLController;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.scene.layout.Pane;

@FXMLController
public class MainController {

	@FXML
	Pane myDynamicPane;

	public void showSomeButtonView(final Event e){
		System.out.println("----------------");
	}
}
