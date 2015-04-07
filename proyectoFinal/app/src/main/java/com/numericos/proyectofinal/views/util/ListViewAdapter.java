package com.numericos.proyectofinal.views.util;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.numericos.proyectofinal.R;

/**
 * Created by JU on 10/14/2014.
 */

public class ListViewAdapter extends BaseAdapter {
    // Declare Variables
    Context context;
    String[] titulos;
    String[] subtitulos;
    int[] imagenes;
    LayoutInflater inflater;

    public ListViewAdapter(Context context, String[] titulos, int[] imagenes, String[] subtitulos) {
        this.context = context;
        this.titulos = titulos;
        this.subtitulos = subtitulos;
        this.imagenes = imagenes;
    }

    public ListViewAdapter(Context context, String[] titulos, int[] imagenes) {
        this.context = context;
        this.titulos = titulos;
        this.imagenes = imagenes;
    }

    @Override
    public int getCount() {
        return titulos.length;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    public View getView(int position, View convertView, ViewGroup parent) {

        // Declare Variables
        TextView txtTitle, txtSubtitle;
        ImageView imgImg;

        //http://developer.android.com/intl/es/reference/android/view/LayoutInflater.html
        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View itemView = inflater.inflate(R.layout.list_row, parent, false);

        // Locate the TextViews in listview_item.xml
        txtTitle = (TextView) itemView.findViewById(R.id.list_row_title);
        imgImg = (ImageView) itemView.findViewById(R.id.list_row_image);

        // Capture position and set to the TextViews
        txtTitle.setText(titulos[position]);
        imgImg.setImageResource(imagenes[position]);


        if(this.subtitulos != null &&  this.subtitulos.length > 0){
            txtSubtitle = (TextView) itemView.findViewById(R.id.list_row_subtitle);
            txtSubtitle.setText(subtitulos[position]);
        }

        return itemView;
    }
}
