package com.ljj.jdk.serializable;

import java.io.*;

public class User implements Serializable {

    private static final long serialVersionUID = -2883519637597172021L;

    public static final String SSSSS = "THTHHTT";

    private String username;

    private String password;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
//        objectOutputStream.writeObject(username);
        objectOutputStream.writeObject(username);
    }

    private void readObject(ObjectInputStream inputStream) throws IOException, ClassNotFoundException {
        password = (String) inputStream.readObject();
    }


    public User() {
        System.out.println("Hello");
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {

        User user = new User();
        user.setUsername("刘金剑");
        user.setPassword("123456");

        ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream("E:\\ideaproject\\spring\\src\\main\\java\\com\\ljj\\jdk\\serializable\\user.txt"));
        objectOutputStream.writeObject(user);

        ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream("E:\\ideaproject\\spring\\src\\main\\java\\com\\ljj\\jdk\\serializable\\user.txt"));
        User object = (User) objectInputStream.readObject();
        System.out.println(object);

    }


}
