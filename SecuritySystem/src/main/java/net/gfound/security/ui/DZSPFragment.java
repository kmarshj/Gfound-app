package net.gfound.security.ui;

import android.content.Intent;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import net.gfound.security.R;

public class DZSPFragment extends Fragment implements View.OnClickListener{
    private TextView jqdwText;
    private TextView zbjlcxText;
    private TextView dzspldText;
    private TextView yalczsText;
    public DZSPFragment() {
        super();
        Log.i("TAG", "new DZSPFragment");
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        Log.i("TAG", "DZSPFragment-onCreateView");
        View view=inflater.inflate(R.layout.fragment_dzsp,container,false);
        jqdwText=(TextView)view.findViewById(R.id.text_jqdw);
        zbjlcxText=(TextView)view.findViewById(R.id.text_zbjlcx);
        dzspldText=(TextView)view.findViewById(R.id.text_dzspld);
        yalczsText=(TextView)view.findViewById(R.id.text_yalczs);
        jqdwText.setOnClickListener(DZSPFragment.this);
        zbjlcxText.setOnClickListener(DZSPFragment.this);
        dzspldText.setOnClickListener(DZSPFragment.this);
        yalczsText.setOnClickListener(DZSPFragment.this);


        return view;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.i("TAG", "DZSPFragment- onCreate");
    }

    @Override
    public void onClick(View v) {
        int id=v.getId();
        switch (id){
            case R.id.text_jqdw:
                //Toast.makeText(DZSPFragment.this.getActivity(),"FFFFFFFFFFFFFF",Toast.LENGTH_LONG).show();
                Intent intent=new Intent(DZSPFragment.this.getActivity(),DzspSearchActivity.class);
                startActivity(intent);
                break;
            case R.id.text_zbjlcx:
                break;
            case R.id.text_dzspld:
                break;
            case R.id.text_yalczs:
                break;
        }

    }
}
