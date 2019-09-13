package com.ljj.db.chapter14;

public class ClassForName {

    static {
        System.out.println("执行了静态代码块");
    }

    private static String staticField = staticMethod();


    public static String staticMethod() {
        System.out.println("执行了静态方法");
        return "给静态字段赋值了";
    }

    public static void main(String[] args) {
        try {
            Class.forName("com.ljj.db.chapter14.ClassForName");
            Class.forName("com.ljj.db.chapter14.ClassForName");
            System.out.println("上面是Class.forname加载过程");
            ClassLoader.getSystemClassLoader().loadClass("com.ljj.db.chapter14.ClassForName");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }


}
