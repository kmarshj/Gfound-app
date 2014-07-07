package net.gfound.security.ui;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import net.gfound.security.R;

/**
 *
 */
public class JWBBFragment extends Fragment {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        Log.i("TAG", "JWBBFragment-onCreate");
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        Log.i("TAG", "JWBBFragment-onCreateView");
        return inflater.inflate(R.layout.fragment_jwbb, container, false);
    }


}
