<?php
	require_once('koneksi.php');

	if ($_SERVER['REQUEST_METHOD'] == 'POST') {
		//Get values
		$username = $_POST['username'];
		$password = $_POST['password'];

		//Create sql query
		$sql = "SELECT * FROM users WHERE username='$username' AND password='$password'";

		//Execute query
		$result = mysqli_query($con, $sql);

		//Fetch result
		$check = mysqli_fetch_array($result);

		if (isset($check)) {
			echo "success";
		} else {
			echo "failure";
		}

		mysqli_close($con);
	}
?>