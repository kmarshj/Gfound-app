package net.gfound.security.ui;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ListView;

import net.gfound.security.R;
import net.gfound.security.adapter.DzspSearchPlaceAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by hiroshichuangkousuhongchuang on 14-7-8.
 */
public class DzspSearchActivity extends Activity {
    private ListView placeListView;
    private ListView resultListVIew;
    private List<String> placeList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setContentView(R.layout.view_dzsp_qjdw_search);
        placeList=new ArrayList<String>() ;
        initPlaceData();
        initView();
    }
    private void initView(){
        placeListView=(ListView)findViewById(R.id.dzsp_serach_place_list);
        if(placeList.size()>0){
            DzspSearchPlaceAdapter placeAdapter=new DzspSearchPlaceAdapter(this,placeList);
            placeListView.setAdapter(placeAdapter);
        }
    }
    //模拟数据
    private List<String> initPlaceData(){
        for(int i=0;i<=10;i++){
            placeList.add("八一广场");
        }
        return  placeList;
    }
    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onStop() {
        super.onStop();
    }
}
