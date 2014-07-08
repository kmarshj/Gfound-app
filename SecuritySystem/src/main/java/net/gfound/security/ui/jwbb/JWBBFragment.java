package net.gfound.security.ui.jwbb;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ExpandableListView;
import android.widget.LinearLayout;

import net.gfound.security.R;
import net.gfound.security.ui.jwbb.adapter.OperationChoiceElvAdapter;

import java.util.ArrayList;
import java.util.List;
import java.util.zip.Inflater;

/**
 *
 */
public class JWBBFragment extends Fragment {

    private List<PoliceRegistrationManager> policeRmList;
    private ExpandableListView operationChoiceElv;
    private LinearLayout leftInfoLayout;
    private LinearLayout rightInfoLayout;

    private Context mContext;

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        mContext = activity;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        Log.i("TAG", "JWBBFragment-onCreate");
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        Log.i("TAG", "JWBBFragment-onCreateView");
        initData();
        View v = inflater.inflate(R.layout.fragment_jwbb, container, false);
        initUi(v);
        return v;
    }

    private void initData() {
        policeRmList = new ArrayList<PoliceRegistrationManager>();
        policeRmList.add(new PoliceRegistrationManager(Constants.ManagerPoliceType.XUNDUAN, "巡段警力报备管理"));
        policeRmList.add(new PoliceRegistrationManager(Constants.ManagerPoliceType.KADIAN, "卡点警力报备系统"));
        policeRmList.add(new PoliceRegistrationManager(Constants.ManagerPoliceType.CHUJING, "处警警力报备系统"));
    }

    private void initUi(View v) {
        operationChoiceElv = (ExpandableListView) v.findViewById(R.id.elv_fj_operation);
        leftInfoLayout = (LinearLayout) v.findViewById(R.id.ln_fj_leftInfo);
        rightInfoLayout = (LinearLayout) v.findViewById(R.id.ln_fj_rightInfo);

        initEpdView();
    }

    private void initEpdView() {
        final OperationChoiceElvAdapter adapter = new OperationChoiceElvAdapter(policeRmList, mContext);
        operationChoiceElv.setAdapter(adapter);

        operationChoiceElv.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
            @Override
            public boolean onChildClick(ExpandableListView parent, View v, int groupPosition, int childPosition, long id) {
                leftInfoLayout.removeAllViews();
                rightInfoLayout.removeAllViews();
                leftInfoLayout.addView(getView((ManagerOperation) v.getTag()));
                return true;
            }
        });

        operationChoiceElv.setOnGroupClickListener(new ExpandableListView.OnGroupClickListener() {
            @Override
            public boolean onGroupClick(ExpandableListView parent, View v, int groupPosition, long id) {
                leftInfoLayout.removeAllViews();
                rightInfoLayout.removeAllViews();
                return false;
            }
        });

        operationChoiceElv.setOnGroupExpandListener(new ExpandableListView.OnGroupExpandListener() {
            @Override
            public void onGroupExpand(int groupPosition) {
                for (int i = 0; i < adapter.getGroupCount(); i++) {
                    if (groupPosition != i) {
                        operationChoiceElv.collapseGroup(i);
                    }
                }
            }
        });

    }

    private View getView(ManagerOperation operation) {
        switch (operation.getOperationType()) {
            case ADD:
                View v = LayoutInflater.from(mContext).inflate(R.layout.view_jwbb_operation_add, null);
                v.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT));
                return v;
            case QUERY:
                return LayoutInflater.from(mContext).inflate(R.layout.view_jwbb_operation_query, null);
            case MODIFY:
                return LayoutInflater.from(mContext).inflate(R.layout.view_jwbb_operation_modify, null);
            default:
                return null;
        }
    }

}
