package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.text.TextAlignment;
import javafx.stage.DirectoryChooser;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * @author lq
 * 创建时间 2019/4/12 0:46
 **/
public class FXMLExample5 extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    public void demo(Stage primaryStage) throws Exception {
        primaryStage.setTitle("listView");

        VBox vbox = new VBox();
        Scene scene = new Scene(vbox, 200, 200);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("listView");
        MenuItem option1 = new MenuItem("option1");
        option1.setGraphic(new ImageView("file:///C:\\Users\\lq\\Pictures\\test\\iconmonstr-save-1-32.png"));
        option1.setOnAction(event -> {
            System.out.println(event);
            System.out.println(option1.getText());
            System.out.println(this);
        });
        MenuItem option2 = new MenuItem("option2");
        option2.setGraphic(new ImageView("file:///C:\\Users\\lq\\Pictures\\test\\iconmonstr-edit-6-32.png"));
        MenuItem option3 = new MenuItem("option3");


        Menu menu4 = new Menu("menu4");
        MenuItem menuItem11 = new MenuItem("menuItem11");
        menu4.getItems().add(menuItem11);
//        MenuItem menuItem5 = new MenuItem("menu5");
        //支持多选
        CheckMenuItem menuItem5 = new CheckMenuItem("option5");
        CheckMenuItem menuItem6 = new CheckMenuItem("option6");
        Menu menu1 = new Menu("menu1");

        Menu menu7 = new Menu("radiomenu");
        ToggleGroup toggleGroup = new ToggleGroup();

        RadioMenuItem menuItem71 = new RadioMenuItem("option71");
        RadioMenuItem menuItem72 = new RadioMenuItem("option72");
        RadioMenuItem menuItem73 = new RadioMenuItem("option73");
        toggleGroup.getToggles().addAll(menuItem71,menuItem72,menuItem73);

        menu7.getItems().addAll(menuItem71,menuItem72,menuItem73);
        menu1.setOnShowing(e -> { System.out.println("Showing Menu 1"); });
        menu1.setOnShown  (e -> { System.out.println("Shown Menu 1"); });
        menu1.setOnHiding (e -> { System.out.println("Hiding Menu 1"); });
        menu1.setOnHidden (e -> { System.out.println("Hidden Menu 1"); });

        menu1.getItems().addAll(option1,option2,option3,menu4,new SeparatorMenuItem(),menuItem5,menuItem6,menu7);


        menu1.setGraphic(new ImageView("file:///C:\\Users\\lq\\Pictures\\test\\iconmonstr-menu-2-32.png"));
        MenuBar menuBar = new MenuBar();

        menuBar.getMenus().add(menu1);
        Menu menu2 = new Menu("menu2");
        Slider slider = new Slider(0,100,50);
        CustomMenuItem customMenuItem = new CustomMenuItem();
        customMenuItem.setContent(slider);
        customMenuItem.setHideOnClick(false);
        menu2.getItems().add(customMenuItem);

        Button button = new Button("custom menu item button");
        CustomMenuItem customMenuItem2 = new CustomMenuItem();
        customMenuItem2.setContent(button);
        customMenuItem2.setHideOnClick(false);
        menu2.getItems().add(customMenuItem2);


        menuBar.getMenus().add(menu2);
        VBox vbox = new VBox(menuBar);
        Scene scene = new Scene(vbox, 200, 200);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public void start12(Stage primaryStage) throws Exception {
        primaryStage.setTitle("listView");
        Button btn1 = new Button("Button1");
        Button btn2 = new Button("Button2");
        Button btn3 = new Button("Button3");
        Button btn4 = new Button("Button4");
        Button btn5 = new Button("Button5");
        Button btn6 = new Button("Button6");
        Button btn7 = new Button("Button7");

        GridPane gridPane = new GridPane();
        gridPane.add(btn1,0,0,1,1);
        gridPane.add(btn2,0,1,1,2);
        gridPane.add(btn3,0,2,1,1);
        gridPane.add(btn4,1,0,1,1);
        gridPane.add(btn5,1,1,1,1);
        gridPane.add(btn6,1,2,1,1);
        gridPane.add(btn7,2,0,1,1);
        gridPane.setVgap(10);
        gridPane.setHgap(10);


        VBox vbox = new VBox();
        Scene scene = new Scene(gridPane, 900, 900);
        primaryStage.setScene(scene);
        primaryStage.show();
    }


    public void start11(Stage primaryStage) throws Exception {
        primaryStage.setTitle("listView");
        Button btn1 = new Button("Button1");
        Button btn2 = new Button("Button2");
        Button btn3 = new Button("Button3");
        Button btn4 = new Button("Button4");
        Button btn5 = new Button("Button5");
        Button btn6 = new Button("Button6");
        Button btn7 = new Button("Button7");

        TilePane tilePane = new TilePane();
        tilePane.getChildren().addAll(btn1, btn2, btn3, btn4, btn5, btn6, btn7);
        tilePane.setHgap(10);
        tilePane.setVgap(10);
        tilePane.setAlignment(Pos.TOP_LEFT);


        VBox vbox = new VBox();
        Scene scene = new Scene(tilePane, 300, 300);
        primaryStage.setScene(scene);
        primaryStage.show();
    }


