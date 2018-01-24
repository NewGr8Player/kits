package com.xavier.controller;

import com.xavier.Main;
import com.xavier.view.DBInfoView;
import de.felixroske.jfxsupport.FXMLController;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.Pane;
import javafx.stage.Modality;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.net.URL;
import java.util.ResourceBundle;

@FXMLController
public class MainController implements Initializable {

	private static final Log LOGGER = LogFactory.getLog(MainController.class);

	@FXML
	Pane dynamicPane;/* 主动态面板 */

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		LOGGER.info("Initialize:Unkonwn");
	}

	/**
	 * <p>弹出数据库连接信息视图</p>
	 *
	 * @param event 事件
	 */
	public void showDBInfoView(final Event event) {
		LOGGER.info(event.getEventType() + " - " + event.getTarget());
		Main.showView(DBInfoView.class, Modality.WINDOW_MODAL);/* 弹出数据库连接详情窗口 */
	}
}
