package com.xavier;

import com.xavier.module.generate.ui.GenerateView;
import com.xavier.module.window.service.impl.WindowServiceImpl;
import com.xavier.util.SpringContextUtil;
import de.felixroske.jfxsupport.AbstractJavaFxApplicationSupport;
import javafx.application.Platform;
import javafx.stage.Stage;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.awt.*;

@SpringBootApplication
public class GenerateApplication extends AbstractJavaFxApplicationSupport {

	public static void main(String[] args) {
		launchApp(GenerateApplication.class, GenerateView.class, args);
	}

	@Override
	public void start(Stage stage) throws Exception {
		SystemTray.isSupported();
		super.start(stage);
		getStage().setOnCloseRequest(
				event -> {
					Platform.setImplicitExit(false);
					Platform.runLater(getStage()::hide);
					WindowServiceImpl windowService = SpringContextUtil.getApplicationContext().getBean(WindowServiceImpl.class);
					windowService.enableTray();
				}
		);
	}
}
