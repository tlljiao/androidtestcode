package com.example.cjiao.listviewtest;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by cjiao on 4/8/15.
 */
public class CartoonAdapter extends ArrayAdapter<Cartoon> {

    private int resrouceId;

    public CartoonAdapter(Context context, int resource, List<Cartoon> objects) {
        super(context, resource, objects);
        resrouceId = resource;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent){
        Cartoon cartoon = getItem(position);

        View view = LayoutInflater.from(getContext()).inflate(resrouceId, null);
        ImageView cartoonImage = (ImageView) view.findViewById(R.id.cartoon_image);
        TextView cartoonName = (TextView) view.findViewById(R.id.cartoon_name);
        cartoonImage.setImageResource(cartoon.getImageId());
        cartoonName.setText(cartoon.getName());

        return view;
    }
}
