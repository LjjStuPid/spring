package com.ljj.ioc.chapter5.eventpublish;

import java.util.EventObject;

/**
 * @Author liujj
 * @Description TODO
 * @Date 2019/8/27 16:23
 */
public class MethodExectionEvent extends EventObject {

    private static final long serialVersionUID = 2675532208196089170L;

    private String methodName;

    /**
     * Constructs a prototypical Event.
     *
     * @param source The object on which the Event initially occurred.
     * @throws IllegalArgumentException if source is null.
     */
    public MethodExectionEvent(Object source) {
        super(source);
    }

    public MethodExectionEvent(Object source, String methodName) {
        super(methodName);
        this.methodName = methodName;
    }

    public String getMethodName() {
        return methodName;
    }

    public void setMethodName(String methodName) {
        this.methodName = methodName;
    }
}
