package com.itats.utsmobileriyadi;

public class AppVar {

    //Alamat URL
    public static final String LOGIN_URL = "http://192.168.1.11/Android/uts_mobile/login.php";
    public static final String GET_DATA_URL = "http://192.168.1.11/Android/uts_mobile/getdata.php";

    //Key yang didefinisikan pada $_POST['key'] di login.php
    public static final String KEY_USERNAME = "username";
    public static final String KEY_PASSWORD = "password";

    //Jika respon server sama dengan nilai ini, berarti login berhasil
    public static final String LOGIN_SUCCESS = "success";
}
