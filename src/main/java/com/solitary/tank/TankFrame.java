package com.solitary.tank;

import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

//方块运行
public class TankFrame extends Frame {

    int x = 200, y = 200;


    public TankFrame() throws HeadlessException {

        Frame f = new Frame();
        setSize(800, 600);
        //不可变大小
        setResizable(false);
        setTitle("tank war");
        //显示
        setVisible(true);
        //添加监听事件
        this.addKeyListener(new MyKeyListener());
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
    }

    /***
     *为什么会自动调用该方法呢？
     * 一定运用了设计模式 或者说调用法
     * 举个例子 像汽车启动 会通过引擎调用一系列的方法
     * 但是尾灯不一定亮 也可能亮
     * 这是一个继承类 潜藏了很多实现
     * 不是说万物皆可点亮嘛
     *
     * 这个类就是在这个线程中调用该方法时候
     * 系统会自动调用一个画笔类给我使用
     *
     * 多种输入的硬件
     *
     *
     * 我们可以利用计算机硬件设备来完成软件功能
     * 例如定时器就用到了时钟
     * 各种硬件之间的配合组成了计算机系统
     *
     * 对于计算机动静态的理解
     * 离线和在线的区别
     * 内核线程和用户线程的区别
     * 我们的操作 编程 输入都是用户级别的使用
     * 而电脑是周而复始不断运行的 依赖的就是内核的循环
     * 是自动化的
     * 而我们用户的操作相较于内核是静态的
     * 这才是多用户的实质
     * 我们无法操作内核的内存 因为会导致系统错误 蓝屏
     * 我们只能实例化自己的编程线程 然后由内核调度
     * 来实现我们的功能  说白了我们的编程都是用户级的应用编程
     * 底层的硬件编程我们还接触不到
     * 我们所谓的输入输出都是基于计算机的 我们是更上层的发令者
     * 内核线程  通过一定的刷新率来刷新界面 基于我们的改变和现有的状态
     * 来绘制这一时刻的各种运动  1/380,000的速度
     *
     * 通过几个继承类把一个功能对象 类化 神的分身 细胞的分化
     * 每个人的组合 像搭积木一样组合一个系统 其实说白了 还是过程性的
     * 这个时候了解一下JVM源码该多好
     *
     * A用到B类 其他的类用不着 这个时候放到内部就行了 这就是内部类
     *
     * 告诉编译器 我是重写的
     *
     * 计算机显示器就是Frame
     * 这种抽象能力
     *
     *
     * */
    @Override
    public void paint(Graphics g) {
        System.out.println("paint");
        g.fillRect(x, y, 50, 50);
        //x += 10;
        //y += 10;
    }


    /**
     * 什么是聪明 就是实事求是的看待 了解物理 具备抽象模型化
     * 监听事件 对于键盘的监听
     * 显示器不光能显示 还能接收信号是一个定位功能的一个界面
     * 每个具体的位置会是一个具体的区域
     * 一旦发生了鼠标偏移就会进行信号的转化
     * 将位信号 转化位 操作信号
     * 这就是监听器 监听鼠标 键盘 、、、的信号
     * 这样分区 光感的技术就可以准确的进入不同的处理端口
     * 监听一切键盘和鼠标的输入信号了
     * 这样就可以具备抽象的能力了
     * 面向硬件的面向对象 这样计算机就有了无限潜能
     */
    /**
     * 为什么 什么时候调用的呢？
     * 因为是内部类 供外层类使用 所以解析的时候
     * 会把它挂载到这个类下边 执行指令的时候会走到这里
     */
    class MyKeyListener extends KeyAdapter {
        /**
         * 斜着走的时候的 关注点 应该是先后关系 可以转化为按键先后关系
         * 然后再转化为我们能理解的 方向关系 这样的思考方式
         * <p>
         * 你再快也一定有先后关系的 因为计算机的最慢毫秒级速度你都跟不上
         *
         * 沿着思路去独立完成
         */
        boolean bL = false;
        boolean bU = false;
        boolean bR = false;
        boolean bD = false;

        @Override
        public void keyPressed(KeyEvent e) {
            int key = e.getKeyCode();
            switch (key) {
                case KeyEvent.VK_LEFT:
                    bL = true;
                    break;
                case KeyEvent.VK_UP:
                    bU = true;
                    break;
                case KeyEvent.VK_RIGHT:
                    bR = true;
                    break;
                case KeyEvent.VK_DOWN:
                    bD = true;
                    break;
                default:
                    break;
            }



        }

        @Override
        public void keyReleased(KeyEvent e) {
            int key = e.getKeyCode();
            switch (key) {
                case KeyEvent.VK_LEFT:
                    bL = false;
                    break;
                case KeyEvent.VK_UP:
                    bU = false;
                    break;
                case KeyEvent.VK_RIGHT:
                    bR = false;
                    break;
                case KeyEvent.VK_DOWN:
                    bD = false;
                    break;
                default:
                    break;
            }
        }

    }

}
