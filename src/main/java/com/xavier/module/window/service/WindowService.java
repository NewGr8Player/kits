package com.xavier.module.window.service;

import de.felixroske.jfxsupport.AbstractFxmlView;
import javafx.stage.Stage;


public interface WindowService {
	/**
	 * <p>托盘</p>
	 */
	void enableTray();

	/**
	 * <p>显示dialog</p>
	 *
	 * @param dialogView
	 * @param title
	 * @param width
	 * @param height
	 */
	void showDialog(final Class<? extends AbstractFxmlView> dialogView, String title, double width, double height);

	/**
	 * <p>获取dialog</p>
	 *
	 * @param viewClass
	 * @return
	 */
	Stage getDialogStage(Class viewClass);

	void closeDialog(Class viewClass);
}
