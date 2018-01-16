package com.xavier.controller;

import com.xavier.bean.dbConnection.DBConnection;
import com.xavier.service.dbConnection.DBConnectionService;
import de.felixroske.jfxsupport.FXMLController;
import javafx.collections.FXCollections;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import org.springframework.beans.factory.annotation.Autowired;

@FXMLController
public class CodeGeneratorController {

	@FXML
	TextField connectionNameTextField;
	@FXML
	TextField urlTextField;
	@FXML
	ComboBox<String> driverChoiceBox;
	@FXML
	TextField usernameTextField;
	@FXML
	TextField passwordTextField;

	@Autowired
	private DBConnectionService dbConnectionService;

	//TODO Unfinished ,to set driver-options here.
	public void Init() {
		this.driverChoiceBox.setItems(FXCollections.observableArrayList("MySql", "Orancle"));
	}

	public void findConnectionDetails(final Event event) {
		this.dbConnectionService.findConnectionDetails(
				new DBConnection(connectionNameTextField.getText(),
						urlTextField.getText(), driverChoiceBox.getValue(),
						usernameTextField.getText(), passwordTextField.getText()));
	}
}
