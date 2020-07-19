package com.solitary.tank;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class T {
    public static void main(String[] args) {
        Frame f=new Frame();
        f.setSize(800,600);
        //不可变大小
        f.setResizable(false);
        f.setTitle("tank war");
        //显示
        f.setVisible(true);
        //匿名内部类监听
        //从这个程序里面的理解是 输出 输出流的概念
        //无论 文字还是图像的输出 都是信号输出根据中控解析出来
        //内部类来实现对于 内部细节的处理 去触发其他类的功能
        //异常的理解也就清晰多了 对于不同的输出流的一个矫正
        //这个时候就要理解每个类的作用  就是不同的输入和输出
        //根据中控来导出 音频 视频 文字  所有的指令化作面向对象 面向处理器的操作
        //分配给处理器
        
        f.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
    }
}
