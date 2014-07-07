package net.gfound.security.ui;



import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import net.gfound.security.R;

/**
 * A simple {@link Fragment} subclass.
 *
 */
public class SPJKFragment extends Fragment {


    public SPJKFragment() {
        // Required empty public constructor
        Log.i("TAG", "new JWBBFragment");
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        Log.i("TAG", "JWBBFragment-onCreateView");
        return inflater.inflate(R.layout.fragment_spjk, container, false);
    }


}
