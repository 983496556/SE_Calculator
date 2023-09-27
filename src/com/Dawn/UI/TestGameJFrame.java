package com.Dawn.UI;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import java.util.Random;

public class TestGameJFrame {

    GameJFrame cul;

    @Before
    public void setup() {
        cul = new GameJFrame();
    }

    @Test
    public void AddTest() {
        Random r = new Random();
        double[] ans = new double[100];
        double[] res = new double[100];
        for (int i = 0; i < 100; i++) {
            double x = r.nextDouble();
            double y = r.nextDouble();
            ans[i] = x + y;
            cul.s1 = new StringBuilder(String.valueOf(x));
            cul.s2 = new StringBuilder(String.valueOf(y));
            cul.op = '+';
            cul.CalAndShow();
            res[i] = Double.parseDouble(cul.display.getText());
        }
        Assert.assertArrayEquals("Error", ans, res, 0.01);
    }

    @Test
    public void SubTest() {
        Random r = new Random();
        double[] ans = new double[100];
        double[] res = new double[100];
        for (int i = 0; i < 100; i++) {
            double x = r.nextDouble();
            double y = r.nextDouble();
            ans[i] = x - y;
            cul.s1 = new StringBuilder(String.valueOf(x));
            cul.s2 = new StringBuilder(String.valueOf(y));
            cul.op = '-';
            cul.CalAndShow();
            res[i] = Double.parseDouble(cul.display.getText());
        }
        Assert.assertArrayEquals("Error", ans, res, 0.01);
    }

    @Test
    public void MulTest() {
        Random r = new Random();
        double[] ans = new double[100];
        double[] res = new double[100];
        for (int i = 0; i < 100; i++) {
            double x = r.nextDouble();
            double y = r.nextDouble();
            ans[i] = x * y;
            cul.s1 = new StringBuilder(String.valueOf(x));
            cul.s2 = new StringBuilder(String.valueOf(y));
            cul.op = '×';
            cul.CalAndShow();
            res[i] = Double.parseDouble(cul.display.getText());
        }
        Assert.assertArrayEquals("Error", ans, res, 0.01);
    }

    @Test
    public void DivTest() {
        Random r = new Random();
        double[] ans = new double[100];
        double[] res = new double[100];
        for (int i = 0; i < 100; i++) {
            double x = r.nextDouble();
            double y = r.nextDouble();
            ans[i] = x / y;
            cul.s1 = new StringBuilder(String.valueOf(x));
            cul.s2 = new StringBuilder(String.valueOf(y));
            cul.op = '÷';
            cul.CalAndShow();
            res[i] = Double.parseDouble(cul.display.getText());
        }
        Assert.assertArrayEquals("Error", ans, res, 0.01);
    }

    @Test
    public void PowerTest() {
        Random r = new Random();
        double[] ans = new double[100];
        double[] res = new double[100];
        for (int i = 0; i < 100; i++) {
            double x = r.nextInt();
            double y = r.nextInt();
            ans[i] = Math.pow(x, y);
            cul.s1 = new StringBuilder(String.valueOf(x));
            cul.s2 = new StringBuilder(String.valueOf(y));
            cul.op = '^';
            cul.CalAndShow();
            res[i] = Double.parseDouble(cul.display.getText());
        }
        Assert.assertArrayEquals("Error", ans, res, 0.01);
    }

    @Test
    public void RemainderTest() {
        Random r = new Random();
        double[] ans = new double[100];
        double[] res = new double[100];
        for (int i = 0; i < 100; i++) {
            double x = r.nextInt();
            double y = r.nextInt();
            ans[i] = x % y;
            cul.s1 = new StringBuilder(String.valueOf(x));
            cul.s2 = new StringBuilder(String.valueOf(y));
            cul.op = '%';
            cul.CalAndShow();
            res[i] = Double.parseDouble(cul.display.getText());
        }
        Assert.assertArrayEquals("Error", ans, res, 0.01);
    }

    @Test
    public void SqrtTest() {
        Random r = new Random();
        double[] ans = new double[100];
        double[] res = new double[100];
        for (int i = 0; i < 100; i++) {
            double x = r.nextInt();
            ans[i] = Math.sqrt(x);
            cul.s1 = new StringBuilder("√" + x);
            cul.CalAndShow();
            res[i] = Double.parseDouble(cul.display.getText());
        }
        Assert.assertArrayEquals("Error", ans, res, 0.01);
    }


    @Test
    public void sinTest() {
        Random r = new Random();
        double[] ans = new double[100];
        double[] res = new double[100];
        for (int i = 0; i < 100; i++) {
            double x = r.nextDouble();
            ans[i] = Math.sin(x);
            cul.s1 = new StringBuilder("sin" + x);
            cul.CalAndShow();
            res[i] = Double.parseDouble(cul.display.getText());
        }
        Assert.assertArrayEquals("Error", ans, res, 0.01);
    }

    @Test
    public void cosTest() {
        Random r = new Random();
        double[] ans = new double[100];
        double[] res = new double[100];
        for (int i = 0; i < 100; i++) {
            double x = r.nextDouble();
            ans[i] = Math.cos(x);
            cul.s1 = new StringBuilder("cos" + x);
            cul.CalAndShow();
            res[i] = Double.parseDouble(cul.display.getText());
        }
        Assert.assertArrayEquals("Error", ans, res, 0.01);
    }

    @Test
    public void tanTest() {
        Random r = new Random();
        double[] ans = new double[100];
        double[] res = new double[100];
        for (int i = 0; i < 100; i++) {
            double x = r.nextDouble();
            ans[i] = Math.tan(x);
            cul.s1 = new StringBuilder("tan" + x);
            cul.CalAndShow();
            res[i] = Double.parseDouble(cul.display.getText());
        }
        Assert.assertArrayEquals("Error", ans, res, 0.01);
    }

    @Test
    public void dealNumTest() {
        double[] res = new double[3];
        double[] ans = {-1, Math.sqrt(11), Double.MAX_VALUE};
        res[0] = GameJFrame.dealNum("cosΠ");
        res[1] = GameJFrame.dealNum("√11");
        res[2] = GameJFrame.dealNum("sin5sin");
        Assert.assertArrayEquals("Error", ans, res, 0.01);
    }

    @Test
    public void countTimesTest() {
        int[] res = new int[3];
        int[] ans = {0, 1, 2};
        res[0] = GameJFrame.countTimes("Jordan", "s");
        res[1] = GameJFrame.countTimes("Github", "u");
        res[2] = GameJFrame.countTimes("sometimes", "e");
        Assert.assertArrayEquals("Error", ans, res);
    }


}
