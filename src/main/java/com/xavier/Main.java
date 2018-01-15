package com.xavier;

import com.xavier.view.MainView;
import de.felixroske.jfxsupport.AbstractJavaFxApplicationSupport;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Main extends AbstractJavaFxApplicationSupport {
	public static void main(String[] args) {
		launch(Main.class, MainView.class, args);
	}
}