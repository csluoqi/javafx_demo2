package sample3;

import java.io.File;

/**
 * @author lq
 * 创建时间 2019/4/17 11:53
 **/
public class test2 {
    public static void main(String[] args) {
        File file = new File("d:\\test\\test");
        System.out.println(file.isFile());
    }
}
