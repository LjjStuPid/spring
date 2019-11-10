package com.ljj.spring.ioc.chapter5.eventpublish;

/**
 * @Author liujj
 * @Description TODO
 * @Date 2019/8/27 16:31
 */
public class SimpleMethodExecutionEventListener implements MethodExecutionEventListener {
    @Override
    public void onMethodBegin(MethodExectionEvent event) {
        String methodName = event.getMethodName();
        System.out.println("start to execute the method[" + methodName + "].");
    }

    @Override
    public void onMethodEnd(MethodExectionEvent event) {
        String methodName = event.getMethodName();
        System.out.println("finished to execute the method[" + methodName + "].");
    }
}
