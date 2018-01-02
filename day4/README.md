# Day 4: 缓冲流-BufferedReader、BufferedWriter

* 类的继承关系
```java
Reader
|__ BufferedReader、StringReader、InputStreamReader
                                      |__ FileReader
```

```java
Writer
|__ BufferedWriter、StringWriter、OutputStreamWriter
                                      |__ FileWriter
```

## BufferedReader

### 构造函数

```java
BufferedReader(Reader in, int sz) //创建一个使用指定大小输入缓冲区的缓冲字符输入流。 

BufferedReader(Reader in) //创建一个使用默认大小输入缓冲区的缓冲字符输入流。
```

### 方法

```java
int  read()  //读取单个字符。
int  read(char[] cbuf, int off, int len)  //将字符读入数组的某一部分。
String  readLine()  //读取一个文本行。
boolean  ready()  //判断此流是否已准备好被读取。
void  reset()  //将流重置到最新的标记。
long  skip(long n)  //跳过字符。
void  close() //关闭该流并释放与之关联的所有资源。
void  mark(int readAheadLimit) //标记流中的当前位置。
boolean  markSupported() //判断此流是否支持 mark() 操作（它一定支持）。
```

## BufferedWriter

### 构造函数

```java
BufferedWriter(Writer out, int sz) //创建一个使用给定大小输出缓冲区的新缓冲字符输出流。

BufferedWriter(Writer out) //建一个使用默认大小输出缓冲区的缓冲字符输出流。
```

### 方法

```java
void  close()  // 关闭此流，但要先刷新它。
void  flush()  //刷新该流的缓冲。
void  newLine() //写入一个行分隔符。
void  write(char[] cbuf, int off, int len) //写入字符数组的某一部分。
void  write(int c) //写入单个字符。
void  write(String s, int off, int len) //写入字符串的某一部分。
```

## BufferedReaderAndBufferedWriterDemo
操作实例