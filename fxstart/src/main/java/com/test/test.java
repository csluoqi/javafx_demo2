package com.test;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import jdk.nashorn.internal.runtime.linker.LinkerCallSite;
import org.apache.commons.lang3.StringUtils;

import java.util.*;

/**
 * @author lq
 * 创建时间 2019/4/25 17:08
 **/
public class test {
    public static void main1(String[] args) {
        String result1 = "{\"msg\":\"成功\",\"code\":\"1\",\"sign\":\"YH2cmEZHik5PBHNRTxzdlIyiUFDWGGK9bh5MQVmQNXIzcAMu1GN\\/Xw1jJxZY9ED1KWonwVccmBZULVcsY40ZrfvnJCivsZ6IPEzDrrH8vFcVzImcXjYWpmafhemF0Rr7UgMP6yPv6b5YbllSRENkIeZLHT665b7wD5DBaBFKz728iI4y0mWIVRzeI6oFZWBsMb9y9AAcT54Lm37dWkTxUBJ298mVkHs37gRvNDmziEJe+zaxobNWq9BumNOyAFc3McZEFTpdT7jNePh3KwGcneNq7Y8NSt2DKztLCzDLW8CeF3hvIZencRJeYoDIHGUlH4+YvnbdFFHkOJ+evNmujA==\",\"biz_data\":\"\\\"<HEADER>\\\\nV1.0|11111100120190425094546001|100000008757480778|111111001|111111000|111111001|11111100120190425094546001|062|20190425094145|0|0|0|查询完成\\\\n<CARD>\\\\n|1\\\\n<END>\\\"\"}";
        String result = "{\"msg\":\"成功\",\"code\":\"1\",\"sign\":\"U71mNaLTsz0+VZuRpZWiVCcey6g6r1MRe9M2oA+FN+z8wZzTfHUdD9xyknnjiydU7OBxBlX0XWDI9Ak6X8YJffk\\/hQ2303ckkSck3suEVYcsqBjblQYRjV+jZ97gD6XwALUW13r6+\\/lt6kPpNPBy7w81U2kXVIk10ClB69eO2KaPTeoLbNx2LI0jPTFgSGyeaEaRIKySq7GVGuCve5+XXaRTAYFaQ69VrdHoE9bpccv\\/g2\\/ADTV\\/0\\/m\\/NguH5gOkDPdHow9hc3hqaHR\\/jgjSnxoB8x9x7rebzIYU5UCJk+IUiG6XWW4ONwTya2Mqhm+IbsAx5wFOuAKshzhnJ2GeTw==\",\"biz_data\":\"\\\"<HEADER>\\\\nV1.0|11111100120190425095132001|100000008757520264|111111001|111111000|111111001|11111100120190425095132001|062|20190425094731|0|2|0|查询无记录！\\\\n<END>\\\"\"}";
        List<Map<String, Object>> pageData = new ArrayList<>();

        JSONObject resutlJsonObj = (JSONObject) JSONObject.parse(result);
        String biz_data = resutlJsonObj.getString("biz_data");

        //
        if ("".equals(biz_data)) {
            //错误信息：
            String msg = resutlJsonObj.getString("msg");
            //setData（msg）
            System.out.println("没有数据");
            return;
        }
        if(!biz_data.contains("<CARD>")){
            String returnMsg = (biz_data.split("\\|"))[12];
            System.out.println((returnMsg.split("\\\\n<END>"))[0]);
            System.out.println("没有数据");
            return;
        }


        String msg1 = biz_data.split("<CARD>")[0];
        String msg2 = biz_data.split("<CARD>")[1];

        String returnMsg = msg1.split("\\|")[12];
        String returnData = msg2.substring(0, msg2.lastIndexOf("<END>"));
        String[] split1 = returnData.split("\\n");
        Map<String, Object> rowdata = null;
        String cardstatus = "";
        for (String row : split1) {
            rowdata = new HashMap<>();
            /* rowdata.put("cardId", row.split("\\|")[0].trim());*/
            cardstatus = row.split("\\|")[1].replace("\\n", "");
            rowdata.put("cardstatus", cardstatus);
            pageData.add(rowdata);
        }
        System.out.println(pageData);
        //setList("socialCardStatusQueryGrid", pageData);
    }
    //return JSON;


