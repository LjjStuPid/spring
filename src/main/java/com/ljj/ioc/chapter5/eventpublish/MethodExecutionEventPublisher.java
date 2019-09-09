package com.ljj.ioc.chapter5.eventpublish;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author liujj
 * @Description TODO
 * @Date 2019/8/27 16:40
 */
public class MethodExecutionEventPublisher {

    private List<MethodExecutionEventListener> listeners = new ArrayList<>();

    public void methodToMonitor() {
        MethodExectionEvent event2Publish = new MethodExectionEvent(this, "methodToMonitor");
        publisherEvent(MethodExecutionStatus.BEGIN, event2Publish);
        event2Publish.getMethodName();
        publisherEvent(MethodExecutionStatus.END, event2Publish);
    }

    public void publisherEvent(MethodExecutionStatus status, MethodExectionEvent methodExectionEvent) {
        List<MethodExecutionEventListener> copyListeners = new ArrayList<>(listeners);
        for (MethodExecutionEventListener listener : copyListeners) {
            if (MethodExecutionStatus.BEGIN.equals(status)) {
                listener.onMethodBegin(methodExectionEvent);
            } else {
                listener.onMethodEnd(methodExectionEvent);
            }
        }
    }

    public void addMethodExecutionEventListener(MethodExecutionEventListener listener) {
        this.listeners.add(listener);
    }

    public void removeListener(MethodExecutionEventListener listener) {
        if (this.listeners.contains(listener)) {
            this.listeners.remove(listener);
        }
    }

    public void removeAllListeners() {
        this.listeners.clear();
    }

    public static void main(String[] args) {
        MethodExecutionEventPublisher eventPublisher = new MethodExecutionEventPublisher();
        eventPublisher.addMethodExecutionEventListener(new SimpleMethodExecutionEventListener());
        eventPublisher.methodToMonitor();
    }
}
