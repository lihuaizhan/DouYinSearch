package lihuaizhan.youhbk.com.douyinsearch.presenter;

import lihuaizhan.youhbk.com.douyinsearch.bean.SearchBanner;
import lihuaizhan.youhbk.com.douyinsearch.bean.SearchBean;
import lihuaizhan.youhbk.com.douyinsearch.mode.ISearchBannerMode;
import lihuaizhan.youhbk.com.douyinsearch.mode.ISearchMode;
import lihuaizhan.youhbk.com.douyinsearch.mode.SearchBannerMode;
import lihuaizhan.youhbk.com.douyinsearch.mode.SearchMode;
import lihuaizhan.youhbk.com.douyinsearch.network.OnListiner;
import lihuaizhan.youhbk.com.douyinsearch.view.ISearchActivity;

/**
 * Created by Administrator on 2018/2/22.
 */

public class SearchBannerPresenter {
    private ISearchBannerMode iSearchMode;
    private ISearchActivity iSearchActivity;

    public SearchBannerPresenter(ISearchActivity iSearchActivity) {
        this.iSearchActivity = iSearchActivity;
        iSearchMode = new SearchBannerMode();
    }
    public void getBaner(){
        iSearchMode.getBannerData(new OnListiner() {
            @Override
            public void onSuccess(Object o) {
                iSearchActivity.showBanner((SearchBanner) o);
            }

            @Override
            public void onFailure(Throwable throwable) {

            }
        });
    }
}
