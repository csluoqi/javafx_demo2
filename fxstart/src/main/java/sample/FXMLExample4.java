package sample;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import  javafx.scene.*;

import java.io.FileInputStream;
import java.net.URL;

/**
 * @author lq
 * 创建时间 2019/4/12 0:46
 **/
public class FXMLExample4 extends Application {

    enum  City {
        BEIJING(1,"北京"),SHANGHAI(2,"上海"),GUANGZHOU(3,"广州");

        int id;
        String name;

        City() {

        }
        City(int id,String name){
            this.id = id;
            this.name = name;
        }

        @Override
        public String toString() {
            return this.name;
        }
    }
    ObservableList cursors = FXCollections.observableArrayList(
            City.BEIJING,
            City.SHANGHAI,
            City.GUANGZHOU
    );
    public static void main(String[] args) {
        launch(args);
    }






    /**
     * 类似html下拉框,使用枚举类型
     * @param primaryStage
     * @throws Exception
     */
    @Override
    public void start(Stage primaryStage) throws Exception {

            ChoiceBox choiceBoxRef = ChoiceBoxBuilder.create()
                    .items(cursors)
                    .build();

            VBox box = new VBox();
            box.getChildren().add(choiceBoxRef);
            final Scene scene = new Scene(box,300, 250);
            scene.setFill(null);
            primaryStage.setScene(scene);
            primaryStage.show();

            choiceBoxRef.setOnAction(event -> {
                City value = (City) choiceBoxRef.getValue();
                System.out.println(value.id);
            });

        }


    /**
     * choiceBox
     * @param primaryStage
     * @throws Exception
     */

    public void start5(Stage primaryStage) throws Exception {
        primaryStage.setTitle("choiceBox");

        ChoiceBox choiceBox = new ChoiceBox();
        choiceBox.getItems().add("北京");
        choiceBox.getItems().add("上海");
        choiceBox.getItems().add("广州");

        choiceBox.setOnAction(event -> {
            Object value = choiceBox.getValue();
            System.out.println(value);
        });

        VBox vbox = new VBox(choiceBox);
        Scene scene = new Scene(vbox,200,200);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    /**
     * checkbox
     * @param primaryStage
     * @throws Exception
     */

    public void start3(Stage primaryStage) throws Exception {

//        Allowing Indeterminate State 半勾选状态。出现在gride的标题行的中
        primaryStage.setTitle("checkbox");
        CheckBox checkBox1 = new CheckBox("Green");
        CheckBox checkBox2 = new CheckBox("Blue");
        checkBox2.setOnAction(event->{
            boolean isSelected = checkBox2.isSelected();
            System.out.println(isSelected);
        });
        CheckBox checkBox3 = new CheckBox("Red");

        checkBox1.setAllowIndeterminate(true);
        checkBox1.setIndeterminate(true);
        HBox hbox = new HBox(checkBox1,checkBox2,checkBox3);

        Scene scene = new Scene(hbox,200,200);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * radiobutton
     * @param primaryStage
     * @throws Exception
     */

    public void start2(Stage primaryStage) throws Exception {
        primaryStage.setTitle("radiobutton demo");

        ToggleGroup toggleGroup = new ToggleGroup();
        RadioButton radioButton1 = new RadioButton("left");
        radioButton1.setOnAction(event -> {
            boolean isSelected = radioButton1.isSelected();
            System.out.println(isSelected);
            RadioButton radioButton  = (RadioButton) toggleGroup.getSelectedToggle();
            if(radioButton!=null){
                System.out.println(radioButton.getText());
            }
        });
        RadioButton radioButton2 = new RadioButton("left2");
        RadioButton radioButton3 = new RadioButton("left3");
        RadioButton radioButton4 = new RadioButton("left4");


        radioButton1.setToggleGroup(toggleGroup);
        radioButton2.setToggleGroup(toggleGroup);
        radioButton3.setToggleGroup(toggleGroup);
        radioButton4.setToggleGroup(toggleGroup);


        HBox hbox = new HBox(radioButton1,radioButton2,radioButton3,radioButton4);
        Scene scene = new Scene(hbox,200,200);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * button
     * @param primaryStage
     * @throws Exception
     */
    public void start1(Stage primaryStage) throws Exception {

//        MenuItem menu1 = new MenuItem("menu1");
//        menu1.setOnAction(event->{
//            System.out.println("menu1 click");
//        });
//        MenuItem menu2 = new MenuItem("menu2");
//        MenuItem menu3 = new MenuItem("menu3");
//        MenuItem menu4 = new MenuItem("menu4");
//
//        FileInputStream fileInputStream = new FileInputStream("C:\\Users\\lq\\Pictures\\test\\tomcat.png");
//        Image image = new Image(fileInputStream);
//        ImageView imageView = new ImageView(image);
//
//        MenuButton menuButton = new MenuButton("option",imageView,menu1,menu2,menu3,menu4);
//        VBox vbox = new VBox(menuButton);
//        Scene scene = new Scene(vbox,700,500);


//        HBox hbox = new HBox(menuButton);
//        Scene scene = new Scene(hbox,700,500);
        ToggleButton toggleButton = new ToggleButton("left");
        ToggleGroup toggleGroup = new ToggleGroup();
        toggleButton.setOnAction(event->{
            boolean isSelected = toggleButton.isSelected();
            System.out.println(isSelected);
            ToggleButton selectedToggleButton =
                    (ToggleButton) toggleGroup.getSelectedToggle();
            if(selectedToggleButton!=null){
                System.out.println(selectedToggleButton.getText());
            }
//        If no ToggleButton is selected the getSelectedToggle() method returns null .
        });

        ToggleButton toggleButton2 = new ToggleButton("left2");
        ToggleButton toggleButton3 = new ToggleButton("left3");
        ToggleButton toggleButton4= new ToggleButton("left4");


        toggleButton.setToggleGroup(toggleGroup);
        toggleButton2.setToggleGroup(toggleGroup);
        toggleButton3.setToggleGroup(toggleGroup);
        toggleButton4.setToggleGroup(toggleGroup);



        VBox vBox = new VBox(toggleButton,toggleButton2,toggleButton3,toggleButton4);

        Scene scene = new Scene(vBox,200,200);
        primaryStage.setScene(scene);
        primaryStage.show();

    }
}
