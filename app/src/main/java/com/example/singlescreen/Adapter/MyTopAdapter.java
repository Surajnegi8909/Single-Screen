package com.example.singlescreen.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;
import com.example.singlescreen.R;
import com.example.singlescreen.model.APIData;
import java.util.ArrayList;
import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

public class MyTopAdapter extends RecyclerView.Adapter<MyTopAdapter.ViewHolder>  {

    ArrayList<APIData> arrayList;
    int Position;
    private final OnItemClickListener listener;

    public interface OnItemClickListener {
        void onItemClick(String name, String des);
    }
    public MyTopAdapter(ArrayList<APIData> arrayList, OnItemClickListener listener) {
        this.arrayList = arrayList;
        this.listener= listener;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView apiname,apides;
        CardView cardView;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            apiname= itemView.findViewById(R.id.apiname);
            apides= itemView.findViewById(R.id.apides);
            cardView= itemView.findViewById(R.id.cardview);

        }
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull  ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater= LayoutInflater.from(parent.getContext());
        View view= layoutInflater.inflate(R.layout.customlayout,parent,false);
        ViewHolder viewHolder= new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyTopAdapter.ViewHolder holder, int position) {

            holder.apiname.setText(arrayList.get(position).getAPI());
            holder.apides.setText(arrayList.get(position).getDescription());
                Position= position;
            holder.cardView.setOnClickListener(new View.OnClickListener() {
                @Override public void onClick(View v) {
                    listener.onItemClick(arrayList.get(position).getAPI(),arrayList.get(position).getDescription());
                                Toast.makeText(v.getContext(),"click on item: "+arrayList.get(position).getAPI()+"/n"+arrayList.get(position).getDescription(),Toast.LENGTH_LONG).show();
                }
            });
    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }
}
