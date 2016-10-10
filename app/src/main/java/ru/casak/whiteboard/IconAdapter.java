package ru.casak.whiteboard;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;

public class IconAdapter extends ArrayAdapter<Integer> {
    Integer[] images;

    public IconAdapter(Context context, Integer[] images) {
        super(context, android.R.layout.simple_spinner_item, images);
        this.images = images;
    }

    @Override
    public View getDropDownView(int position, View convertView, ViewGroup parent) {
        return getIconForPosition(position);
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        return getIconForPosition(position);
    }

    private View getIconForPosition(int position){
        ImageView icon = new ImageView(getContext());
        icon.setBackgroundResource(images[position]);
        icon.setLayoutParams(new ViewGroup.LayoutParams(60, 60));
        return icon;
    }
}