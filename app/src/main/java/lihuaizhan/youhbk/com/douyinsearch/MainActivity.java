package lihuaizhan.youhbk.com.douyinsearch;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import lihuaizhan.youhbk.com.douyinsearch.adapter.SearchAdapter;
import lihuaizhan.youhbk.com.douyinsearch.bean.SearchBean;
import lihuaizhan.youhbk.com.douyinsearch.presenter.SearchPresenter;
import lihuaizhan.youhbk.com.douyinsearch.view.ISearchActivity;

public class MainActivity extends AppCompatActivity implements ISearchActivity{

    @BindView(R.id.search_finish)
    ImageView mSearchFinish;
    @BindView(R.id.search)
    EditText mSearch;
    @BindView(R.id.search_rv)
    RecyclerView mSearchRv;

    private View mHeaderView;
    private View mHeaderTwoView;
    private View mHeaderThreeView;
    private List<String> list = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        SearchPresenter presenter = new SearchPresenter(this);
        mHeaderView = View.inflate(this, R.layout.search_header, null);
        mHeaderView.findViewById(R.id.search_grid);
        mHeaderTwoView = View.inflate(this, R.layout.search_header_two, null);
        mHeaderThreeView = View.inflate(this, R.layout.search_header_three, null);
        for (int i = 0;i<50;i++)
        {
            list.add("item"+i);
        }
        presenter.getData();
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
    }
}
