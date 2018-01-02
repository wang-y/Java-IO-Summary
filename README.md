# Java IO 概要

## 结构

![](./assets/20170105182342227.jpeg)

## 流的概念和作用

流是一组有顺序的，有起点和终点的字节集合，是对数据传输的总称或抽象。即数据在两设备间的传输称为流，流的本质是数据传输，根据数据传输特性将流抽象为各种类，方便更直观的进行数据操作。

## IO流的分类

* 根据处理数据类型的不同分为：
  * 字符流
  * 字节流
* 根据数据流向不同分为
  * 输入流
  * 输出流
  
### 字符流和字节流

字符流的由来： 因为数据编码的不同，而有了对字符进行高效操作的流对象。本质其实就是基于字节流读取时，去查了指定的码表。 字节流和字符流的区别：

* 读写单位不同：字节流以字节（8bit）为单位，字符流以字符为单位，根据码表映射字符，一次可能读多个字节。
* 处理对象不同：字节流能处理所有类型的数据（如图片、avi等），而字符流只能处理字符类型的数据。
* 字节流：一次读入或读出是8位二进制。
* 字符流：一次读入或读出是16位二进制。

设备上的数据无论是图片或者视频，文字，它们都以二进制存储的。二进制的最终都是以一个8位为数据单元进行体现，所以计算机中的最小数据单元就是字节。意味着，字节流可以处理设备上的所有数据，所以字节流一样可以处理字符数据。

**结论：只要是处理纯文本数据，就优先考虑使用字符流。 除此之外都使用字节流。**

### 输入流和输出流

输入流只能进行读操作，输出流只能进行写操作，程序中需要根据待传输数据的不同特性而使用不同

#### 输入字节流 InputStream

* InputStream 是所有的输入字节流的父类，它是一个抽象类。
* ByteArrayInputStream、StringBufferInputStream、FileInputStream 是三种基本的介质流，它们分别从Byte 数组、StringBuffer、和本地文件中读取数据。
* PipedInputStream 是从与其它线程共用的管道中读取数据，与Piped 相关的知识后续单独介绍。
* ObjectInputStream 和所有FilterInputStream 的子类都是装饰流（装饰器模式的主角）。

#### 输出字节流 OutputStream

* OutputStream 是所有的输出字节流的父类，它是一个抽象类。
* ByteArrayOutputStream、FileOutputStream 是两种基本的介质流，它们分别向Byte 数组、和本地文件中写入数据。
* PipedOutputStream 是向与其它线程共用的管道中写入数据。
* ObjectOutputStream 和所有FilterOutputStream 的子类都是装饰流。

总结：
  * 输入流：InputStream或者Reader：从文件中读到程序中；
  * 输出流：OutputStream或者Writer：从程序中输出到文件中；

## 节点流

节点流：直接与数据源相连，读入或读出。 
直接使用节点流，读写不方便，为了更快的读写文件，才有了处理流。 

![](./assets/20170105194412271.png)

### 常用的节点流

* 父类：InputStream 、OutputStream、 Reader、 Writer
* 文件：FileInputStream 、 FileOutputStrean 、FileReader 、FileWriter 文件进行处理的节点流
* 数组：ByteArrayInputStream、 ByteArrayOutputStream、 CharArrayReader 、CharArrayWriter 对数组进行处理的节点流（对应的不再是文件，而是内存中的一个数组）
* 字符串：StringReader、 StringWriter 对字符串进行处理的节点流
* 管道：PipedInputStream 、PipedOutputStream 、PipedReader 、PipedWriter 对管道进行处理的节点流

## 处理流

处理流和节点流一块使用，在节点流的基础上，再套接一层，套接在节点流上的就是处理流。如BufferedReader.处理流的构造方法总是要带一个其他的流对象做参数。一个流对象经过其他流的多次包装，称为流的链接。 

![](./assets/20170105194522390.png)

### 常用的处理流

* 缓冲流：BufferedInputStrean 、BufferedOutputStream、 BufferedReader、 BufferedWriter 增加缓冲功能，避免频繁读写硬盘。
* 转换流：InputStreamReader 、OutputStreamReader实现字节流和字符流之间的转换。
* 数据流： DataInputStream 、DataOutputStream 等-提供将基础数据类型写入到文件中，或者读取出来。

## 转换流

InputStreamReader 、OutputStreamWriter 要InputStream或OutputStream作为参数，实现从字节流到字符流的转换。

构造函数
```java
new InputStreamReader(InputStream);        //通过构造函数初始化，使用的是本系统默认的编码表GBK。
new InputStreamWriter(InputStream,String charSet);   //通过该构造函数初始化，可以指定编码表。
new OutputStreamWriter(OutputStream);      //通过该构造函数初始化，使用的是本系统默认的编码表GBK。
new OutputStreamwriter(OutputStream,String charSet);   //通过该构造函数初始化，可以指定编码表。

```