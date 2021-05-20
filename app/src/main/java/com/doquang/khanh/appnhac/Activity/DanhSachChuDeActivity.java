package com.doquang.khanh.appnhac.Activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;

import com.doquang.khanh.appnhac.Adapter.DanhSachChuDeAdapter;
import com.doquang.khanh.appnhac.Model.ChuDe;
import com.doquang.khanh.appnhac.R;
import com.doquang.khanh.appnhac.Service.APIService;
import com.doquang.khanh.appnhac.Service.DataService;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DanhSachChuDeActivity extends AppCompatActivity {

    RecyclerView recyclerViewChuDe;
    Toolbar toolbarChuDe;
    DanhSachChuDeAdapter danhSachChuDeAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_danh_sach_chu_de);
        init();
        getData();
    }

    private void getData() {
        DataService dataService = APIService.getService();
        Call<List<ChuDe>> callBack = dataService.getAllChuDe();
        callBack.enqueue(new Callback<List<ChuDe>>() {
            @Override
            public void onResponse(Call<List<ChuDe>> call, Response<List<ChuDe>> response) {
                ArrayList<ChuDe> mangChuDe = (ArrayList<ChuDe>) response.body();
                danhSachChuDeAdapter = new DanhSachChuDeAdapter(DanhSachChuDeActivity.this,mangChuDe);
                recyclerViewChuDe.setLayoutManager(new GridLayoutManager(DanhSachChuDeActivity.this,1));
                recyclerViewChuDe.setAdapter(danhSachChuDeAdapter);
            }

            @Override
            public void onFailure(Call<List<ChuDe>> call, Throwable t) {

            }
        });
    }

    private void init() {
        recyclerViewChuDe = findViewById(R.id.recycleviewchude);
        toolbarChuDe = findViewById(R.id.toolbarchude);
        setSupportActionBar(toolbarChuDe);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Tất Cả Chủ Đề");
        toolbarChuDe.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
