package com.ljj;

import com.sun.beans.editors.EnumEditor;

import java.lang.reflect.Method;

/**
 * @Author liujj
 * @Description TODO
 * @Date 2019/9/23 17:04
 */
public class Test {


    private void de() {
        System.out.println("de");
    }

    public void test() {
        System.out.println("fdsasfd");
    }

    public static void main(String[] args) {
        PayTypeEnum payTypeEnum = PayTypeEnum.PAYTYPE1;
        EnumEditor enumEditor = new EnumEditor(PayTypeEnum.class);
        enumEditor.setAsText("PAYTYPE2");
        System.out.println(enumEditor.getValue().getClass());
    }
}
