<?php
$hostname_localhost="localhost";
$database_localhost="android";
$username_localhost="root";
$password_localhost="";

$json=array();
    $conexion = mysqli_connect($hostname_localhost,$username_localhost,$password_localhost,$database_localhost);
    $cosulta ="UPDATE tasks Set type = 0 where title = '{$_POST['title']}'";
    $resultado=mysqli_query($conexion,$cosulta);
    $cosulta ="UPDATE tasks Set fk_iduser = 6 where title = '{$_POST['title']}'";
    $resultado=mysqli_query($conexion,$cosulta);
    $json['error']= false;
    mysqli_close($conexion);
    echo json_encode($json);
?>