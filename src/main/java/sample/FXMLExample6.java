package sample;

import javafx.application.Application;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.chart.*;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TreeItemPropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.TilePane;
import javafx.scene.layout.VBox;
import javafx.scene.text.TextAlignment;
import javafx.scene.web.WebView;
import javafx.stage.DirectoryChooser;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * @author lq
 * 创建时间 2019/4/12 0:46
 **/
public class FXMLExample6 extends Application {

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

    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("listView");

        CategoryAxis xAixis = new CategoryAxis();
        xAixis.setLabel("Devices");
        xAixis.getCategories().addAll("Desktop","Phone","Tablet");

        NumberAxis yAxis = new NumberAxis();
        yAxis.setLabel("Visits");

        StackedBarChart stackedBarChart = new StackedBarChart(xAixis,yAxis);

        XYChart.Series dataSeries1 = new XYChart.Series();
        dataSeries1.setName("Desktop");
        dataSeries1.getData().add(new XYChart.Data<>("2014",123));
        dataSeries1.getData().add(new XYChart.Data<>("2015",223));

        XYChart.Series dataSeries2 = new XYChart.Series();
        dataSeries2.setName("Phone");
        dataSeries2.getData().add(new XYChart.Data<>("2014",323));
        dataSeries2.getData().add(new XYChart.Data<>("2015",323));


        XYChart.Series dataSeries3 = new XYChart.Series();
        dataSeries3.setName("Tablet");
        dataSeries3.getData().add(new XYChart.Data<>("2014",423));
        dataSeries3.getData().add(new XYChart.Data<>("2015",243));

        stackedBarChart.getData().addAll(dataSeries1,dataSeries2,dataSeries3);

