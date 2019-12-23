package com.ljj.logic.chapter2;

import java.io.*;

public class CC implements Serializable {

    private String username;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }



    private void readObject(ObjectInputStream in) throws IOException,ClassNotFoundException{
        System.out.println("hello");
        in.defaultReadObject();       // 使定制的readObject()方法可以利用自动序列化中内置的逻辑。
//        int ival = in.readInt();      // 若要读取“int类型的值”，则使用readInt()
//        Object obj = in.readObject(); // 若要读取“Object对象”，则使用readObject()
    }

    private Object readResolve() throws ObjectStreamException {
        // instead of the object we're on,
        // return the class variable INSTANCE
        System.out.println("readResolve");
        return "readResolve";
    }
    @Override
    public String toString() {
        return "CC{" +
                "username='" + username + '\'' +
                '}';
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {

        CC cc = new CC();
        cc.setUsername("王五");
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream("fdsafds.txt"));
        objectOutputStream.writeObject(cc);

        ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream("fdsafds.txt"));
        Object c = (Object) objectInputStream.readObject();
        System.out.println(c);
    }
}
