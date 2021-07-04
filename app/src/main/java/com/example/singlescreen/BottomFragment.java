package com.example.singlescreen;


import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.singlescreen.Adapter.MyBottomAdapter;
import com.example.singlescreen.model.Selecteditems;

import java.io.Serializable;
import java.lang.reflect.Array;
import java.util.ArrayList;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class BottomFragment extends Fragment {

    RecyclerView recyclerView;
    ArrayList<Selecteditems> selecteddata = new ArrayList<>();
    MyBottomAdapter myBottomAdapter;
    View view;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.bottomfragment, container, false);
        recyclerView = view.findViewById(R.id.bottomrecyclerview);
        myBottomAdapter = new MyBottomAdapter(getContext(), selecteddata);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(myBottomAdapter);
        return view;
    }
}
