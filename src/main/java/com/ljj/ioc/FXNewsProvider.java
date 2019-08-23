package com.ljj.ioc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @Author liujj
 * @Description 测试
 * @Date 2019/8/22 11:12
 */
@Component
public class FXNewsProvider {
    @Autowired
    private IFXNewsListener newsListener;
    @Autowired
    private IFXNewsPersister newsPersistener;

    public FXNewsProvider(IFXNewsListener newsListener, IFXNewsPersister newsPersistener) {
        this.newsListener = newsListener;
        this.newsPersistener = newsPersistener;
    }

    public FXNewsProvider() {
    }

    public void setNewsListener(IFXNewsListener newsListener) {
        this.newsListener = newsListener;
    }


    public void setNewsPersistener(IFXNewsPersister newsPersistener) {
        this.newsPersistener = newsPersistener;
    }


    public void getAndPersistNews() {
        FXNewBean fxNewBean = newsListener.getNewsByPK("1");
        newsPersistener.persistNews(fxNewBean);
    }
}
