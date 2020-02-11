package com.ljj.classloader;

import java.lang.reflect.InvocationTargetException;
import java.util.HashSet;
import java.util.Set;
import java.util.Timer;
import java.util.TimerTask;

/**
 * @Author liujj
 * @Description TODO
 * @Date 2020/2/11 15:05
 */
public class TestClassLoader {

    public static void main(String[] args) {
        new Timer().schedule(new TimerTask() {
            @Override
            public void run() {
                String swapPath = MyClassLoader.class.getResource("").getPath() + "swap/";
                String className = "com.ljj.classloader.swap.Test";
                Set<String> stringSet = new HashSet<>();
                stringSet.add(className);
                MyClassLoader myClassLoader = new MyClassLoader(swapPath, stringSet);
                try {
                    Object m = myClassLoader.loadClass(className).newInstance();
                    m.getClass().getMethod("printVersion").invoke(m);
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                } catch (InstantiationException e) {
                    e.printStackTrace();
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                } catch (NoSuchMethodException e) {
                    e.printStackTrace();
                } catch (InvocationTargetException e) {
                    e.printStackTrace();
                }
            }
        }, 0, 2000);
    }
}
