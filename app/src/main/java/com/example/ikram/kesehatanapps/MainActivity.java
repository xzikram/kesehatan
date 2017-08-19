package com.example.ikram.kesehatanapps;

import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    public static final String URL = "https://ikramdinata.000webhostapp.com/";
    private ProgressDialog progress;

    @BindView(R.id.edtnoBpjs) EditText edtnoBpjs;
    @BindView(R.id.edtnama) EditText edtnama;
    @BindView(R.id.edttempatLahir) EditText edttempatLahir;
    @BindView(R.id.edttanggalLahir) EditText edttanggalLahir;
    @BindView(R.id.edtalamat) EditText edtalamat;
    @BindView(R.id.edtnoHp) EditText edtnoHp;
    @BindView(R.id.edtberatBadan) EditText edtberatBadan;
    @BindView(R.id.edttinggiBadan) EditText edttinggiBadan;
    @BindView(R.id.edttekananDarah) EditText edttekananDarah;
    @BindView(R.id.edtkadarGula) EditText edtkadarGula;
    @BindView(R.id.edths) EditText edths;

    @OnClick(R.id.btndaftar) void daftar() {
        //progress
        progress = new ProgressDialog(this);
        progress.setCancelable(false);
        progress.setMessage("Loading...");
        progress.show();

        //mengambil data
        String noBpjs = edtnoBpjs.getText().toString();
        String nama = edtnoBpjs.getText().toString();
        String tempatLahir = edtnoBpjs.getText().toString();
        String tanggalLahir = edtnoBpjs.getText().toString();
        String alamat = edtnoBpjs.getText().toString();
        String noHp = edtnoBpjs.getText().toString();
        String beratBadan = edtnoBpjs.getText().toString();
        String tinggiBadan = edtnoBpjs.getText().toString();
        String tekananDarah = edtnoBpjs.getText().toString();
        String kadarGula = edtnoBpjs.getText().toString();
        String hs = edtnoBpjs.getText().toString();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        RegisterAPI api = retrofit.create(RegisterAPI.class);
        Call<Value> call = api.daftar(noBpjs, nama, tempatLahir, tanggalLahir, alamat, noHp, beratBadan, tinggiBadan, tekananDarah, kadarGula, hs);
        call.enqueue(new Callback<Value>() {
            @Override
            public void onResponse(Call<Value> call, Response<Value> response) {
                String value = response.body().getValue();
                String message = response.body().getMessage();
                progress.dismiss();
                if (value.equals("1")){
                    Toast.makeText(MainActivity.this, message, Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(MainActivity.this, message, Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<Value> call, Throwable t) {
                progress.dismiss();
                Toast.makeText(MainActivity.this, "Jaringan Error", Toast.LENGTH_SHORT).show();
            }
        });


    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }
}
