package com.ljj.jdk.chapter6;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

public abstract class AbstractTransaction<T> {

    private T t;

    protected abstract void transaction(T t);

    public void getType() {
        Type type = this.getClass().getGenericSuperclass();
        if (type instanceof ParameterizedType) {
            ParameterizedType parameterizedType = (ParameterizedType) this.getClass().getGenericSuperclass();
            Type[] types = parameterizedType.getActualTypeArguments();
            System.out.println(types[0]);
            System.out.println(parameterizedType.getTypeName());

        }


    }

    public static void main(String[] args) {
        AbstractTransaction<String> abstractTransaction = new AbstractTransaction<String>() {
            @Override
            protected void transaction(String s) {

            }
        };
        abstractTransaction.getType();
    }
}
