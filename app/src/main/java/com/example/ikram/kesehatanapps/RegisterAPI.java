package com.example.ikram.kesehatanapps;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/**
 * Created by ikram on 20/08/2017.
 */

public interface RegisterAPI {
    @FormUrlEncoded
    @POST("insert.php")
    Call<Value> daftar(@Field("noBpjs") String noBpjs,
                       @Field("nama") String nama,
                       @Field("tempatLahir") String tempatLahir,
                       @Field("tanggalLahir") String tanggalLahir,
                       @Field("alamat") String alamat,
                       @Field("noHp") String noHp,
                       @Field("beratBadan") String beratBadan,
                       @Field("tinggiBadan") String tinggiBadan,
                       @Field("tekananDarah") String tekananDarah,
                       @Field("kadarGula") String kadarGula,
                       @Field("hs") String hs);
}
