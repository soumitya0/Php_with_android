<?php

// display the inserted data into web 

$host="127.0.0.1";
$user="root";
$DBpassword="";
$database="demo";
$connect=mysqli_connect($host,$user,$DBpassword,$database);
if(mysqli_connect_errno())
{
	die("error in connection ". mysqli_connect_errno());
	return;
}
//$username=$_GET['username'];  // user input in brower because GET method 
//$password=$_GET['password'];  // user input in brower because GET method 

$querry="select * from login "; 

$result=mysqli_query($connect,$querry);

if (!$result) 
{
	$info="{'msg':'connot insetr'}";	
}else{
	// display the database in web
	while($row=mysqli_fetch_assoc($result))
	{
		 $output[]=$row;

	}$info=$output ;

}
print(json_encode($info));

mysql_free_result($result);
mysqli_close($connect);

?>