package com.ljj;

import java.io.*;

/**
 * @Author liujj
 * @Description TODO
 * @Date 2019/9/24 11:14
 */
public enum PayTypeEnum {


    PAYTYPE1, PAYTYPE2,C;

    private static final long serialVersionUID = 28656861844162489L;

    public static void main(String[] args) throws IOException, ClassNotFoundException {
//        ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream("www.txt"));
//        objectOutputStream.writeObject(PayTypeEnum.PAYTYPE1);
//
        ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream("www.txt"));
        Object object = objectInputStream.readObject();
        System.out.println(object);


    }
}
