# Day 6: ByteArrayInputStream、ByteArrayOutputStream

## 类的继承关系

```java
InputStream
|__ ByteArrayInputStream
```

```java
OutputStream
|__ ByteArrayOutputStream
```

ByteArrayInputStream 可以将字节数组转化为输入流 。 
ByteArrayOutputStream可以捕获内存缓冲区的数据，转换成字节数组。

## ByteArrayInputStream

* 构造函数

```java
public ByteArrayInputStream(byte buf[])

public ByteArrayInputStream(byte buf[], int offset, int length)
```

* 方法

```java
void  close() // 关闭该流并释放与之关联的所有资源。

String  getEncoding() //返回此流使用的字符编码的名称。

int  read()  //读取单个字符。

int  read(char[] cbuf, int offset, int length) //将字符读入数组中的某一部分。

boolean  ready() //判断此流是否已经准备好用于读取。
```

## ByteArrayOutputStream

* 构造函数

```java
public ByteArrayOutputStream()

public ByteArrayOutputStream(int size)
```

* 方法

```java
void write(int b)

void write(byte b[], int off, int len)

void writeTo(OutputStream out)

byte toByteArray()[]

void close()
```
