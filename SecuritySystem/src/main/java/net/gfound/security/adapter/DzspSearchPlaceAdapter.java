package net.gfound.security.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import net.gfound.security.R;

import java.util.List;

/**
 * Created by hiroshichuangkousuhongchuang on 14-7-8.
 */
public class DzspSearchPlaceAdapter extends BaseAdapter{
    private LayoutInflater layoutInflater;
    private List<String> searchPlaceList;
    public DzspSearchPlaceAdapter(Context context,List<String> placeList){
        this.layoutInflater=LayoutInflater.from(context);
        this.searchPlaceList=placeList;
    }
    @Override
    public int getCount() {
        return searchPlaceList.size();
    }

    @Override
    public Object getItem(int position) {
        return searchPlaceList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;
        if(convertView==null){
            convertView=layoutInflater.inflate(R.layout.dzsp_search_place_item,null);
            viewHolder=new ViewHolder();
            viewHolder.placeName=(TextView)convertView.findViewById(R.id.dzsp_search_place_name);
            convertView.setTag(viewHolder);
        }
        else{
            viewHolder=(ViewHolder)convertView.getTag();
        }
        viewHolder.placeName.setText(searchPlaceList.get(position));
        return convertView;
    }
    public class ViewHolder{
        public TextView placeName;
    }
}
