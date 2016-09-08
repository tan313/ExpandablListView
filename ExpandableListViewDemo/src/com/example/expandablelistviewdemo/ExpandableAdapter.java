package com.example.expandablelistviewdemo;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class ExpandableAdapter extends BaseExpandableListAdapter {

	int[] logos = new int[]{
            R.drawable.word,
            R.drawable.excel,
            R.drawable.email,
            R.drawable.ppt
    };
    private String[] armTypes = new String[]{
            "WORD", "EXCEL", "EMAIL", "PPT"
    };
    private String[][] arms = new String[][]{
            {"文档编辑", "文档排版", "文档处理", "文档打印"},
            {"表格编辑", "表格排版", "表格处理", "表格打印"},
            {"收发邮件", "管理邮箱", "登录登出", "注册绑定"},
            {"演示编辑", "演示排版", "演示处理", "演示打印"},
    };
    
    LayoutInflater mLayoutInflater;
    
    public ExpandableAdapter(Context mContext) {
		mLayoutInflater = LayoutInflater.from(mContext);
	}
    
	@Override
	public int getGroupCount() {
		//返回类别长度
		return armTypes.length;
	}

	@Override
	public int getChildrenCount(int groupPosition) {
		return arms[groupPosition].length;
	}

	@Override
	public Object getGroup(int groupPosition) {
		return armTypes[groupPosition];
	}

	@Override
	public Object getChild(int groupPosition, int childPosition) {
		return arms[groupPosition][childPosition];
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
		return true;
	}

	@Override
	public View getGroupView(int groupPosition, boolean isExpanded,
			View convertView, ViewGroup parent) {
		convertView = mLayoutInflater.inflate(R.layout.item_group, null);
		ImageView logo = (ImageView) convertView.findViewById(R.id.id_group_logo);
		logo.setImageResource(logos[groupPosition]);
		
		TextView text = (TextView) convertView.findViewById(R.id.id_group_tv);
		text.setText(getGroup(groupPosition).toString());
		
		return convertView;
	}

	@Override
	public View getChildView(int groupPosition, int childPosition,boolean isLastChild, View convertView, ViewGroup parent) {
		convertView = mLayoutInflater.inflate(R.layout.item_sub, null);
		TextView tv = (TextView) convertView.findViewById(R.id.id_sub_tv);
		tv.setText(getChild(groupPosition, childPosition).toString());
        return convertView;
	}

	@Override
	public boolean isChildSelectable(int groupPosition, int childPosition) {
		return true;
	}

}
