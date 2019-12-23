package com.ljj.jdk.chapter8;

public class DynamicDispatch {

    static abstract class Human {
        protected abstract void sayHello();
    }

    static class Man extends Human {
        @Override
        protected void sayHello() {
            System.out.println("man say hello");
        }
    }

    static class Woman extends Human {
        @Override
        protected void sayHello() {
            System.out.println("woman say Hello");
        }
    }

    public static void main(String[] args) {
        Human human = new Woman();
        Human man = new Man();
        man.sayHello();
        human.sayHello();
        man = new Woman();
        man.sayHello();
    }
}
