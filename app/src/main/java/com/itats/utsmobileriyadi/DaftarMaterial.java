package com.itats.utsmobileriyadi;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.util.Log;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class DaftarMaterial extends AppCompatActivity {

    RecyclerView mRecyclerView;
    RecyclerView.Adapter mAdapter;
    RecyclerView.LayoutManager mManager;
    ProgressDialog pd;
    ArrayList<ModelData> mItems;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_daftar_material);

        pd = new ProgressDialog(DaftarMaterial.this);
        mRecyclerView = (RecyclerView) findViewById(R.id.list_data);
        mItems = new ArrayList<>();
        mManager = new LinearLayoutManager(DaftarMaterial.this, LinearLayoutManager.VERTICAL, false);
        mRecyclerView.setLayoutManager(mManager);
        mAdapter = new Adapter(DaftarMaterial.this, mItems);
        mRecyclerView.setAdapter(mAdapter);

        loadjson();
    }

    //Proses mengambil data
    private void loadjson() {
        pd.setMessage("Mengambil data");
        pd.setCancelable(false);
        pd.show();

        JsonArrayRequest arrayRequest = new JsonArrayRequest(Request.Method.POST, AppVar.GET_DATA_URL, null, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                pd.cancel();
                Log.d("volley", "Response : " + response.toString());

                for (int i = 0; i < response.length(); i++) {
                    try {
                        JSONObject data = response.getJSONObject(i);
                        ModelData md = new ModelData();
                        md.setNamaProduk(data.getString("nama_produk")); //Memanggil data yang kita buat
                        md.setHargaProduk(data.getString("harga_produk"));

                        mItems.add(md);
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }

                mAdapter.notifyDataSetChanged();
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                pd.cancel();
                Log.d("volley", "Error : " + error.getMessage());
            }
        });

        Controller.getInstance().addToRequestQueue(arrayRequest);
    }
}