package com.ljj.reflect;

import java.io.*;

/**
 * @Author liujj
 * @Description TODO
 * @Date 2019/11/28 12:38
 */
public class User implements Serializable {

    private String username;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                '}';
    }


    public Object readObject(ObjectInputStream objectInputStream) {
        System.out.println("fdsaf");
        return "fdafdas";
    }

    public Object readResolve() {
        return new User();
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream("user.txt"));
        User user = new User();
        user.setUsername("刘金剑");
        objectOutputStream.writeObject(user);

        ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream("user.txt"));
        User serialUser = (User) objectInputStream.readObject();
        System.out.println(serialUser);
    }

}
