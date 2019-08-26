<?php

// display the inserted data into web 

$host="127.0.0.1";
$user="root";
$DBpassword="";
$database="sysadmin";
$connect=mysqli_connect($host,$user,$DBpassword,$database);
if(mysqli_connect_errno())
{
	die("error in connection ". mysqli_connect_errno());
	
}
$username=$_GET['username'];  // user input in brower because GET method 
$password=$_GET['password'];  // user input in brower because GET method 

//$querry="SELECT * FROM login WHERE id='". $_GET['id']."'"; 



$querry="SELECT * FROM login WHERE username='$username' and password='$password'"; 
       //SELECT * FROM login WHERE username='soumitya';
	   //SELECT * FROM login WHERE username='kandar' and password='854778';	
//SELECT * FROM next WHERE id=$id"
$result=mysqli_query($connect,$querry);

if (!$result) 
{
	die("erroe in querry");
}
	// display the database in web
$output=array();

	while($row=mysqli_fetch_assoc($result))
	{
		 $output[]=$row;

	}
	
	
	if($output)
	{
		print(json_encode($output));
	}
	else
	{
	print("{'msg':'user not found'}");
	}

mysqli_close($connect);

?>