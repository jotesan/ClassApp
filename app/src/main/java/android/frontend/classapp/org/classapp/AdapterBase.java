package android.frontend.classapp.org.classapp;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;


public class AdapterBase extends BaseAdapter {

    protected Activity activity;
    protected ArrayList<Classes> clases;

    public AdapterBase(Activity activity, ArrayList<Classes> clases) {
        super();
        this.activity = activity;
        this.clases = clases;
    }

    @Override
    public int getCount() {
        return clases.size();
    }

    public void clear() {
        clases.clear();
    }

    public void addAll(ArrayList<Classes> persons2Add) {
        for (int i = 0; i < persons2Add.size(); i++) {
            clases.add(persons2Add.get(i));
        }
    }

    @Override
    public Object getItem(int i) {
        return clases.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        View v = view;
        int icons[] = {};
        if (view == null) {
            LayoutInflater inflater = (LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            v = inflater.inflate(R.layout.item_list, null);
            Classes clase = clases.get(i);
            TextView name = (TextView) v.findViewById(R.id.textViewname);
           name.setText(clase.getTitulo());
            TextView details = (TextView) v.findViewById(R.id.textViewDetails);
            details.setText(clase.getDescripion());
            ImageView picture = (ImageView) v.findViewById(R.id.imageViewIcon);
           picture.setImageResource(clase.getImagen());
        }
        return v;
    }
}