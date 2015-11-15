package com.colombosoft.ednasalespad.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.colombosoft.ednasalespad.R;
import com.colombosoft.ednasalespad.model.DealerClass;

import java.util.List;

/**
 * Created by Admin on 10/13/15.
 */
public class DealerClassAdapter extends BaseAdapter {

    private static LayoutInflater layoutInflater = null;
    List<DealerClass> DealerClassList;

    public DealerClassAdapter(Context context, List<DealerClass> DealerClass) {
        this.DealerClassList = DealerClass;
        layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

    }

    @Override
    public int getCount() {
        return DealerClassList.size();
    }

    @Override
    public Object getItem(int position) {
        return DealerClassList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return DealerClassList.get(position).getDealerClassId();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Holder holder = new Holder();

        View rowView = layoutInflater.inflate(R.layout.spinner_item, null);
        holder.dealer_class = (TextView) rowView.findViewById(R.id.textViewSpinner);
        holder.dealer_class.setText(DealerClassList.get(position).getDealerClassName());
        return rowView;
    }

    public class Holder {
        TextView dealer_class;
    }
}
