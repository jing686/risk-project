package com.zj.time;

import java.io.*;

public class Test2 {
    public static void main(String[] args) {
        FileInputStream fileInputStream = null;
        FileOutputStream fileOutputStream = null;
        BufferedInputStream bufferedInputStream = null;
        BufferedOutputStream bufferedOutputStream = null;
        try {
            File file = new File("C:\\Users\\13661\\Desktop\\test.sql");
            fileInputStream = new FileInputStream(file);
            fileOutputStream = new FileOutputStream(new File("C:\\Users\\13661\\Desktop\\test1.sql"));
            bufferedInputStream = new BufferedInputStream(fileInputStream);
            bufferedOutputStream = new BufferedOutputStream(fileOutputStream);

            byte[] b = new byte[1024];
            int i = 0;
            while ((i = bufferedInputStream.read(b)) != (-1)) {
                System.out.println("" + i);
                String s = new String(b, 0, i, "UTF-8");
                System.out.println(s);
                bufferedOutputStream.write(b, 0, i);
                //最后刷新一下
                bufferedOutputStream.flush();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                fileInputStream.close();
                fileOutputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}