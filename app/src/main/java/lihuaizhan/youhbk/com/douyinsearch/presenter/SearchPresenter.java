package lihuaizhan.youhbk.com.douyinsearch.presenter;

import lihuaizhan.youhbk.com.douyinsearch.MainActivity;
import lihuaizhan.youhbk.com.douyinsearch.bean.SearchBean;
import lihuaizhan.youhbk.com.douyinsearch.mode.ISearchMode;
import lihuaizhan.youhbk.com.douyinsearch.mode.SearchMode;
import lihuaizhan.youhbk.com.douyinsearch.network.OnListiner;
import lihuaizhan.youhbk.com.douyinsearch.view.ISearchActivity;

/**
 * Created by Administrator on 2018/2/22.
 */

public class SearchPresenter {
    private ISearchMode iSearchMode;
    private ISearchActivity iSearchActivity;

    public SearchPresenter(ISearchActivity iSearchActivity) {
        this.iSearchActivity = iSearchActivity;
        iSearchMode = new SearchMode();
    }

    public void getData()
    {
        iSearchMode.getSearchData(new OnListiner() {
            @Override
            public void onSuccess(Object o) {
                iSearchActivity.show((SearchBean) o);
            }

            @Override
            public void onFailure(Throwable throwable) {

            }
        });
    }
}
