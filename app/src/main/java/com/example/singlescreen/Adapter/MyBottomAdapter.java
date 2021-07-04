package com.example.singlescreen.Adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.singlescreen.R;
import com.example.singlescreen.model.Selecteditems;
import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class MyBottomAdapter  extends RecyclerView.Adapter<MyBottomAdapter.ViewHolder> {

    List<Selecteditems> arrayList;
    private Context context;
    public MyBottomAdapter(Context context,List<Selecteditems> arrayList) {
        this.arrayList = arrayList;
        this.context= context;
    }

    @NonNull
    @Override
    public MyBottomAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater= LayoutInflater.from(parent.getContext());
        View view= layoutInflater.inflate(R.layout.customlayout,parent,false);
        MyBottomAdapter.ViewHolder viewHolder= new MyBottomAdapter.ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyBottomAdapter.ViewHolder holder, int position) {
       if(arrayList.size() != 0) {
           holder.apiname.setText(arrayList.get(position).getAPI());
           holder.apides.setText(arrayList.get(position).getDescription());
       }
    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView apiname,apides;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            apiname= itemView.findViewById(R.id.apiname);
            apides= itemView.findViewById(R.id.apides);
        }
    }
}

