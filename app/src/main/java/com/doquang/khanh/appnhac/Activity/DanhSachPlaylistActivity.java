package com.doquang.khanh.appnhac.Activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;

import com.doquang.khanh.appnhac.Adapter.DanhSachPlaylistAdapter;
import com.doquang.khanh.appnhac.Model.PlayList;
import com.doquang.khanh.appnhac.R;
import com.doquang.khanh.appnhac.Service.APIService;
import com.doquang.khanh.appnhac.Service.DataService;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DanhSachPlaylistActivity extends AppCompatActivity {

    Toolbar toolbar;
    RecyclerView recyclerViewDanhSachPlaylist;
    DanhSachPlaylistAdapter danhSachPlaylistAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_danh_sach_playlist);
        anhXa();
        init();
        getData();

    }

    private void getData() {
        DataService dataService = APIService.getService();
        Call<List<PlayList>> callBack = dataService.getDanhSachPlaylist();
        callBack.enqueue(new Callback<List<PlayList>>() {
            @Override
            public void onResponse(Call<List<PlayList>> call, Response<List<PlayList>> response) {
                ArrayList<PlayList> mangPlaylist = (ArrayList<PlayList>) response.body();
                danhSachPlaylistAdapter = new DanhSachPlaylistAdapter(DanhSachPlaylistActivity.this,mangPlaylist);
                recyclerViewDanhSachPlaylist.setLayoutManager(new GridLayoutManager(DanhSachPlaylistActivity.this,2));
                recyclerViewDanhSachPlaylist.setAdapter(danhSachPlaylistAdapter);
            }

            @Override
            public void onFailure(Call<List<PlayList>> call, Throwable t) {

            }
        });
}

    private void init() {
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("PlayList");
        toolbar.setTitleTextColor(getResources().getColor(R.color.mautim));
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    private void anhXa() {
        toolbar = findViewById(R.id.toolbardanhsachplaylist);
        recyclerViewDanhSachPlaylist = findViewById(R.id.recycleviewdanhsachplaylist);

    }
}
