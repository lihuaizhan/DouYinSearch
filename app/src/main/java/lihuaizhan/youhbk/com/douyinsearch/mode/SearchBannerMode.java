package lihuaizhan.youhbk.com.douyinsearch.mode;

import org.reactivestreams.Subscription;

import io.reactivex.Flowable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import lihuaizhan.youhbk.com.douyinsearch.bean.SearchBanner;
import lihuaizhan.youhbk.com.douyinsearch.bean.SearchBean;
import lihuaizhan.youhbk.com.douyinsearch.network.OnListiner;
import lihuaizhan.youhbk.com.douyinsearch.network.RetrofitHelper;

/**
 * Created by Administrator on 2018/2/22.
 */

public class SearchBannerMode implements ISearchBannerMode {

    @Override
    public void getBannerData(final OnListiner onListiner) {
        Flowable<SearchBanner> banner = RetrofitHelper.getApi().getBanner();
        banner.doOnSubscribe(new Consumer<Subscription>() {
            @Override
            public void accept(Subscription subscription) throws Exception {

            }
        })
        .subscribeOn(Schedulers.io())
        .observeOn(AndroidSchedulers.mainThread())
        .subscribe(new Consumer<SearchBanner>() {
            @Override
            public void accept(SearchBanner searchBanner) throws Exception {
                onListiner.onSuccess(searchBanner);
            }
        });
    }
}
