<!DOCTYPE html>
<!--
To change this license header, choose License Headers in Project Properties.
To change this template file, choose Tools | Templates
and open the template in the editor.
-->


<html>
    <head>
        <meta charset="UTF-8">
        <title></title>
        <style>
            table, th, td {
              border: 1px solid black;
              border-collapse: collapse;
            }
            table{
                width: 50%;
            }
        </style>
    </head>
    <body>
        <?php
        $conn = mysqli_connect("localhost:3307", "root", "root", "KSATourism"); 
        $error = mysqli_error($conn); 
        if($error!= null){
            die($error);
        }
        echo "<table>";
        echo "<tr><td>City Name</td><td>Region</td></tr>";
        $sql = "SELECT * FROM city";
        $result = mysqli_query($conn, $sql); 
        if($result){
            while ($row = mysqli_fetch_assoc($result)){
                echo '<tr><td><a href ="cityStats.php?id='.$row["cityID"].'">'.$row["name"].'</td><td>'.$row["region"].'</td></tr>';
            }
        }
        echo "</table>";
        ?>
    </body>
</html>
