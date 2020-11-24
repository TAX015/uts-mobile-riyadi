package com.itats.utsmobileriyadi;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    //Mendefinisikan view
    private EditText editTextUsername, editTextPassword;
    private Context context;
    Button buttonLogin;
    private ProgressDialog pDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        context = MainActivity.this;

        //Inisialisasi View
        pDialog = new ProgressDialog(context);
        editTextUsername = (EditText) findViewById(R.id.edt_username);
        editTextPassword = (EditText) findViewById(R.id.edt_password);
        buttonLogin = (Button) findViewById(R.id.btn_login);

        buttonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                login();
            }
        });
    }

    private void login() {

        final String username = editTextUsername.getText().toString().trim();
        final String password = editTextPassword.getText().toString().trim();
        pDialog.setMessage("Proses Login...");
        showDialog();

        //Volley StringRequest
        StringRequest stringRequest = new StringRequest(Request.Method.POST, AppVar.LOGIN_URL, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

                if (response.contains(AppVar.LOGIN_SUCCESS)) {
                    hideDialog();
                    gotoBerandaActivity();
                } else {
                    hideDialog();
                    Toast.makeText(context, "Username atau password salah", Toast.LENGTH_LONG).show();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                hideDialog();
                Toast.makeText(context, "Server tidak dapat dijangkau", Toast.LENGTH_LONG).show();
            }
        }) {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> params = new HashMap<>();
                //Menambah parameter ke request
                params.put(AppVar.KEY_USERNAME, username);
                params.put(AppVar.KEY_PASSWORD, password);

                return params;
            }
        };
        //Menambah string request ke queue
        Volley.newRequestQueue(this).add(stringRequest);
    }

    private void gotoBerandaActivity() {
        Intent intent = new Intent(context, Beranda.class);
        startActivity(intent);
        finish();
    }

    private void showDialog() {
        if (!pDialog.isShowing()) {
            pDialog.show();
        }
    }

    private void hideDialog() {
        if (pDialog.isShowing()) {
            pDialog.dismiss();
        }
    }
}