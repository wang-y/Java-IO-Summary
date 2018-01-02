package com.wymix.io;

import java.io.*;

public class ByteArrayOutputStreamDemo {

    public static void main(String[] args) {

        String mes = "你好,world" ;
        byte[] b = mes.getBytes() ;

        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream() ;
        try {
            byteArrayOutputStream.write( b );

            FileOutputStream fileOutputStream = new FileOutputStream( new File( "F:/123.txt" ) ) ;

            byteArrayOutputStream.writeTo( fileOutputStream ) ;

            fileOutputStream.flush();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }catch (IOException e) {
            e.printStackTrace();
        }finally{
            try {
                byteArrayOutputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}
