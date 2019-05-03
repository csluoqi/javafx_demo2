package sample5;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

import java.io.*;
import java.util.*;

/**
 * @author lq
 * 创建时间 2019/4/23 16:38
 **/
public class TestPropertiesController {
    @FXML
    public Button readFileBtn;

    public void readFile_click(ActionEvent actionEvent) throws IOException {
        Properties properties = new Properties();
//        FileInputStream fileInputStream = new FileInputStream(new File("log4j.properties"));
        properties.load(getClass().getResourceAsStream("/log4j.properties"));
        System.out.println(properties.size());
        System.out.println("test = "+properties.get("test"));
        
    }

    public static void main1(String[] args) {
        String result = "{\"status\":200,\"message\":\"\",\"result\":{\"message\":\"\\nV1.0|11111100120181203124022001|100000007675879521|111111001|111111000|111111001|11111100120181203124022001|062|20181203125243|0|0|0|查询完成\\n\\n|1\\n\"}}";
        List<Map<String, Object>> pageData = new ArrayList<>();

        String msg1 = result.split("<CARD>\\n")[0];
        String msg2 = result.split("<CARD>\\n")[1];
        System.out.println(msg1);
        System.out.println(msg2);
        System.out.println("-----------------");
        String returnMsg = msg1.split("\\|")[12];
        System.out.println("returnMsg  : " + returnMsg);
        String returnData = msg2.substring(0, msg2.lastIndexOf("<END>"));
        System.out.println("returnData : " + returnData);
        String[] split1 = returnData.split("\\n");
        Map<String, Object> rowdata = null;
        for (String row : split1) {
            rowdata = new HashMap<>();
            rowdata.put("cardId", row.split("\\|")[0]);
            rowdata.put("cardstatus", row.split("\\|")[1]);
            pageData.add(rowdata);
        }
        System.out.println(pageData);

    }

    public static void main(String[] args) {
        String result = "{\n" +
                "  \"msg\": \"成功\",\n" +
                "  \"code\": \"1\",\n" +
                "  \"sign\": \"WSVhU16bXKq3kJCOCPiwVtuWff1LtsaoFou1ClFxLeQIFOHNrZ2+OAmDGnXfVaI/kEGTx4z9LDjU4RsjYFeTFdiuHTtNUsu6IT1wsizZ2OH/HTlqVAYkXV5uJ49OiUE6KwRDB9tZ8zrfIylCHXC+Mkv0G6Q5xVmhihV4ojve5Gq6Qx2frnRelG2a0pHKlvdtcfyhspqSdKuUKTu5iV0pDs9ViuRRRQRNY9PoGfo0NTQ8FWz1378W2YUSn9LwWKPE7wFBhpVVMcHNiUjNi/2aSUk4ds3EGGW8ebwBuafSZIFUzu6dhHIdsCpBUANmqyA6m20OfJM1MZj5OLOA54NyRA==\",\n" +
                "  \"biz_data\": {\n" +
                "    \"returncount\": 2,\n" +
                "    \"recordcount\": 2,\n" +
                "    \"rows\": [\n" +
                "      {\n" +
                "        \"profession\": \"汽车修理工\",\n" +
                "        \"date\": \"2010-01-06\",\n" +
                "        \"number\": \"1001161016400014\",\n" +
                "        \"idcard\": \"412725199002166114\",\n" +
                "        \"name\": \"殷富山\",\n" +
                "        \"rank\": \"4\"\n" +
                "      },\n" +
                "      {\n" +
                "        \"profession\": \"汽车修理工\",\n" +
                "        \"date\": \"2010-01-06\",\n" +
                "        \"number\": \"1001161016400014\",\n" +
                "        \"idcard\": \"412725199002166114\",\n" +
                "        \"name\": \"殷富山\",\n" +
                "        \"rank\": \"4\"\n" +
                "      }\n" +
                "    ]\n" +
                "  }\n" +
                "}";

        JSONObject resultJson = (JSONObject) JSON.parse(result);
        List<Map> maps = resultJson.getJSONObject("biz_data").getJSONArray("rows").toJavaList(Map.class);
        //{"profession":"汽车修理工","date":"2010-01-06","number":"1001161016400014","idcard":"412725199002166114","name":"殷富山","rank":"4"}


    }
}
