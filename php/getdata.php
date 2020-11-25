<?php

	include_once('koneksi.php');

	$query = "SELECT * FROM material";
	$sql = mysqli_query($con, $query);
	$arraydata = array();

	while ($data = mysqli_fetch_array($sql)) {
		$arraydata[] = $data;
	}

	echo json_encode($arraydata);
?>