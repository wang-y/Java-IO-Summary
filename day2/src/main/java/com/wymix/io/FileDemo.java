package com.wymix.io;

import java.io.File;
import java.io.FileFilter;
import java.io.FilenameFilter;

public class FileDemo {

    public static void main(String[] args) {
//        list();
//        getFile();
//        getFileByFileFilter();
//        getFileByFilenameFilter();
    }

    public static void  list(){
        String filePath = "E:/cat" ;
        File file = new File( filePath ) ;
        file.mkdir() ;

        String[] names = file.list() ;

        for( int i = 0 ; i < names.length ; i++ ){
            System.out.println( "names: " +names[i]);
        }

        File[] files = file.listFiles() ;
        for( int i = 0 ; i < files.length ; i++ ){
            System.out.println( "files: "+ files[i].getAbsolutePath() );
        }
    }

    /**
     * 扫描出指定路径的所有文件
     * @param file
     */
    private static void getFile( File file ){
        File[] files = file.listFiles() ;
        for( File f : files ){
            if ( f.isHidden() ) continue ;

            if(f.isDirectory() ){
                getFile( f );
            }else{
                System.out.println( f.getAbsolutePath()  + "  " + f.getName() );
            }
        }
    }

    /**
     * 获取指定目录的所有文件夹
     * @param file
     */
    private static void getFileByFileFilter( File file ){
        File[] files = file.listFiles( new MyFileFilter() ) ;
        for( File f : files ){
            if ( f.isHidden() ) continue ;

            System.out.println( f.getAbsolutePath() );
        }
    }

    /**
     * 扫描出指定路径的所有图片
     * @param file
     */
    private static void getFileByFilenameFilter( File file ){
        MyFilenameFilter myFileFilter = new MyFilenameFilter( ".png") ;

        File[] files = file.listFiles( myFileFilter ) ;
        for( File f : files ){
            if ( f.isHidden() ) continue ;

            System.out.println( f.getAbsolutePath() );
        }
    }

    static class MyFileFilter implements FileFilter {


        public boolean accept(File pathname) {
            if( pathname.isDirectory() ){
                return true ;
            }
            return false;
        }
    }

    static class MyFilenameFilter implements FilenameFilter {

        //type为需要过滤的条件，比如如果type=".jpg"，则只能返回后缀为jpg的文件

        private String type;

        MyFilenameFilter( String type){
            this.type = type ;
        }

        public boolean accept(File dir, String name) {
            //dir表示文件的当前目录，name表示文件名；
            return name.endsWith( type ) ;
        }
    }
}
