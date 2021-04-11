package com.example.ayamku;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;
    @BindView(R.id.fab)
    FloatingActionButton fab;

    List<DataModel> listDataModel = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        // TODO 1 : buat nge get data from db(database lokal)
        listDataModel = MyApp.db.userDao().getAll();

        // TODO 2 : ini script buat mengambil data yg di hubungkan dengan main Adapter
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        MainAdapter adapter = new MainAdapter(this, listDataModel);
        recyclerView.setAdapter(adapter);

    }

    @OnClick(R.id.fab)
    public void onViewClicked() {
        startActivity(new Intent(this, AddData.class));

    }
}