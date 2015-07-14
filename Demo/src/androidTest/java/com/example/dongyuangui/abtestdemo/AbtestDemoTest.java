package com.example.dongyuangui.abtestdemo;

import android.support.test.uiautomator.UiDevice;
import android.support.test.uiautomator.UiObject;
import android.support.test.uiautomator.UiObjectNotFoundException;
import android.support.test.uiautomator.UiScrollable;
import android.support.test.uiautomator.UiSelector;
import android.test.InstrumentationTestCase;

import java.util.Random;

public class AbtestDemoTest extends InstrumentationTestCase {
    public void testDemo() throws UiObjectNotFoundException {

        Random random = new Random();


        UiDevice mDevice = UiDevice.getInstance(getInstrumentation());
        UiObject abTestDemo = mDevice.findObject(new UiSelector().description("AbTestDemo"));

        abTestDemo.clickAndWaitForNewWindow();
//        UiObject seven = mDevice.findObject(new UiSelector().resourceId("com.android.calculator2:id/digit_7"));
        UiObject flagButton = mDevice.findObject(new UiSelector().text("模块开关测试"));
        flagButton.click();
//        abTestDemo.clickAndWaitForNewWindow();
        UiObject flagResult = mDevice.findObject(new UiSelector().resourceId("com.example.adhoc.abtestdemo:id/btn01"));
        String resultText = flagResult.getText();
        boolean value = resultText.startsWith("实验");
//        assertEquals("实验版本", "实验版本A", resultText);
        assertTrue(value);
        //
        flagResult.click();
        mDevice.pressBack();
        //自动统计测试
        UiObject zidongtongji = mDevice.findObject(new UiSelector().text("自动统计测试"));
        zidongtongji.click();
        UiObject addView = mDevice.findObject(new UiSelector().text("AddView"));

        for(int i=0;i<10;i++){
            addView.click();
        }
        mDevice.pressBack();

        //测试按钮
        UiObject ceshianniu = mDevice.findObject(new UiSelector().text("测试按钮"));
        ceshianniu.click();
        UiObject tv_tip = mDevice.findObject(new UiSelector().resourceId("com.example.adhoc.abtestdemo:id/tv_tip"));

        String txtFlag = tv_tip.getText();
        assertFalse(txtFlag.equals("{}"));

        UiObject version = mDevice.findObject(new UiSelector().resourceId("com.example.adhoc.abtestdemo:id/btn_click"));
        int x = Math.abs(random.nextInt(10));
        for(int i=0;i<x;i++){
            version.click();
        }
        mDevice.pressBack();


        //测试登录
        UiObject denglu = mDevice.findObject(new UiSelector().text("测试登录"));
        denglu.click();
        UiObject btn_denglu = mDevice.findObject(new UiSelector().text("登录"));
        btn_denglu.click();
        mDevice.pressBack();


        //测试页面顺序
        UiObject ceshiyemianshunxu = mDevice.findObject(new UiSelector().text("测试页面顺序"));
        ceshiyemianshunxu.click();
        mDevice.pressBack();

        //测试列表展示
        UiObject ceshiliebiaozhans = mDevice.findObject(new UiSelector().text("测试列表展示"));
        ceshiliebiaozhans.click();

        // item 点击测试
        UiObject listview = mDevice.findObject(new UiSelector().resourceId("com.example.adhoc.abtestdemo:id/listb"));
        listview.getChild(new UiSelector().clickable(true).index(0)).click();
        // 滑动测试
        UiScrollable scroll=new UiScrollable(new UiSelector().className("android.widget.ListView"));
        scroll.flingForward();
//        mDevice.swipe(200, 300, 200, 60, 1);
        scroll.flingBackward();
        mDevice.pressBack();


        //测试列表展示
        UiObject dibuzhanshiceshi = mDevice.findObject(new UiSelector().text("底部展示测试"));

        dibuzhanshiceshi.click();
        UiObject item1 = mDevice.findObject(new UiSelector().resourceId("com.example.adhoc.abtestdemo:id/iv_display1"));
        item1.click();

        mDevice.pressBack();

        // 切换到主屏
        mDevice.pressHome();

        // 重新启动

        UiObject abTestDemoReStart = mDevice.findObject(new UiSelector().description("AbTestDemo"));

        abTestDemoReStart.clickAndWaitForNewWindow();
    }
}