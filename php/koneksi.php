<?php

	//Mendefinisikan konstanta
	define('HOST', 'localhost');
	define('USER', 'root');
	define('PASS', '');
	define('DB', 'uts_mobile');

	//Membuat koneksi dengan database
	$con = mysqli_connect(HOST, USER, PASS, DB) or die('Koneksi gagal');
?>