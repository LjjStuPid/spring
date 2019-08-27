package com.ljj.ioc.chapter5.eventpublish;

import java.util.EventListener;

public interface MethodExecutionEventListener extends EventListener {


    /**
     * 处理方法开始执行的时候发布的MethodExecutionEvent事件
     *
     * @param event
     */
    void onMethodBegin(MethodExectionEvent event);


    /**
     * 处理方法执行将结束时候发布的MethodExecutionEvent事件
     *
     * @param event
     */
    void onMethodEnd(MethodExectionEvent event);

}
