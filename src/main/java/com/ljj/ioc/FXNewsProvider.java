package com.ljj.ioc;

/**
 * @Author liujj
 * @Description TODO
 * @Date 2019/8/22 11:12
 */
public class FXNewsProvider {
    private IFXNewsListener newsListener;
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
