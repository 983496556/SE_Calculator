package com.Dawn.UI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class GameJFrame_Pre extends JFrame implements KeyListener, ActionListener {
    private JPanel p1;
    private JPanel p2;
    private char op = '$';
    public JTextArea display;

    //创建选项下的条目对象
    JMenuItem closeItem = new JMenuItem("关闭计算器");
    JMenuItem accountItem = new JMenuItem("帮助");

    //存放两个数字
    private StringBuilder s1;
    private StringBuilder s2;

    private String[] buttons = {
            "AC", "删除", "%", "/",
            "7", "8", "9", "*",
            "4", "5", "6", "-",
            "1", "2", "3", "+",
            "00", "0", ".", "="
    };
    private JButton[] button = new JButton[buttons.length];

    public GameJFrame_Pre() {

        p1 = new JPanel();
        p2 = new JPanel();
        s1 = new StringBuilder();
        s2 = new StringBuilder();
        display = new JTextArea();

        //初始化界面
        InitJFrame();

        //初始化菜单
        InitJMenuBar();

        this.setVisible(true);
    }

    //菜单设置
    private void InitJMenuBar() {
        //创建整个菜单对象
        JMenuBar jMenuBar = new JMenuBar();

        //创建菜单上两个选项的对象
        JMenu functionJMenu = new JMenu("功能");
        JMenu helpJMenu = new JMenu("帮助");

        //将每一个选项下的条目添加到选项中
        functionJMenu.add(closeItem);
        helpJMenu.add(accountItem);

        //给条目绑定事件
        closeItem.addActionListener(this);
        accountItem.addActionListener(this);

        //将菜单的两个选项添加到菜单中
        jMenuBar.add(functionJMenu);
        jMenuBar.add(helpJMenu);

        //给整个界面设置菜单
        this.setJMenuBar(jMenuBar);
    }

    //界面设置
    private void InitJFrame() {
        //设置界面的宽高
        this.setSize(500, 600);

        //设置界面的标题
        this.setTitle("计算器");

        //设置界面置顶
        this.setAlwaysOnTop(true);

        //设置界面居中
        this.setLocationRelativeTo(null);

        //固定界面大小
        this.setResizable(false);

        //设置关闭模式
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        //取消默认放置模式
        this.setLayout(null);

        //给整个界面添加键盘监听事件
        this.addKeyListener(this);

        //设置布局
        this.setLayout(new BorderLayout());

        //中心位置
        this.add(p1, BorderLayout.CENTER);

        //下面
        this.add(p2, BorderLayout.SOUTH);

        //计算器屏幕大小
        display.setPreferredSize(new Dimension(450, 200));
        p1.setSize(400, 100);

        //屏幕字体
        display.setWrapStyleWord(true);
        display.setRows(2);
        display.setFont(new Font("Times New Roman", Font.PLAIN, 50));
        display.setEditable(false);
        p1.add(display);

        //设置按键
        p2.setLayout(new GridLayout(5, 4, 5, 5));
        for (int i = 0; i < button.length; i++) {
            button[i] = new JButton(" " + buttons[i] + " ");
            button[i].setPreferredSize(new Dimension(50, 60));
            p2.add(button[i]);
            button[i].addActionListener(this);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object obj = e.getSource();
        if (obj == closeItem) {
            //直接关闭虚拟机
            System.exit(0);
        } else if (obj == accountItem) {
            //创建一个弹窗对象
            JDialog jDialog = new JDialog();
            //创建一个管理图片的容器对象
            JLabel jLabel = new JLabel(new ImageIcon("img\\help1.jpg"));
            jLabel.setBounds(0, 0, 781, 780);
            jDialog.getContentPane().add(jLabel);
            jDialog.setSize(781, 780);
            jDialog.setAlwaysOnTop(true);
            //弹框居中
            jDialog.setLocationRelativeTo(null);
            //弹框不关闭无法操作下面的界面
            jDialog.setModal(true);
            //让弹框显示出来
            jDialog.setVisible(true);
        }else {

            // AC
            if (obj == button[0]) {
                display.setText("");
                s1 = new StringBuilder("");
                s2 = new StringBuilder("");
                op = '$';
                // =
            } else if (obj == button[button.length - 1]) {
                CalAndShow();
                // 删除
            } else if (obj == button[1]) {
                if (s1.length() == 0) {
                    //创建一个弹窗对象
                    JDialog jDialog = new JDialog();
                    //创建一个容器对象
                    JLabel jLabel = new JLabel("没有可删除的数字！");
                    jDialog.getContentPane().add(jLabel);
                    jDialog.setSize(150, 150);
                    jDialog.setAlwaysOnTop(true);
                    //弹框居中
                    jDialog.setLocationRelativeTo(null);
                    //弹框不关闭无法操作下面的界面
                    jDialog.setModal(true);
                    //让弹框显示出来
                    jDialog.setVisible(true);
                } else if (op == '$') {
                    s1.deleteCharAt(s1.length() - 1);
                    display.setText(s1.toString());
                } else if (s2.length() == 0) {
                    op = '$';
                    display.setText(s1.toString());
                } else {
                    s2.deleteCharAt(s2.length() - 1);
                    display.setText(s1.toString() + op + s2);
                }
            } else {
                for (int i = 2; i < button.length - 1; i++) {
                    if (obj == button[i]) {
                        display.append(buttons[i]);
                        if ((buttons[i].charAt(0) >= '0' && (buttons[i].charAt(0) <= '9')
                                || buttons[i].charAt(0) == '-' && s1.length() == 0
                                || buttons[i].charAt(0) == '.')) {
                            if (op == '$') {
                                s1.append(buttons[i]);
                            } else {
                                s2.append(buttons[i]);
                            }
                        } else {
                            if (op != '$') {
                                if (s2.length() == 0) {
                                    display.setText(s1.toString() + buttons[i]);
                                } else {
                                    String temp = String.valueOf(op);
                                    CalAndShow();
                                    display.append(temp);
                                }

//                                String temp = String.valueOf(op);
//                                CalAndShow();
//                                display.append(temp);
                            }
                            op = buttons[i].charAt(0);
                        }
                        break;
                    }
                }
            }
        }
    }

    //计算结果并展示
    private void CalAndShow() {
        if (s2.length() != 0) {
            double num1 = Double.parseDouble(s1.toString());
            double num2 = Double.parseDouble(s2.toString());
            if (op == '+') {
                num1 += num2;
            } else if (op == '-') {
                num1 -= num2;
            } else if (op == '*') {
                num1 *= num2;
            } else if (op == '%') {
                num1 %= num2;
            } else if (op == '/') {
                if (num2 == 0) {
                    showNumErr();
                } else {
                    num1 /= num2;
                }
            }
            if (num1 % 1 == 0) {
                s1 = new StringBuilder(String.valueOf((int) num1));
            } else {
                s1 = new StringBuilder(String.valueOf(num1));
            }
            s2 = new StringBuilder("");
            op = '$';
        }
        display.setText(s1.toString());
    }

    //除数为零报错
    private void showNumErr() {
        //创建一个弹窗对象
        JDialog jDialog = new JDialog();
        //创建一个容器对象
        JLabel jLabel = new JLabel("除数不能为零！！！");
        jDialog.getContentPane().add(jLabel);
        jDialog.setSize(150, 150);
        jDialog.setAlwaysOnTop(true);
        //弹框居中
        jDialog.setLocationRelativeTo(null);
        //弹框不关闭无法操作下面的界面
        jDialog.setModal(true);
        //让弹框显示出来
        jDialog.setVisible(true);
    }

    //按下后调用
    @Override
    public void keyTyped(KeyEvent e) {
    }

    //按下不松时调用
    @Override
    public void keyPressed(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {
    }
}
