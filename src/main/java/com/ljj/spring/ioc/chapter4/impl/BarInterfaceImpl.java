package com.ljj.spring.ioc.chapter4.impl;

import com.ljj.spring.ioc.chapter4.Bar;
import com.ljj.spring.ioc.chapter4.BarInterface;

public class BarInterfaceImpl implements BarInterface {
    public Bar getBar() {
        return new Bar();
    }
}
