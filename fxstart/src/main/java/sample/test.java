package sample;

import java.io.File;
import java.io.FilenameFilter;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author lq
 * 创建时间 2019/4/14 1:21
 **/
public class test {
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

    public static void main(String[] args) throws URISyntaxException {
        String parentPath = "C:\\Users\\lq\\Pictures\\ps";
        new test().getImageNames(parentPath);
    }
}
