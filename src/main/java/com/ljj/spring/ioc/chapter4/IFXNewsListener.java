package com.ljj.spring.ioc.chapter4;

/**
 * @Author liujj
 * @Description TODO
 * @Date 2019/8/22 10:53
 */
public interface IFXNewsListener {

    FXNewBean getNewsByPK(String newsId);
}
