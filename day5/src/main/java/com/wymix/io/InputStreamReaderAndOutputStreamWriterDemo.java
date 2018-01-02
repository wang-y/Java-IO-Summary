package com.wymix.io;

import java.io.*;

public class InputStreamReaderAndOutputStreamWriterDemo {

    public static void main(String[] args) {

    }

    /**
     * 复制文本
     * @param oldFile
     * @param newFile
     */
    private static void copyFile( File oldFile , File newFile ){
        InputStream inputStream = null ;
        InputStreamReader inputStreamReader = null ;

        OutputStream outputStream = null ;
        OutputStreamWriter outputStreamWriter = null ;

        try {
            inputStream = new FileInputStream( oldFile ) ; //创建输入流
            inputStreamReader = new InputStreamReader( inputStream ) ; //创建转换输入流

            outputStream = new FileOutputStream( newFile ) ; //创建输出流
            outputStreamWriter = new OutputStreamWriter( outputStream ) ; //创建转换输出流

            int result = 0 ;

            while( (result = inputStreamReader.read()) != -1){  //一次只读一个字符
                outputStreamWriter.write( result ); //一次只写一个字符
            }

            outputStreamWriter.flush();  //强制把缓冲写入文件

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }catch (IOException e) {
            e.printStackTrace();
        }finally{

            if ( outputStreamWriter != null) {
                try {
                    outputStreamWriter.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            if ( inputStreamReader != null ) {
                try {
                    inputStreamReader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }
}
