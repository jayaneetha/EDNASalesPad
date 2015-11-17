package com.colombosoft.ednasalespad.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.colombosoft.ednasalespad.R;
import com.colombosoft.ednasalespad.model.Route;

import java.util.List;

/**
 * Created by Jayaneetha on 11/17/15.
 */
public class RouteAdapter extends BaseAdapter {

    private static LayoutInflater layoutInflater = null;
    List<Route> routeList;

    public RouteAdapter(Context context, List<Route> routes) {
        this.routeList = routes;
        layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return routeList.size();
    }

    @Override
    public Object getItem(int position) {
        return routeList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return routeList.get(position).getRouteId();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Holder holder = new Holder();

        View rowView = layoutInflater.inflate(R.layout.spinner_item, null);
        holder.route = (TextView) rowView.findViewById(R.id.textViewSpinner);
        holder.route.setText(routeList.get(position).getRouteName());
        return rowView;
    }

    public class Holder {
        TextView route;
    }
}
