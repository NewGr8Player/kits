package com.xavier.controller;

import com.xavier.bean.dbInfo.DBInfo;
import com.xavier.service.dbInfo.DBInfoService;
import de.felixroske.jfxsupport.FXMLController;
import javafx.collections.FXCollections;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.net.URL;
import java.util.ResourceBundle;

@FXMLController
public class DBInfoController implements Initializable {

    private static final Log LOGGER = LogFactory.getLog(DBInfoController.class);

    @FXML
    TextField connectionNameTextField;/* 连接名称文本框 */
    @FXML
    TextField urlTextField;/* 连接串文本框 */
    @FXML
    ComboBox<String> driverChoiceBox;/* 驱动选择框 */
    @FXML
    TextField usernameTextField;/* 用户名文本框 */
    @FXML
    TextField passwordTextField;/* 密码文本框 */

    @Autowired
    private DBInfoService dbConnectionService;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        LOGGER.info("Initialize:driverChoiceBox");
        /* 初始化下拉框 */
        //TODO 改成动态获取目前支持的数据库类型
        this.driverChoiceBox.setItems(FXCollections.observableArrayList("MySql", "Oracle"));
    }

    /**
     * <p>获取数据库连接详情</p>
     *
     * @param event 事件
     */
    public void findConnectionDetails(final Event event) {
        LOGGER.info(event.getEventType() + " - " + event.getTarget());
        this.dbConnectionService.getConnectionDetails(
                new DBInfo(connectionNameTextField.getText(),
                        urlTextField.getText(), driverChoiceBox.getValue(),
                        usernameTextField.getText(), passwordTextField.getText()));
    }
}