        VBox vbox = new VBox(stackedBarChart);
        Scene scene = new Scene(vbox, 500, 500);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public void start7(Stage primaryStage) throws Exception {
        primaryStage.setTitle("listView");
        CategoryAxis xAxis = new CategoryAxis();
        xAxis.setLabel("Devices");

        NumberAxis yAxis = new NumberAxis();
        yAxis.setLabel("Visits");

        BarChart barChart = new BarChart(xAxis,yAxis);
        XYChart.Series dataSeries = new XYChart.Series();
        dataSeries.setName("2014");

        dataSeries.getData().add(new XYChart.Data<>("DeskTop",367));
        dataSeries.getData().add(new XYChart.Data<>("Phone",167));
        dataSeries.getData().add(new XYChart.Data<>("Tablet",767));
        barChart.getData().add(dataSeries);

        XYChart.Series dataSeries2 = new XYChart.Series();
        dataSeries2.setName("2015");

        dataSeries2.getData().add(new XYChart.Data<>("DeskTop",567));
        dataSeries2.getData().add(new XYChart.Data<>("Phone",267));
        dataSeries2.getData().add(new XYChart.Data<>("Tablet",867));

        barChart.getData().add(dataSeries2);



        VBox vbox = new VBox(barChart);
        Scene scene = new Scene(vbox, 500, 500);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public void start6(Stage primaryStage) throws Exception {
        primaryStage.setTitle("listView");
        TreeTableView<Car> treeTableView =new TreeTableView<>();

        TreeTableColumn<Car,String> treeTableColumn1 = new TreeTableColumn<>("Brand");
        TreeTableColumn<Car,String> treeTableColumn2 = new TreeTableColumn<>("Model");

        treeTableColumn1.setCellValueFactory(new TreeItemPropertyValueFactory<>("brand"));
        treeTableColumn2.setCellValueFactory(new TreeItemPropertyValueFactory<>("model"));

        treeTableView.getColumns().addAll(treeTableColumn1,treeTableColumn2);

        TreeItem mercedes1 = new TreeItem(new Car("Meredes","sl500"));
        TreeItem mercedes2 = new TreeItem(new Car("Meredes","sl500 AMG"));
        TreeItem mercedes3 = new TreeItem(new Car("Meredes","CLA 200"));
        TreeItem meredes = new TreeItem(new Car("Meredes","..."));
        meredes.getChildren().addAll(mercedes1,mercedes2,mercedes3);



        TreeItem audi1 = new TreeItem(new Car("Audi","A1"));
        TreeItem audi2 = new TreeItem(new Car("Audi","A5"));
        TreeItem audi3 = new TreeItem(new Car("Audi","A7"));
        TreeItem audi = new TreeItem(new Car("Audi","..."));
        audi.getChildren().addAll(audi1,audi2,audi3);

        TreeItem cars = new TreeItem(new Car( "Cars","...."));
        cars.getChildren().addAll(audi,meredes);
        treeTableView.setRoot(cars);

        VBox vbox = new VBox(treeTableView);
        Scene scene = new Scene(vbox, 500, 500);
        primaryStage.setScene(scene);
        primaryStage.show();
    }



    public void start5(Stage primaryStage) throws Exception {
        primaryStage.setTitle("listView");
        TreeView treeView = new TreeView();

        TreeItem rootItem = new TreeItem("Tutorials");

        TreeItem webItem = new TreeItem("Web Tutorials");

        TreeItem javaItem = new TreeItem("Java Tutorials");

        TreeItem pythonItem = new TreeItem("Python Tutorials");

        webItem.getChildren().addAll(new TreeItem<>("HTML Tutorials"),
                new TreeItem<>("CSS Tutorials"));

        javaItem.getChildren().addAll(new TreeItem<>("class Tutorials"),new TreeItem<>("object Tutorials"));

        pythonItem.getChildren().add(new TreeItem<>("script Tutorials"));

        rootItem.getChildren().addAll(webItem,javaItem,pythonItem);

        treeView.setRoot(rootItem);
        treeView.setShowRoot(false);

        VBox vbox = new VBox(treeView);
        Scene scene = new Scene(vbox, 200, 200);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public void start4(Stage primaryStage) throws Exception {
        primaryStage.setTitle("listView");
        TableView tableView = new TableView();
        TableColumn<String,Person> column1 = new TableColumn<>("First Name");
        column1.setCellValueFactory(new PropertyValueFactory<>("firstName"));

        TableColumn<String,Person> column2 = new TableColumn<>("Last Name");
        column2.setCellValueFactory(new PropertyValueFactory<>("LastName"));

        tableView.getColumns().addAll(column1,column2);

        tableView.getItems().add(new Person("john","Doe"));
        tableView.getItems().add(new Person("jone","Dear"));

        VBox vbox = new VBox(tableView);

        Scene scene = new Scene(vbox, 200, 200);
        primaryStage.setScene(scene);
        primaryStage.show();
    }


    public void start2(Stage primaryStage) throws Exception {
        primaryStage.setTitle("listView");
        PieChart pieChart = new PieChart();
        PieChart.Data slice1  = new PieChart.Data("Desktop",213);
        PieChart.Data slice2  = new PieChart.Data("Phone",90);
        PieChart.Data slice3  = new PieChart.Data("Tablet",39);

        pieChart.getData().addAll(slice1,slice2,slice3);
        VBox vbox = new VBox(pieChart);
        Scene scene = new Scene(vbox, 400, 400);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public void start1(Stage primaryStage) throws Exception {
        primaryStage.setTitle("listView");

        WebView webView = new WebView();
        webView.getEngine().load("http://quote.eastmoney.com/center/");

        VBox vbox = new VBox(webView);
        Scene scene = new Scene(vbox, 960, 960);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public class Person{
        private String firstName = null;
        private String lastName = null;

        public Person() {
        }

        public Person(String firstName, String lastName) {
            this.firstName = firstName;
            this.lastName = lastName;
        }

        public String getFirstName() {
            return firstName;
        }

        public void setFirstName(String firstName) {
            this.firstName = firstName;
        }

        public String getLastName() {
            return lastName;
        }

        public void setLastName(String lastName) {
            this.lastName = lastName;
        }
    }
    public class Car {

        private String brand = null;
        private String model = null;

        public Car() {
        }

        public Car(String brand, String model) {
            this.brand = brand;
            this.model = model;
        }

        public String getBrand() {
            return brand;
        }

        public void setBrand(String brand) {
            this.brand = brand;
        }

        public String getModel() {
            return model;
        }

        public void setModel(String model) {
            this.model = model;
        }
    }
}
