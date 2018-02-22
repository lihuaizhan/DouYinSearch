package lihuaizhan.youhbk.com.douyinsearch.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import lihuaizhan.youhbk.com.douyinsearch.R;
import lihuaizhan.youhbk.com.douyinsearch.bean.SearchBean;
import lihuaizhan.youhbk.com.douyinsearch.network.Constants;

/**
 * Created by Administrator on 2018/2/22.
 */

public class SearchHeaderAdapter extends BaseAdapter {
    private List<SearchBean.DataBean> list = new ArrayList<>();
    private Context context;
    private LayoutInflater inflater;

    public SearchHeaderAdapter(List<SearchBean.DataBean> list, Context context) {
        this.list = list;
        this.context = context;
        inflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        MyViewHolder holder;
        if(convertView == null)
        {
            holder = new MyViewHolder();
            convertView = inflater.inflate(R.layout.search_header_item,parent,false);
            holder.txt = convertView.findViewById(R.id.search_header_item_txt);
            convertView.setTag(holder);
        }
        else {
           holder = (MyViewHolder) convertView.getTag();
        }
        SearchBean.DataBean dataBean = list.get(position);
        holder.txt.setText(dataBean.getChallenge().getCha_name());

        return convertView;
    }
    class MyViewHolder{
        private TextView txt;

    }
}
