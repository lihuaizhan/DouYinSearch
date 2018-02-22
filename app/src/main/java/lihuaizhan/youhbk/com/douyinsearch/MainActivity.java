package lihuaizhan.youhbk.com.douyinsearch;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.Toast;


import com.youth.banner.Banner;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import lihuaizhan.youhbk.com.douyinsearch.adapter.GlideImageLoader;
import lihuaizhan.youhbk.com.douyinsearch.adapter.SearchAdapter;
import lihuaizhan.youhbk.com.douyinsearch.adapter.SearchHeaderAdapter;
import lihuaizhan.youhbk.com.douyinsearch.bean.SearchBanner;
import lihuaizhan.youhbk.com.douyinsearch.bean.SearchBean;
import lihuaizhan.youhbk.com.douyinsearch.presenter.SearchBannerPresenter;
import lihuaizhan.youhbk.com.douyinsearch.presenter.SearchPresenter;
import lihuaizhan.youhbk.com.douyinsearch.view.ISearchActivity;

public class MainActivity extends AppCompatActivity implements ISearchActivity{

    @BindView(R.id.search_finish)
    ImageView mSearchFinish;
    @BindView(R.id.search)
    EditText mSearch;
    @BindView(R.id.search_rv)
    RecyclerView mSearchRv;
    private GridView gv;
    private View mHeaderView;
    private View mHeaderTwoView;
    private View mHeaderThreeView;
    private List<String> list = new ArrayList<>();
    private Banner ban;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        SearchPresenter presenter = new SearchPresenter(this);
        SearchBannerPresenter presenter1 = new SearchBannerPresenter(this);
        mHeaderView = View.inflate(this, R.layout.search_header, null);
        gv = mHeaderView.findViewById(R.id.search_grid);

        mHeaderTwoView = View.inflate(this, R.layout.search_header_two, null);
        mHeaderThreeView = View.inflate(this, R.layout.search_header_three, null);
        ban = mHeaderThreeView.findViewById(R.id.search_header_three_banner);
        for (int i = 0;i<50;i++)
        {
            list.add("item"+i);
        }
        presenter.getData();
        presenter1.getBaner();

    }

    @OnClick(R.id.search_finish)
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
            case R.id.search_finish:
                break;
        }
    }

    @Override
    public void show(SearchBean bean) {
        Toast.makeText(getApplicationContext(),bean.getStatus_code()+bean.getStatus_msg()+bean.toString(),Toast.LENGTH_SHORT).show();
        mSearchRv.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        SearchAdapter adapter = new SearchAdapter(this,list);
        mSearchRv.setAdapter(adapter);
        adapter.setHeaderView(mHeaderView);
        adapter.setHeaderTwoView(mHeaderTwoView);
        adapter.setHeaderThreeView(mHeaderThreeView);
        List<SearchBean.DataBean> data = bean.getData();
        SearchHeaderAdapter adapter1 = new SearchHeaderAdapter(data,this);
        gv.setAdapter(adapter1);
    }

    @Override
    public void showBanner(SearchBanner banner) {
        List<SearchBanner.BannerBean> banner1 = banner.getBanner();
        List<String> images = new ArrayList<>();
        for (int i =0;i<banner1.size();i++)
        {
            images.add(banner1.get(i).getBanner_url().getUrl_list().get(0));
        }
        //是否自动轮播
        ban.setImageLoader(new GlideImageLoader());
        ban.isAutoPlay(true);

//设置轮播的时间间隔
        ban.setDelayTime(3000);
        ban.setImages(images);
        ban.start();
    }
}
