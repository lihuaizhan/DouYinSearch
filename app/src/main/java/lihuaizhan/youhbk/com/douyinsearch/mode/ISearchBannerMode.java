package lihuaizhan.youhbk.com.douyinsearch.mode;

import lihuaizhan.youhbk.com.douyinsearch.network.OnListiner;

/**
 * Created by Administrator on 2018/2/22.
 */

public interface ISearchBannerMode<T> {
    public void getBannerData(OnListiner<T> onListiner);
}
