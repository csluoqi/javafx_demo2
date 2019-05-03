package sample.clobdemo;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import oracle.sql.CLOB;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.*;

public class Controller {
    @FXML
    public Button executebtn;
    @FXML
    public TextArea updatesql;
    @FXML
    public TextField clobfile;
    @FXML
    public PasswordField password;
    @FXML
    public TextArea result;
    @FXML
    public TextField username;
    @FXML
    public TextField jdbcurl;
    public Button chooseFile;
    @FXML
    public TextField filePath;


    public void execute_click(ActionEvent actionEvent) throws IOException, SQLException, ClassNotFoundException {
        if(Msg.file==null){
            this.result.setText("请先选择文件");
            return;
        }
        String clodPath =Msg.file.getAbsolutePath();
        byte[] bytes = Files.readAllBytes(Paths.get(clodPath));
        String content = new String(bytes);

        String sql = this.updatesql.getText();
        update(sql,content);
    }

    public void chooseFile_click(ActionEvent actionEvent) {
    }

    public void update(String sql,String content)  {
        int exeresult = 0;
        String URL=jdbcurl.getText();
        String USER=username.getText();
        String PASSWORD=password.getText();
        //1.加载驱动程序


        PreparedStatement pst =null;
        Connection conn= null;
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            //2.获得数据库链接
            conn = DriverManager.getConnection(URL, USER, PASSWORD);
            CLOB clob   = oracle.sql.CLOB.createTemporary(conn, false,oracle.sql.CLOB.DURATION_SESSION);
            clob.setString(1L, content);
            pst = conn.prepareStatement(sql);
            pst.setClob(1, clob);
            exeresult = pst.executeUpdate();
            result.setText("影响行数："+exeresult);
        } catch (SQLException e) {
            e.printStackTrace();
            result.setText(e.getMessage());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            result.setText(e.getMessage());
        } finally{
            try {
                pst.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }


}

