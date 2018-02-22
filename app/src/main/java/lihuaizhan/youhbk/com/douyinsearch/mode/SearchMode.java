package lihuaizhan.youhbk.com.douyinsearch.mode;

import android.util.Log;

import org.reactivestreams.Subscription;

import io.reactivex.Flowable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import lihuaizhan.youhbk.com.douyinsearch.api.SearchApi;
import lihuaizhan.youhbk.com.douyinsearch.bean.SearchBean;
import lihuaizhan.youhbk.com.douyinsearch.network.OnListiner;
import lihuaizhan.youhbk.com.douyinsearch.network.RetrofitHelper;

/**
 * Created by Administrator on 2018/2/22.
 */

public class SearchMode implements ISearchMode {
    @Override
    public void getSearchData(final OnListiner onListiner) {
        Flowable<SearchBean> data = RetrofitHelper.getApi().getData();
        data.doOnSubscribe(new Consumer<Subscription>() {
            @Override
            public void accept(Subscription subscription) throws Exception {

            }
        })
        .subscribeOn(Schedulers.io())
        .observeOn(AndroidSchedulers.mainThread())
        .subscribe(new Consumer<SearchBean>() {
            @Override
            public void accept(SearchBean searchBean) throws Exception {
                onListiner.onSuccess(searchBean);
            }
        });
    }
}
