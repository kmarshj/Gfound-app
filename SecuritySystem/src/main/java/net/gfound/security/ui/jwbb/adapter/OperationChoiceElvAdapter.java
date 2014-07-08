package net.gfound.security.ui.jwbb.adapter;

import android.content.Context;
import android.database.DataSetObserver;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ExpandableListAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import net.gfound.security.R;
import net.gfound.security.ui.jwbb.ManagerOperation;
import net.gfound.security.ui.jwbb.PoliceRegistrationManager;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by czhang on 14-7-8.
 */
public class OperationChoiceElvAdapter implements ExpandableListAdapter {

    private List<PoliceRegistrationManager> mManagerList;
    private Context mContext;

    public OperationChoiceElvAdapter(List<PoliceRegistrationManager> managerList, Context context) {
        mContext = context;
        mManagerList = new ArrayList<PoliceRegistrationManager>();
        mManagerList.addAll(managerList);
    }

    @Override
    public void registerDataSetObserver(DataSetObserver observer) {

    }

    @Override
    public void unregisterDataSetObserver(DataSetObserver observer) {

    }

    @Override
    public int getGroupCount() {
        return mManagerList.size();
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        return 3;
    }

    @Override
    public Object getGroup(int groupPosition) {
        return mManagerList.get(groupPosition);
    }

    @Override
    public Object getChild(int groupPosition, int childPosition) {
        return mManagerList.get(groupPosition).getManagerOperation(childPosition);
    }

    @Override
    public long getGroupId(int groupPosition) {
        return groupPosition;
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return childPosition;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
        GroupViewHolder viewHolder;
        if (convertView == null) {
            convertView = LayoutInflater.from(mContext).inflate(R.layout.view_item_epd_group, null);
            viewHolder = new GroupViewHolder();
            viewHolder.managerTv = (TextView) convertView.findViewById(R.id.tv_vieg_manager);
            viewHolder.arrowIv = (ImageView) convertView.findViewById(R.id.iv_vieg_arrow);
            convertView.setTag(R.id.tv_vieg_manager, viewHolder);
        } else {
            viewHolder = (GroupViewHolder) convertView.getTag(R.id.tv_vieg_manager);
        }

        PoliceRegistrationManager manager = mManagerList.get(groupPosition);
        viewHolder.managerTv.setText(manager.getName());
        return convertView;
    }

    @Override
    public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
        ManagerOperation operation = mManagerList.get(groupPosition).getManagerOperation(childPosition);
        TextView operationTv = new TextView(mContext);
        operationTv.setText(operation.getOperationName());
//        operationTv.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT));
        operationTv.setTextSize(25);
        operationTv.setTextColor(Color.WHITE);
        operationTv.setTag(operation);
        return operationTv;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return true;
    }

    @Override
    public boolean areAllItemsEnabled() {
        return false;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public void onGroupExpanded(int groupPosition) {

    }

    @Override
    public void onGroupCollapsed(int groupPosition) {

    }

    @Override
    public long getCombinedChildId(long groupId, long childId) {
        return 0;
    }

    @Override
    public long getCombinedGroupId(long groupId) {
        return 0;
    }

    static class GroupViewHolder {
        TextView managerTv;
        ImageView arrowIv;
    }
}
