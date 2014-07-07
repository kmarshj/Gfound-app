package net.gfound.security.ui;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import net.gfound.security.R;

public class DZSPFragment extends Fragment {
    public DZSPFragment() {
        super();
        Log.i("TAG", "new DZSPFragment");
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        Log.i("TAG", "DZSPFragment-onCreateView");
        return inflater.inflate(R.layout.fragment_dzsp, container, false);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.i("TAG", "DZSPFragment- onCreate");
    }
}
