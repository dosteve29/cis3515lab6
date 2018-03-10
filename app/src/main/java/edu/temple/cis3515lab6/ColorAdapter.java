package edu.temple.cis3515lab6;

import android.content.Context;
import android.graphics.Color;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.Locale;

/**
 * Created by Steve on 3/10/2018.
 */

public class ColorAdapter extends BaseAdapter {
    String[] colors;
    Context context;

    public ColorAdapter (Context context, String[] colors){
        this.colors = colors;
        this.context = context;
    }

    @Override
    public int getCount() {
        return colors.length;
    }

    @Override
    public Object getItem(int position) {
        return colors[position];
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        TextView textView = new TextView(context);
        if (Locale.getDefault().getLanguage().equals("en")){ //if the language is english
            textView.setText(colors[position]);
            textView.setBackgroundColor(Color.parseColor(colors[position]));
        } else{
            final String[] parseColors = context.getResources().getStringArray(R.array.parseColors);
            textView.setText(colors[position]);
            textView.setBackgroundColor(Color.parseColor(parseColors[position]));
        }
        return textView;
    }
}
