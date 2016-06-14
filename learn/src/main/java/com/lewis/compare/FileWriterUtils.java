package com.lewis.compare;

import com.alibaba.fastjson.JSON;

import java.io.*;

/**
 * Created by zhangminghua on 2016/6/14.
 */
public class FileWriterUtils {

    public static void write(Object obj){
        try {


            File file = new File("D:\\java\\sourceCode\\multiThreadDesign\\learn\\src\\main\\java\\result.txt");
            FileWriter fileWriter = new FileWriter(file,true);
            String str = JSON.toJSONString(obj)+"\n";
            PrintWriter printWriter = new PrintWriter(fileWriter);
            printWriter.write(str);
            printWriter.flush();
            printWriter.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
