<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title></title>
        <style>
            table, th, td {
              border: 1px solid black;
              border-collapse: collapse;
            }
        </style>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
        <script>
            function send(){
                var m = $("#month").val();
                var n = $("#numberOfTourists").val();
                var t = $("#topAttraction").val();
                var c = $("#cityID").val();
                
//                 alert(m+n+t+c);
                
                $.post("monthStats.php",
                        { month: m, numberOfTourists: n, topAttraction: t, cityID:c },
                        function(msg){
                            var a = $.parseJSON(msg);
                            if(a.length>0){
                                  alert("the insert was successful");
                                  $("#topAttraction").val("");
                                  $("#numberOfTourists").val("");
                                  $("#table").append("<tr><td>"+m+"</td><td>"+n+"</td><td>"+t+"</td></tr>");
                              }else {
                                  alert("the insert falid!\nthe resons maybe as folows:\n- the month is added before\n- missing info");
                              };
                        }
                        ); 
            }
        </script>
    </head>
    <body>
        <?php
        $conn = mysqli_connect("localhost:3307", "root", "root", "KSATourism"); 
        $error = mysqli_error($conn); 
        if($error!= null){
            die($error);
        }
        $id = $_GET["id"]; 
        $sql= "SELECT * From city WHERE cityID = ".$id.""; 
        $result = mysqli_query($conn, $sql); 
        if($result){
            if($row = mysqli_fetch_assoc($result)){
                echo '<h1>'.$row["name"]."</h1>";
                echo "<p>Region: ".$row["region"]."</p>";
                echo "<p>Attractions: ".$row["attractions"]."</p>";
                echo '<p>Price Range: '.$row["priceRange"]."</p>";
                echo '<br>';
            }
        }
        
        echo "<h1>Tourism Statistics -2021</h1>";
        $sql2 = "SELECT * From tourismstatistics WHERE cityID = ".$id."";
        $result2 = mysqli_query($conn, $sql2); 
        if($result2){
            $num = mysqli_num_rows($result2); 
            if($num<1){
                echo '<p>no touists yet!</p>';
            }else{
                $sum = 0; 
                $info = array();
                while($row2 = mysqli_fetch_assoc($result2)){
                    $info[] = $row2; 
                    $sum+=$row2['numberOfTourists'];
                } 
                echo '<h2>The number of touists: '.$sum.'</h2>';
                echo '<p>Tourism Statistics:</p>';
                echo "<table id='table'>"; 
                echo "<tr><td>Month</td><td>Number Of Tourists</td><td>Top Attraction</td></tr>";
                foreach ($info as $v){
                    echo "<tr><td>".$v['month']."</td><td>".$v['numberOfTourists']."</td><td>".$v["topAttraction"]."</td></tr>";
                }
                echo '</table>';
            }
        }
        echo "<h2>Add New Month Statistics</h2>";
        echo "Month: <select id='month'><option value='Jan'>Jan</option><option value='Feb'>Feb</option><option
        value='Mar'>Mar</option><option value='Apr'>Apr</option><option value='May'>May</option><option value='Jun'>Jun</option>
        <option value='Jul'>Jul</option><option value='Aug'>Aug</option><option value='Sep'>Sep</option><option value='Oct'>Oct</option>
        <option value='Nov'>Nov</option><option value='Dec'>Dec</option></select><br/>";
        echo "Number of Tourists: <input type='text' id='numberOfTourists'/><br/>";
        echo "Top Attraction: <input type='text' id='topAttraction'/><br/>";
        echo "<input type='hidden' id='cityID' value='".$id."'><br/>";
        echo "<button onclick ='send()'>Add</button>";

        
        ?>
    </body>
</html>