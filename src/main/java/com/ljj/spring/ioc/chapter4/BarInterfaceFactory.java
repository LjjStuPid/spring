package com.ljj.spring.ioc.chapter4;

import com.ljj.spring.ioc.chapter4.impl.BarInterfaceImpl;

public class BarInterfaceFactory {

    public static BarInterface getInstance() {
        return new BarInterfaceImpl();
    }

}
