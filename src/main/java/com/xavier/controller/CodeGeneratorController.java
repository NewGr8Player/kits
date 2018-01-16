package com.xavier.controller;

import com.xavier.bean.dbConnection.DBConnection;
import com.xavier.service.dbConnection.DBConnectionService;
import de.felixroske.jfxsupport.FXMLController;
import javafx.collections.FXCollections;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import org.springframework.beans.factory.annotation.Autowired;

@FXMLController
public class CodeGeneratorController {

	@FXML
	TextField connectionNameTextField;
	@FXML
	TextField urlTextField;
	@FXML
	ChoiceBox<String> driverChoiceBox;
	@FXML
	TextField usernameTextField;
	@FXML
	TextField passwordTextField;

	@Autowired
	private DBConnectionService dbConnectionService;

	public void findConnectionDetails(final Event event) {
		this.dbConnectionService.findConnectionDetails(
				new DBConnection(connectionNameTextField.getText(),
						urlTextField.getText(), driverChoiceBox.getValue(),
						usernameTextField.getText(), passwordTextField.getText()));
	}
}
