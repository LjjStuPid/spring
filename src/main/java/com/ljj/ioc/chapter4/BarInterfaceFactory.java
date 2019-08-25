package com.ljj.ioc.chapter4;

import com.ljj.ioc.chapter4.impl.BarInterfaceImpl;

public class BarInterfaceFactory {

    public static BarInterface getInstance() {
        return new BarInterfaceImpl();
    }

}
