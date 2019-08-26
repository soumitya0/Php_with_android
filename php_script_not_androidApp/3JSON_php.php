<?php
// insert  the data into mysql database using xampp
$host="127.0.0.1";
$user="root";
$DBpassword="";
$database="demo";
$connect=mysqli_connect($host,$user,$DBpassword,$database);
if(mysqli_connect_errno())
{
	die("error i n connection ". mysqli_connect_errno());
	return;
}
$username=$_GET['username'];  // user input in brower because GET method 
$password=$_GET['password'];  // user input in brower because GET method 

//sql querry to insert database 
$querry=" insert into login(username,password)values('". $username ."','".$password."')";

$result=mysqli_query($connect,$querry);

if (!$result) 
{
	$info="{'msg':'connot insetr'}";	
}else{
	$info="{'msg':'data is insetr '}";
}
print(json_encode($info));
?>