<!DOCTYPE html>
<!--
Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
Click nbfs://nbhost/SystemFileSystem/Templates/Project/PHP/PHPProject.php to edit this template
-->
<html>
    <head>
        <meta charset="UTF-8">
        <link rel ="stylesheet" href=""client.css>

        <title></title>
    </head>
    <body>
        <?php
$id = "id";
$fname = "fname";
$lname = "lname";
$gender = "gender";
$age= "age";



// Create connection
$conn = new mysqli($id ,$fname ,$lname ,$gender ,$age);
// Check connection
if ($conn->connect_error) {
  die("Connection failed: " . $conn->connect_error);
}

<form method="post" action="<?php echo htmlspecialchars($_SERVER["PHP_SELF"]);?>">
        First Name: <input type="text" name="fname" value="<?php echo $fname;?>">

Last Name: <input type="text" name="lname" value="<?php echo $lname;?>">
        Age: <input type="text" name="age" value="<?php echo $age;?>">


Gender:
<input type="radio" name="gender"
<?php if (isset($gender) && $gender=="female") echo "checked";?>
value="female">Female
<input type="radio" name="gender"
<?php if (isset($gender) && $gender=="male") echo "checked";?>
value="male">Male
<input type="radio" name="gender"
<?php if (isset($gender) && $gender=="other") echo "checked";?>
value="other">Other
<input type="submit">

$id = $_GET["id"]; 
        $sql= "SELECT * From clients WHERE clientName = ".$name.""; 
        $result = mysqli_query($conn, $sql); 
        if($result){
            if($row = mysqli_fetch_assoc($result)){
                echo '<h1>'.$row["First name"]."</h1>";
                echo "<p>Last Name: ".$row["lname"]."</p>";
                echo "<p>age: ".$row["age"]."</p>";
                echo '<p>gender: '.$row["gender"]."</p>";
                echo '<br>';
            }
        }
        echo '<h2>The avrage of ages: '.$sum.'</h2>';
                echo '<p>The avrage of ages:</p>';
                echo "<table name='table'>"; 
                echo "<tr><td>age</td><td>The avrage of ages</td></tr>";
                foreach ($info as $v){
                    echo "<tr><td>".$v['age']."</td><td>".$v['AvrageOfAges']."</td><td>".;
                }
 
                echo '</table>';
            
        ?>
    </body>
            <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>

        <script>
            function send(){
                var f = $("#fname").val();
                var l = $("#lname").val();
                var a = $("#age").val();
                var g = $("#gender").val();
                
                $.post("monthStats.php",
                        { fname: f, lname: l, age: a,gender :g },
                        function(msg){
                            var a = $.parseJSON(msg);
                            if(a.length>0){
                                  $("#fame").val("");
                                  $("#lname").val("");
                                  $("#table").append("<tr><td>"+f+"</td><td>"+l+"</td><td>"+a+"</td></tr>"+g+"</td><td>");
                              
                        }
                        ); 
            }
        </script>
        <script>
            $(document).ready(function () {
                $("button").click(function () {
                    var data = "Firstame=" + $('#fname').val() + "&LatName=" + $('#lname').val() + "&gender=" + $("#gender option:selected").val() + "&age=" + $('#age').val();
                    $.ajax({
                        type: "POST",
                        url: "client.php",
                        data: data,
                        success: function (respond) {
                            window.alert(respond);
                        }
                    });
                });
            });
        </script>
     
</html>
