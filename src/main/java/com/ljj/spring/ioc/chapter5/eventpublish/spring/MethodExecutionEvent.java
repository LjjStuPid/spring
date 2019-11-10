package com.ljj.spring.ioc.chapter5.eventpublish.spring;

import com.ljj.spring.ioc.chapter5.eventpublish.MethodExecutionStatus;
import org.springframework.context.ApplicationEvent;

/**
 * @Author liujj
 * @Description TODO
 * @Date 2019/8/27 17:31
 */
public class MethodExecutionEvent extends ApplicationEvent {

    private static final long serialVersionUID = -3481154438562898507L;

    private String methodName;

    private MethodExecutionStatus methodExecutionStatus;

    public MethodExecutionEvent(Object source) {
        super(source);
    }

    public MethodExecutionEvent(Object source, String methodName, MethodExecutionStatus methodExecutionStatus) {
        super(source);
        this.methodName = methodName;
        this.methodExecutionStatus = methodExecutionStatus;
    }

    public String getMethodName() {
        return methodName;
    }

    public void setMethodName(String methodName) {
        this.methodName = methodName;
    }

    public MethodExecutionStatus getMethodExecutionStatus() {
        return methodExecutionStatus;
    }

    public void setMethodExecutionStatus(MethodExecutionStatus methodExecutionStatus) {
        this.methodExecutionStatus = methodExecutionStatus;
    }
}