    public static void main2(String[] args) {
        String result="{\"msg\":\"成功\",\"code\":\"1\",\"sign\":\"i2Fo35QpbAgR0VWbeVXLHxv8yFnYMW8wbzkOHOMBkbbFYWnaD4Cd85axBPxqq3FLvOq34D+qjxv7hMCBSbFCo1917M+Feze2S4vyzvEK\\/RMeoHTNSDnksu8tpfBRmAS2kdqVCTeBMSYGIbHIMCjs9VAj39u91vYLB9k\\/vhJtZxIwFTJ6CDdElr\\/FWRN\\/b5+66PpDh2LTjh67HdqbULgNCiAV2+dxz2ViFkGdT78YmEFWx7B\\/fJDX8XW7TYyKPJJ8NjYS5yurLMBjCehf+UCTTq0xGVGvODPYY11xl2SkQNLdnxQCT8arSp1F2aUBrLFq4OPUgy8gWxzg3bOv7SEGhQ==\",\"biz_data\":\"\\\"<HEADER>\\\\nV1.0|11111100120190425095254001|100000008757522596|111111001|111111000|111111001|11111100120190425095254001|062|20190425094853|0|0|0|查询完成\\\\n<CARD>\\\\nMA2***227|1\\\\n<END>\\\"\"}";
        List<Map<String, Object>> pageData = new ArrayList<>();
        JSONObject resutlJsonObj = (JSONObject) JSONObject.parse(result);
        String biz_data = resutlJsonObj.getString("biz_data");

        //平台报错
        if (StringUtils.isBlank(biz_data)) {
            String msg = resutlJsonObj.getString("msg");
            //setTopMsg(msg);
            //return JSON;
            return;
        }
        //接口提供方报错
        if(!biz_data.contains("<CARD>")){
            String returnMsg = (biz_data.split("\\|"))[12];
            String returnMsg2 = (returnMsg.split("\\\\n<END>"))[0];
            System.out.println(returnMsg2);
            //setTopMsg(returnMsg2);//
            //return JSON;
            return;
        }

        //接口提供方正常
        String msg1 = biz_data.split("<CARD>")[0];
        String msg2 = biz_data.split("<CARD>")[1];

        String returnMsg = msg1.split("\\|")[12];
        String returnData = msg2.substring(0, msg2.lastIndexOf("<END>"));
        String[] split1 = returnData.split("\\n");
        Map<String, Object> rowdata = null;
        String cardstatus = "";
        for (String row : split1) {
            rowdata = new HashMap<>();
            //去掉\n
            rowdata.put("cardId", row.split("\\|")[0].trim().substring(2));
            cardstatus = row.split("\\|")[1].replace("\\n", "");
            rowdata.put("cardstatus", cardstatus);
            //rowdata.put("cardstatus", cardStatusMap.get(cardstatus));
            pageData.add(rowdata);
        }
        System.out.println(pageData);
//        setTopMsg(returnMsg);
//        setList("socialCardStatusQueryGrid",pageData);
//        return JSON;
        return;
    }

