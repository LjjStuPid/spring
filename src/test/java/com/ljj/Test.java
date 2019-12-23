package com.ljj;

import java.io.*;

/**
 * @Author liujj
 * @Description TODO
 * @Date 2019/9/23 17:04
 */
public class Test implements Serializable {
//    private static final long serialVersionUID = -743517538507218629L;


    private int m;

    private void de() {
        System.out.println("de");
    }

    public void test() {
        System.out.println("fdsasfd");
    }



    public static void main(String[] args) throws IOException, ClassNotFoundException {
//        PayTypeEnum payTypeEnum = PayTypeEnum.PAYTYPE1;
//        EnumEditor enumEditor = new EnumEditor(PayTypeEnum.class);
//        enumEditor.setAsText("PAYTYPE2");
//        System.out.println(enumEditor.getValue().getClass());
//
//        ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream("www.txt"));
//        objectOutputStream.writeObject(new Test());

        ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream("www.txt"));
        Object object = objectInputStream.readObject();
        System.out.println(object);
    }
}
