package com.zj.time;

import org.apache.commons.lang3.StringUtils;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author: zj
 * @Date: 2023/6/1 23:25
 * @Version: 1.0
 */
public class Test3 {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        File readFile = new File("C:\\Users\\13661\\Desktop\\test.sql");
        BufferedReader reader = null;
        OutputStream writer = null;
        StringBuilder sb = new StringBuilder();
        try {
            reader = new BufferedReader(new FileReader(readFile));

            String tempString = null;
            int line = 0;
            while ((tempString = reader.readLine()) != null) {//BufferedReader有readLine()，可以实现按行读取
                if (StringUtils.isNotBlank(tempString)) {
                    sb.append(tempString);
                    continue;
                }
                if (sb.length() > 0) {
                    list.add(sb.substring(0, sb.length() - 1));
                    sb.delete(0, sb.length());
                }
                System.out.println(tempString);
                line++;
            }
            System.out.println("line = " + line);
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                }
            }
        }
    }
}
