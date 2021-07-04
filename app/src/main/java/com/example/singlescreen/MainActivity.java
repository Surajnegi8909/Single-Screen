package com.example.singlescreen;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.graphics.Color;
import android.os.Bundle;
import com.example.singlescreen.model.Selecteditems;

public class MainActivity extends AppCompatActivity implements TopFragment.SendMessage {

    BottomFragment b;
    TopFragment t;
    FragmentTransaction transaction;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        b = new BottomFragment();
        t= new TopFragment();
        FragmentManager manager=getSupportFragmentManager();
        transaction=manager.beginTransaction();
        transaction.replace(R.id.top_fragment, t, "Frag_Top");
        transaction.replace(R.id.bottom_fragment, b, "Frag_Bottom");
        transaction.commit();
    }
    @Override
    public void sendData(String name, String des) {
        b.selecteddata.add(new Selecteditems(name,des));
        b.recyclerView.setBackgroundColor(Color.parseColor("#255eba"));
        b.myBottomAdapter.notifyDataSetChanged();
    }
}