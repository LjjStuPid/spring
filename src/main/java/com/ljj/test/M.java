package com.ljj.test;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

/**
 * @Author liujj
 * @Description TODO
 * @Date 2019/12/5 18:09
 */
public class M {

    public static void main(String[] args) throws IOException, ClassNotFoundException {
//
//        User user = new User();
//        user.setUsername("liujinjian");
//
//        ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream("1.txt"));
//
//        objectOutputStream.writeObject(user);

        ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream("1.txt"));
        User user1 = (User) inputStream.readObject();
        System.out.println(user1);


    }
}
