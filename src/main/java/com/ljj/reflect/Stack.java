package com.ljj.reflect;

import java.util.Arrays;

/**
 * @Author liujj
 * @Description TODO
 * @Date 2019/11/27 10:23
 */
public class Stack<T> {

    public static final int DEFAULT_SIZE = 5;

    private Object[] objects = new Object[DEFAULT_SIZE];

    private int size;

    public boolean push(T item) {
        objects[size++] = item;
        return true;
    }

    public T pop() {
        T old = (T) objects[--size];
        objects[size] = null;
        return old;
    }

    @Override
    public String toString() {
        return "Stack{" +
                "objects=" + Arrays.toString(objects) +
                ", size=" + size +
                '}';
    }

    public static void main(String[] args) {
        Stack<String> stringStack = new Stack<>();
        stringStack.push("fdsafd");
        stringStack.push("fds");
        stringStack.push("fds");
        System.out.println(stringStack);
        stringStack.pop();
        System.out.println(stringStack);
    }
}
