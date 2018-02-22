package lihuaizhan.youhbk.com.douyinsearch.adapter;

import android.content.Context;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import lihuaizhan.youhbk.com.douyinsearch.R;


/**
 * Created by Administrator on 2018/2/22.
 */

public class SearchAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private Context context;
   // private List<SearchExtra.DataBean.RecommendUserBean> list;
    private LayoutInflater inflater;
    private View mHeaderView;
    private View mHeaderTwoView;
    private View mHeaderThreeView;
    private List<String> list = new ArrayList<>();
    public static final int TYPE_HEADER = 0;
    public static final int TYPE_HEADERTWO = 1;
    public static final int TYPE_HEADERThree = 2;
    public static final int TYPE_NORMAL = 3;

    public SearchAdapter(Context context, List<String> list) {
        this.context = context;
        this.list = list;
        inflater = LayoutInflater.from(context);
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View inflate = inflater.inflate(R.layout.search_item, parent, false);
        if(mHeaderView != null && viewType == TYPE_HEADER) return new MyViewHolder(mHeaderView);
        if(mHeaderTwoView != null && viewType == TYPE_HEADERTWO) return new MyViewHolder(mHeaderTwoView);
        if(mHeaderThreeView != null && viewType == TYPE_HEADERThree) return new MyViewHolder(mHeaderThreeView);
        return new MyViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        String s = list.get(position);
        if(getItemViewType(position) == TYPE_HEADER) return;
        if(getItemViewType(position) == TYPE_HEADERTWO) return;
        if(getItemViewType(position) == TYPE_HEADERThree) return;
        MyViewHolder holder1 = (MyViewHolder) holder;
        holder1.txt.setText(s);
    }
    @Override
    public int getItemViewType(int position) {
        if(mHeaderView == null) return TYPE_NORMAL;
        if(mHeaderTwoView == null) return TYPE_NORMAL;
        if(mHeaderThreeView == null) return TYPE_NORMAL;
        if(position == 0) return TYPE_HEADER;
        if(position == 1) return TYPE_HEADERTWO;
        if(position == 2) return TYPE_HEADERThree;
        return TYPE_NORMAL;
    }
    public void setHeaderView(View headerView) {
        mHeaderView = headerView;
        notifyItemInserted(0);
    }
    public void setHeaderTwoView(View headerTwoView) {
        mHeaderTwoView = headerTwoView;
        notifyItemInserted(1);
    }
    public void setHeaderThreeView(View headerThreeView) {
        mHeaderThreeView = headerThreeView;
        notifyItemInserted(2);
    }
    public View getHeaderView() {
        return mHeaderView;
    }
    public View getHeaderTwoView() {
        return mHeaderTwoView;
    }
    public View getHeaderThreeView() {
        return mHeaderThreeView;
    }
    @Override
    public int getItemCount() {
        return list.size();
    }
    class MyViewHolder extends RecyclerView.ViewHolder
    {
          private TextView txt;
        public MyViewHolder(View itemView) {
            super(itemView);
            txt = itemView.findViewById(R.id.search_item_txt);
        }
    }
}
