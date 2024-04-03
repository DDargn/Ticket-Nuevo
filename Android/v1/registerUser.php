<?php
require_once '../includes/DbOperations.php';
$response=array();


if($_SERVER['REQUEST_METHOD']=='POST'){
    if(isset($_POST['username']) and isset($_POST['email']) and isset($_POST['password'])){
        //operate de data

        $db = new DbOperation();
        $result = $db->createUser(   $_POST['username'],
                                    $_POST['password'],
                                    $_POST['email']
                                );
        if($result==1){
            $response['error']= false;
            $response['message']="User registered successfuly";
        }elseif($result==2){
            $response['error']= true;
            $response['message']="Unespected error";
        }elseif($result==0){
            $response['error']= true;
            $response['message']="It seems you are already registered";
        }
    }else{
        $response['error'] = true;
        $response['message']="Requiered fields are missing";
    }
}else{
    $response['error']=true;
    $response['message']="Invalid Request";
}

echo json_encode($response);