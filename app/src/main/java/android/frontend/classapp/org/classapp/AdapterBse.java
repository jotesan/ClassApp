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

/**
 * Created by Raúl on 06/10/2016.
 */
public class AdapterBse extends BaseAdapter {

    protected Activity activity;
    protected ArrayList<Classes> persons;

    public AdapterBse(Activity activity, ArrayList<Classes> persons) {
        super();
        this.activity = activity;
        this.persons = persons;
    }

    @Override
    public int getCount() {
        return persons.size();
    }

    public void clear() {
        persons.clear();
    }

    public void addAll(ArrayList<Classes> persons2Add) {
        for (int i = 0; i < persons2Add.size(); i++) {
            persons.add(persons2Add.get(i));
        }
    }

    @Override
    public Object getItem(int i) {
        return persons.get(i);
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
            Classes per = persons.get(i);
            TextView name = (TextView) v.findViewById(R.id.textViewname);
           // name.setText(per.getName());
            TextView rating = (TextView) v.findViewById(R.id.textViewmark);
            //rating.setText(Float.toString(per.getRating()));
            ImageView picture = (ImageView) v.findViewById(R.id.imageViewIcon);
           // picture.setImageResource(per.getPicture());
        }
        return v;
    }
}