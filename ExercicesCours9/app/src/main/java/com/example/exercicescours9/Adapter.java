package com.example.exercicescours9;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;
import com.example.exercicescours9.transfer.objComplexe;

import java.util.ArrayList;
import java.util.List;

public class Adapter extends RecyclerView.Adapter<Adapter.MyViewHolder> {
    public ArrayList<Object> list;

    // Provide a reference to the views for each data item
    // Complex data items may need more than one view per item, and
    // you provide access to all the views for a data item in a view holder
    public static class MyViewHolder extends RecyclerView.ViewHolder {
        // each data item is just a string in this case
        public TextView tv1;
        public TextView tv2;
        public TextView tv3;
        public MyViewHolder(LinearLayout v) {
            super(v);
            tv1 = v.findViewById(R.id.champ1);
            tv2 = v.findViewById(R.id.champ2);
            tv3 = v.findViewById(R.id.champ3);
        }
    }

    // Provide a suitable constructor (depends on the kind of dataset)
    public Adapter(MainActivity.ValueType valueType) {
        list = new ArrayList<>();
        m_valueType = valueType;
    }
    public MainActivity.ValueType m_valueType;
    // Create new views (invoked by the layout manager)
    @Override
    public Adapter.MyViewHolder onCreateViewHolder(ViewGroup parent,
                                                   int viewType) {
        // create a new view
        LinearLayout v = (LinearLayout) LayoutInflater.from(parent.getContext())
                .inflate(R.layout.obj_item, parent, false);
        MyViewHolder vh = new MyViewHolder(v);
        Log.i("DEBOGAGE", "appel a onCreateViewHolder");
        return vh;
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        // - get element from your dataset at this position
        // - replace the contents of the view with that element
        if(m_valueType == MainActivity.ValueType.Long)
        {
            Long objCourant = (Long) list.get(position);
            holder.tv1.setText(Long.toString(objCourant));
            holder.tv2.setText(Long.toString(objCourant));
            holder.tv3.setText(Long.toString(objCourant));
            Log.i("DEBOGAGE", "appel a onBindViewHolder " + position);
        }
        else if (m_valueType == MainActivity.ValueType.ObjComplexe) {
            objComplexe objCourant = (objComplexe) list.get(position);
            holder.tv1.setText(Long.toString(objCourant.a));
            holder.tv2.setText(objCourant.b);
            holder.tv3.setText(Integer.toString(objCourant.c.size()));
            Log.i("DEBOGAGE", "appel a onBindViewHolder " + position);
        }
    }

    // renvoie la taille de la liste
    @Override
    public int getItemCount() {
        return list.size();
    }
}
