package com.bookmanage.application;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.stage.Stage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * @author lq
 * 创建时间 2019/5/3 16:10
 **/
public class MainApp extends Application {
    private static Logger logger = LogManager.getLogger(MainApp.class);
    @Override
    public void start(Stage primaryStage) throws Exception {
        logger.info("Starting application");
        Platform.setImplicitExit(true);
        ScreenManager screens = new ScreenManager();
        screens.setPrimaryStage(primaryStage);
        screens.showLoginStage();
    }
}
