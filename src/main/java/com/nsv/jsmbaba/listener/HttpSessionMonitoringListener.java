package com.nsv.jsmbaba.listener;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class HttpSessionMonitoringListener implements HttpSessionListener {
    public int activeSessionCount;
    @Override
    public void sessionCreated(HttpSessionEvent httpSessionEvent) {
        activeSessionCount++;
        System.out.println("Number Of Active Sessions = "+activeSessionCount);
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent httpSessionEvent) {
        activeSessionCount--;
        System.out.println("Number Of Active Sessions = "+activeSessionCount);
    }
}
