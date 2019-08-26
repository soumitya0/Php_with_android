

<?php
//user input 

$username=$_GET['username'];  // user input in brower because GET method 

$password=$_GET['password'];  // user input in brower because GET method 


$info="{'username':' ".  $username ." ' , 'password':'". $password ."'}";




print(json_encode($info));


 ?>