    public static void main(String[] args) {
        String result="{\"msg\":\"成功\",\"code\":\"1\",\"sign\":\"lIkZk8k6KRT3ylFjZqabP\\/1AJRnqJgt\\/2tyqOqL6pdl6tmW8eF3RSTzOOJAxUpuuY1Q+5houYmyLOh2FriHPYZ3ezMRQPSb+5VlATEB1D5xEwJKQ13BlLCoDSIGCxAaFJl9CA1dmP3D5Pq0Q7sj4htwUucSmzUl9SJcw6uD8b7Eay51j95sdykjEu4H2R0KktahJp5T27CyzhwfyGbkYPSTtt2KMg78V4yc7oLeLWOuPcSAoZlike07VGA83epOzHAwg\\/vtC3mvRVS1bRgNYPUY33M2K+Y8Xek+oN3mKACDEZWsjcbSPsVaWNnxhETtpWHwyfXGymICcKI4SOdIOOA==\",\"biz_data\":{\"FAHEAD\":{\"@Mess\":\"数据访问接口方案执行成功。\",\"@Flag\":\"0001\"},\"Data\":{\"Table\":{\"@TabName\":\"DW02\",\"rowData\":{\"@RowName\":\"0\",\"ColumnData\":[{\"@ColValue\":\"毛德亮\",\"@ColName\":\"AAC003\",\"@ColType\":\"VARCHAR2\"},{\"@ColValue\":\"110104196404280437\",\"@ColName\":\"AAC002\",\"@ColType\":\"VARCHAR2\"},{\"@ColValue\":\"1101010811001323\",\"@ColName\":\"ADC001\",\"@ColType\":\"VARCHAR2\"},{\"@ColValue\":\"建国门街道社会保障事务所\",\"@ColName\":\"AAF011\",\"@ColType\":\"VARCHAR2\"},{\"@ColValue\":\"20111123\",\"@ColName\":\"AAC187\",\"@ColType\":\"VARCHAR2\"}]}},\"@version\":\"1.0\"},\"SCRIPTHEAD\":{\"DW02\":{\"@Mess\":\"执行查询脚本JB_000001.查询就业创业证成功。\",\"@Flag\":\"0002\"}}}}";
        List<Map<String, Object>> pageData = new ArrayList<>();
        JSONObject resutlJsonObj = (JSONObject) JSONObject.parse(result);
        String biz_data = resutlJsonObj.getString("biz_data");

        //平台报错
        if (StringUtils.isBlank(biz_data)) {
            String msg = resutlJsonObj.getString("msg");
            //setTopMsg(msg);
            //setList("socialCardStatusQueryGrid",pageData);
            //return JSON;
            System.out.println(msg);
            return;
        }
        //接口提供方报错
        if(!biz_data.contains("\"ColumnData\":[")){
            String returnMsg = (biz_data.split("\\|"))[12];
            String returnMsg2 = "查询无结果";
//            setTopMsg(returnMsg2);//
//            setList("socialCardStatusQueryGrid",pageData);
//            return JSON;
            System.out.println("查询无结果");
            return;
        }

        //接口提供方正常
        JSONObject bizdataJson = (JSONObject) JSONObject.parse(biz_data);
        JSONArray jsonArray = null;
        try {
            jsonArray = bizdataJson.getJSONObject("Data").getJSONObject("Table").getJSONObject("rowData").getJSONArray("ColumnData");
        }catch (Exception e){
//            setTopMsg("解析失败");//
//            setList("socialCardStatusQueryGrid",pageData);
//            return JSON;
            System.out.println("解析返回值失败");
            return;
        }

        Map<String,Object> pageRowmap = new HashMap<>();
        Iterator<Object> iterator = jsonArray.iterator();
        JSONObject colJson = null;
        while(iterator.hasNext()){
            //列转行
            colJson = (JSONObject)iterator.next();
            System.out.println(colJson.get("@ColName"));
            System.out.println(colJson.get("@ColValue"));

            if("AAC003".equals(colJson.get("@ColName"))){
                pageRowmap.put("AAC003",colJson.get("@ColValue"));
                continue;
            }
            if("AAC002".equals(colJson.get("@ColName"))){
                pageRowmap.put("AAC002",colJson.get("@ColValue"));
                continue;
            }
            if("ADC001".equals(colJson.get("@ColName"))){
                pageRowmap.put("ADC001",colJson.get("@ColValue"));
                continue;
            }
            if("AAF011".equals(colJson.get("@ColName"))){
                pageRowmap.put("AAF011",colJson.get("@ColValue"));
                continue;
            }
            if("AAC187".equals(colJson.get("@ColName"))){
                pageRowmap.put("AAC187",colJson.get("@ColValue"));
                continue;
            }
        }
        pageData.add(pageRowmap);
        System.out.println(pageData);
        //setList("socialCardNOAndStatusQueryGrid",pageData);
        //return JSON;
    }
}
