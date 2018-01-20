package com.xavier.controller;

import com.xavier.view.CodeGeneratorView;
import de.felixroske.jfxsupport.FXMLController;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.scene.layout.Pane;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;

@FXMLController
public class MainController {

    private static final Log LOGGER = LogFactory.getLog(MainController.class);

    @FXML
    Pane myDynamicPane;/* 主动态面板 */

    @Autowired
    CodeGeneratorView codeGeneratorView;/* 代码生成器页面 */

    /**
     * <p>显示代码生成器视图</p>
     *
     * @param event 事件
     */
    public void showCodeGeneratorView(final Event event) {
        LOGGER.info(event.getEventType() + " - " + event.getTarget());
        myDynamicPane.getChildren().clear();
        myDynamicPane.getChildren().add(codeGeneratorView.getView());
    }
}