    public void start10(Stage primaryStage) throws Exception {
        primaryStage.setTitle("listView");
        Button button1 = new Button("button1");
        Button button2 = new Button("button2");
        Button button3 = new Button("button3");


        FlowPane flowPane = new FlowPane();

        flowPane.setHgap(10);
        flowPane.setVgap(40);
        flowPane.getChildren().addAll(button1, button2, button3);

        flowPane.setOrientation(Orientation.VERTICAL);
        Scene scene = new Scene(flowPane, 300, 300);
        primaryStage.setScene(scene);
        primaryStage.show();
    }


    public void start9(Stage primaryStage) throws Exception {
        primaryStage.setTitle("listView");
        Button button1 = new Button("button11111111");
        Button button2 = new Button("button 2");

        Group group = new Group();
        group.getChildren().addAll(button1, button2);


        Scene scene = new Scene(group, 200, 200);
        primaryStage.setScene(scene);
        primaryStage.show();
    }


    public void start8(Stage primaryStage) throws Exception {
        primaryStage.setTitle("listView");
        DirectoryChooser directoryChooser = new DirectoryChooser();
        directoryChooser.setInitialDirectory(new File("D:/test"));
        Button button = new Button("choose directory");

        button.setOnAction(event -> {
            File file = directoryChooser.showDialog(primaryStage);
            System.out.println(file.getAbsolutePath());
        });
        VBox vbox = new VBox(button);
        Scene scene = new Scene(vbox, 200, 200);
        primaryStage.setScene(scene);
        primaryStage.show();
    }


    public void start7(Stage primaryStage) throws Exception {
        primaryStage.setTitle("listView");

        FileChooser fileChooser = new FileChooser();
        fileChooser.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("TXT File", "*.txt")
                , new FileChooser.ExtensionFilter("jpg File", "*.jpg"));

        Button button = new Button("Select File");
        button.setOnAction(e -> {
            File selectedFile = fileChooser.showOpenDialog(primaryStage);
            System.out.println(selectedFile.getName());
        });
        VBox vbox = new VBox(button);
        Scene scene = new Scene(vbox, 200, 200);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public void start6(Stage primaryStage) throws Exception {
        primaryStage.setTitle("listView");
        Tooltip tooltip1 = new Tooltip("this is btn11111111111111111111111111111111111111");
        Tooltip tooltip2 = new Tooltip("this is btn1");
        tooltip1.setGraphic(new ImageView("file:///C:\\Users\\lq\\Pictures\\test\\tomcat.png"));

        ToolBar toolBar = new ToolBar();
        Button button1 = new Button("button1");
        Button button2 = new Button("button1");
        tooltip1.setWidth(110);
        tooltip1.setTextAlignment(TextAlignment.LEFT);
        button1.setTooltip(tooltip1);
        button2.setTooltip(tooltip2);

        toolBar.getItems().add(button1);
        toolBar.getItems().add(new Separator());
        toolBar.getItems().add(button2);
        toolBar.setOrientation(Orientation.VERTICAL);
        VBox vbox = new VBox(toolBar);
        Scene scene = new Scene(vbox, 200, 200);
        primaryStage.setScene(scene);
        primaryStage.show();
    }


    public void start5(Stage primaryStage) throws Exception {
        primaryStage.setTitle("listView");

        Button btn = new Button("print");
        DatePicker datePicker = new DatePicker();

        btn.setOnAction(event -> {
            LocalDate localDate = datePicker.getValue();
            if (localDate == null) {
                return;
            }
            String date = localDate.format(DateTimeFormatter.ISO_DATE);
            System.out.println(date);
        });

        PasswordField passwordField = new PasswordField();

        Button button = new Button("Click to get password");

        button.setOnAction(action -> {
            System.out.println(passwordField.getText());
        });
        VBox vbox = new VBox(btn, datePicker, passwordField, button);
        Scene scene = new Scene(vbox, 300, 300);
        primaryStage.setScene(scene);
        primaryStage.show();
    }


    public void start3(Stage primaryStage) throws Exception {
        primaryStage.setTitle("listView");
        Button btn = new Button("getSelected");

        ListView listView = new ListView();
        listView.getItems().add("apple");
        listView.getItems().add("pear");
        listView.getItems().add("banana");

        listView.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);

        btn.setOnAction(event -> {
            MultipleSelectionModel selectionModel = listView.getSelectionModel();
            for (Object o : selectionModel.getSelectedIndices()) {
                System.out.println("o = " + o + "" + o.getClass());
            }

        });

        VBox vbox = new VBox(btn, listView);
        Scene scene = new Scene(vbox, 200, 200);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public void start1(Stage primaryStage) throws Exception {
        primaryStage.setTitle("comboBox");
        ComboBox comboBox = new ComboBox();
        comboBox.setEditable(true);

        comboBox.getItems().add("bj");
        comboBox.getItems().add("sh");
        comboBox.getItems().add("gz");

        comboBox.setOnAction(event -> {
            String value = (String) comboBox.getValue();
            System.out.println(value);
        });
        VBox vBox = new VBox(comboBox);
        Scene scene = new Scene(vBox, 200, 200);
        primaryStage.setScene(scene);
        primaryStage.show();

    }
}
