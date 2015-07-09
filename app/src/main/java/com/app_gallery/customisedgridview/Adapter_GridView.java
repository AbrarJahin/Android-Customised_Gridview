package com.app_gallery.customisedgridview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.ArrayList;

public class Adapter_GridView extends BaseAdapter
{
    private Context context;
    private ArrayList<Model_GridView> gridViewValueArrray;

    //Constructor
    public Adapter_GridView(Context context, ArrayList<Model_GridView>oldList)
    {
        this.context = context;
        gridViewValueArrray=new ArrayList<Model_GridView>(oldList);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent)
    {
        //if view already exists, no need to create again, just return that
        if (convertView != null)
        {
            return convertView;
        }
        //If not exists, create them
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View gridView;

        gridView = new View(context);
        // get layout from mobile.xml
        gridView = inflater.inflate(R.layout.grid_view_single_item, null);

        //Get the view items
        ImageView imageView = (ImageView) gridView.findViewById(R.id.iv_grid_item);
        TextView tv_label = (TextView) gridView.findViewById(R.id.tv_label);
        TextView tv_price = (TextView) gridView.findViewById(R.id.tv_price);

        // setting the values
        imageView.setImageResource(gridViewValueArrray.get(position).getImage());
        tv_label.setText(gridViewValueArrray.get(position).getName());
        tv_price.setText(Integer.toString(gridViewValueArrray.get(position).getPrice()) );

        return gridView;
    }

    @Override
    public int getCount()
    {
        return gridViewValueArrray.size();
    }

    @Override
    public Object getItem(int position)
    {
        return gridViewValueArrray.get(position);
    }

    @Override
    public long getItemId(int position)
    {
        return 0;
    }
}
