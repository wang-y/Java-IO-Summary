# Day 1

## FileInputStreamDemo

读取文件内容

## FileOutputStreamDemo

将内容写入文件


## 注意

1. 在实际的项目中，所有的IO操作都应该放到子线程中操作，避免堵住主线程。
2. FileInputStream在读取文件内容的时候，我们传入文件的路径（"D:/abc.txt"）, 如果这个路径下的文件不存在，那么在执行readFile()方法时会报FileNotFoundException异常。
3. FileOutputStream在写入文件的时候，我们传入文件的路径（"D:/abc.txt"）, 如果这个路径下的文件不存在，那么在执行writeFile()方法时, 会默认给我们创建一个新的文件。还有重要的一点，不会报异常。