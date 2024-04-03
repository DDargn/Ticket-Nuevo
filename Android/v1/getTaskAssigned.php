<?php
$hostname_localhost="localhost";
$database_localhost="android";
$username_localhost="root";
$password_localhost="";

$json=array();
    $conexion = mysqli_connect($hostname_localhost,$username_localhost,$password_localhost,$database_localhost);
    $cosulta ="select fk_iduser, title, text from tasks where fk_iduser = {$_POST['fk_iduser']} and type = 1";
    $resultado=mysqli_query($conexion,$cosulta);
    while($registro=mysqli_fetch_assoc($resultado)){
        $json['Tasks'][]=$registro;
    }
    mysqli_close($conexion);
    echo json_encode($json);

?>