<?php

    $conn = mysqli_connect("localhost:3307", "root", "root", "ksatourism"); 
    $error = mysqli_error($conn); 
    if($error!= null){
        die($error);
    }
    
    $json = array();
    
    if(isset($_POST['cityID']) && isset($_POST['topAttraction']) && isset($_POST['numberOfTourists']) && isset($_POST['month'])){

        $cityID = $_POST['cityID'];
        $id =(int) $cityID;
        $topAttraction= $_POST['topAttraction'];
        $numberOfTourists = $_POST['numberOfTourists'];
        $num = (int) $numberOfTourists;
        $month = $_POST['month'];
        
        
        $sql3 = "INSERT INTO tourismstatistics (cityID, month, numberOfTourists, topAttraction) VALUES ('$cityID', '$month', '$numberOfTourists', '$topAttraction')";
        $result3 = mysqli_query($conn, $sql3); 
        if($result3){
            $json[] = "the insert was successful";
        }

//        $sqlX = "INSERT INTO tourismstatistics ()";
    }
    $j = json_encode($json);
    echo $j;
   
?>

