package sample;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileInputStream;
import java.io.FilenameFilter;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author lq
 * 创建时间 2019/4/12 0:46
 **/
public class MyImage extends Application {
    ImageView imageView  = new ImageView();
    public static void main(String[] args) {
        launch(args);
    }
    @Override
    public void start(Stage primaryStage) throws Exception {
        TextField  inputText = new TextField("C:/Users/lq/Pictures/ps");
        //button
        Button nextBtn = new Button("NEXT");
        Label pathLab = new Label("file Paht ");

        imageView.setFitHeight(300);
        imageView.setFitWidth(300);
        final List<String> images = new ArrayList<>();

        //计数器
        int[] clickCount = {0};

        nextBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                String parentPath = inputText.getText();

                if(images.size()==0){
                    System.out.println(parentPath);
                    try {
                        //初始化图片列表
                        String[] imageNames = getImageNames(parentPath);
                        for(String imageName : imageNames){
                            images.add(imageName);
                        }
                    } catch (URISyntaxException e) {
                        e.printStackTrace();
                    }
                }
                String imagePath = parentPath+"/"+images.get(clickCount[0]%images.size());
                try {
                    initImageView(imagePath);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                clickCount[0] = clickCount[0]+1;
                pathLab.setText(imagePath);
            }
        });

        VBox vbox = new VBox(inputText,nextBtn,pathLab,imageView);
        vbox.setMaxSize(500,500);
        vbox.setMinSize(400,400);
        Scene scene = new Scene(vbox);
        primaryStage.setTitle("简易图片查看器");
        primaryStage.setScene(scene);
        primaryStage.show();
    }


    public ImageView initImageView(String imagePath) throws IOException {
        FileInputStream fileInputStream = new FileInputStream(imagePath);
        Image image = new Image(fileInputStream);

        imageView.setImage(image);
        fileInputStream.close();
        return imageView;
    }
    /**
     * 获取父路径
     * @param parentPath
     * @return
     */
    public String[] getImageNames(String parentPath) throws URISyntaxException {
        File parentDir = new File(parentPath);
        String[] pngs = parentDir.list(new FilenameFilter() {
            @Override
            public boolean accept(File dir, String name) {
                if (name.endsWith("jpg")) {
                    System.out.println(name);
                    return true;
                }
                return false;
            }
        });
        System.out.println(pngs.length);
        return pngs;
    }


}
