package com.ljj.spring.aop.chapter9;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

public class DiscountMethodInterceptor implements MethodInterceptor {

    private static final Integer DEFAULT_DISCOUNT_RATIO = 80;

    private static final Integer discountRato = DEFAULT_DISCOUNT_RATIO;

    private boolean compaignAvailable;



    @Override
    public Object invoke(MethodInvocation invocation) throws Throwable {
        return null;
    }
}
