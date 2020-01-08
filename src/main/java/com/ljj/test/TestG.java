package com.ljj.test;

/**
 * @Author liujj
 * @Description TODO
 * @Date 2019/12/25 18:06
 */
public class TestG {

    public static void main(String[] args) {

        Dog dog = new Dog("A");
        System.out.println(dog);
        func(dog);
        System.out.println(dog);
        System.out.println(dog.getName());

    }

    private static void func(Dog dog) {
        dog.setName("fdssfadsfadsf");
        dog = new Dog("B");
//        System.out.println(dog);
//        dog = new Dog("B");
//        System.out.println(dog);
//        System.out.println(dog.getName());
    }

    private static class Dog {
        public Dog(String name) {
            this.name = name;
        }

        String name;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}
