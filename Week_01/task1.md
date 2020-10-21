Hello.java 源码
'''
package com.ty.demo;

public class Hello {
    public int bar(int i){
        return ((i+3)-2) * 3 /4;
    }
    public static void main(String args[]){
        Hello obj = new Hello();
        for(int j=0;;j++){
            if(j< 3){
             obj.bar(5);
            }
        }
    }
}
'''

查看字节码
'''
 javap -c -verbose  Hello

'''
 字节码分析
'''
Warning: Binary file Hello contains com.ty.demo.Hello
Classfile /Users/YZYY/learn/JAVA-000/Week_01/Hello.class
  Last modified Oct 21, 2020; size 420 bytes
  MD5 checksum 116f9a24ff23a0b02d781704c06aaca6
  Compiled from "Hello.java"
public class com.ty.demo.Hello
  minor version: 0
  major version: 52             //java 版本
  flags: ACC_PUBLIC, ACC_SUPER
Constant pool:                  // 常量池
   #1 = Methodref          #5.#18         // java/lang/Object."<init>":()V
   #2 = Class              #19            // com/ty/demo/Hello
   #3 = Methodref          #2.#18         // com/ty/demo/Hello."<init>":()V
   #4 = Methodref          #2.#20         // com/ty/demo/Hello.bar:(I)I
   #5 = Class              #21            // java/lang/Object
   #6 = Utf8               <init>
   #7 = Utf8               ()V
   #8 = Utf8               Code
   #9 = Utf8               LineNumberTable
  #10 = Utf8               bar
  #11 = Utf8               (I)I
  #12 = Utf8               main
  #13 = Utf8               ([Ljava/lang/String;)V
  #14 = Utf8               StackMapTable
  #15 = Class              #19            // com/ty/demo/Hello
  #16 = Utf8               SourceFile
  #17 = Utf8               Hello.java
  #18 = NameAndType        #6:#7          // "<init>":()V
  #19 = Utf8               com/ty/demo/Hello
  #20 = NameAndType        #10:#11        // bar:(I)I
  #21 = Utf8               java/lang/Object
{
  public com.ty.demo.Hello();
    descriptor: ()V
    flags: ACC_PUBLIC
    Code:
      stack=1, locals=1, args_size=1
         0: aload_0
         1: invokespecial #1                  // Method java/lang/Object."<init>":()V
         4: return
      LineNumberTable:
        line 3: 0

  public int bar(int);
    descriptor: (I)I
    flags: ACC_PUBLIC
    Code:
      stack=2, locals=2, args_size=2   // stack=2 需要的操作数栈空间为2，locals=2表示 方法有两个本地变量，args_size=2 表示有两个参数，this，和int i
         0: iload_1                    // iload 加载槽位1中的int 
         1: iconst_3                   // iconst_3 加载常量3
         2: iadd                       // 操作数栈相加 并入栈
         3: iconst_2                   // 加载常量2
         4: isub                       // 相减并将结果入栈
         5: iconst_3                   // 加载 常量3
         6: imul                       // 乘
         7: iconst_4                   // 加载常量4
         8: idiv                       // 除
         9: ireturn                    // 返回栈顶int 
      LineNumberTable:
        line 5: 0                      // 源码第5行 对应 iload_1 

  public static void main(java.lang.String[]);
    descriptor: ([Ljava/lang/String;)V
    flags: ACC_PUBLIC, ACC_STATIC
    Code:
      stack=2, locals=3, args_size=1          // stack=2 需要的操作数栈空间为2，locals=3表示 方法有三个个本地变量，args_size=1 args 数组
         0: new           #2                  // class com/ty/demo/Hello 内存中创建为初始化Hello 对象
         3: dup                               // 复制一份一份未初始化的对象
         4: invokespecial #3                  // Method "<init>":()V Hello 初始化
         7: astore_1                          // 将初始化的对象引 存入本地变量表槽位1中
         8: iconst_0                          // 加载常量 0  for 循环中的j = 0
         9: istore_2                          // 将j 存入本地变量槽位2中
        10: iload_2                           // 加载槽位2 入栈
        11: iconst_3                          // 加载常量3 入栈
        12: if_icmpge     21                  // 比较栈中原数，如果不满足跳转到21行执行，如果满足继续执行
        15: aload_1                           // 加载本地变量表 1 中的obj
        16: iconst_5                          // 押入 常量5 
        17: invokevirtual #4                  // Method bar:(I)I 执行 bar方法
        20: pop                               // 将结果抛出，出栈
        21: iinc          2, 1                // 将局部变量表中槽位为2的j 增加1
        24: goto          10                  // 跳转到第10行执行
      LineNumberTable:                        // 源码行对应表
        line 8: 0                             // 源码第8行 即main第一行对应Code 中第一行
        line 9: 8
        line 10: 10
        line 11: 15
        line 9: 21
      StackMapTable: number_of_entries = 2
        frame_type = 253 /* append */
          offset_delta = 10
          locals = [ class com/ty/demo/Hello, int ]
        frame_type = 10 /* same */
}
SourceFile: "Hello.java"
'''
