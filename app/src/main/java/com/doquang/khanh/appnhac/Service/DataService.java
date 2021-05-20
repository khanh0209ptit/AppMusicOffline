package com.doquang.khanh.appnhac.Service;

import com.doquang.khanh.appnhac.Model.Album;
import com.doquang.khanh.appnhac.Model.BaiHat;
import com.doquang.khanh.appnhac.Model.ChuDe;
import com.doquang.khanh.appnhac.Model.PlayList;
import com.doquang.khanh.appnhac.Model.QuangCao;
import com.doquang.khanh.appnhac.Model.TheLoai;
import com.doquang.khanh.appnhac.Model.TheLoaiTrongNgay;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface DataService {

    @GET("songbanner.php")
    Call<List<QuangCao>> getDataBanner();

    @GET("playlistforcurrentday.php")
    Call<List<PlayList>> getPlayListCurrentDay();

    @GET("chudevatheloaitrongngay.php")
    Call<TheLoaiTrongNgay> getCategoryMusic();

    @GET("album.php")
    Call<List<Album>> getAlbumHot();

    @GET("baihatyeuthich.php")
    Call<List<BaiHat>> getBaiHatHot();

    @FormUrlEncoded
    @POST("danhsachbaihat.php")
    Call<List<BaiHat>> getDanhSachBaiHatTheoQuangCao(@Field("idquangcao") String idQuangCao);

    @FormUrlEncoded
    @POST("danhsachbaihat.php")
    Call<List<BaiHat>> getDanhSachBaiHatTheoPlayList(@Field("idplaylist") String idPlayList);


    @GET("danhsachcacplaylist.php")
    Call<List<PlayList>> getDanhSachPlaylist();

    @FormUrlEncoded
    @POST("danhsachbaihat.php")
    Call<List<BaiHat>> getDanhSachBaiHatTheoTheLoai(@Field("idtheloai") String idTheLoai);

    @GET("tatcachude.php")
    Call<List<ChuDe>> getAllChuDe();

    @FormUrlEncoded
    @POST("theloaitheochude.php")
    Call<List<TheLoai>> getTheLoaiTheoChuDe(@Field("idchude") String idChuDe);

    @GET("tatcaalbum.php")
    Call<List<Album>> getAlbum();

    @FormUrlEncoded
    @POST("danhsachbaihat.php")
    Call<List<BaiHat>> getBaiHatTheoAlbum(@Field("idalbum") String idAlbum);

    @FormUrlEncoded
    @POST("updateluotthich.php")
    Call<String> updateLuotThich(@Field("luotthich") String luotthich, @Field("idbaihat") String idbaihat);

    @FormUrlEncoded
    @POST("timkiembaihat.php")
    Call<List<BaiHat>> getSearchBaiHat(@Field("tukhoa") String tuKhoa);

}
