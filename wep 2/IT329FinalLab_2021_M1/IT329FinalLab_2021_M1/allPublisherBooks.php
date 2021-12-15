
<!doctype html>
<?php
define('HOST_NAME', "localhost");
define('USER', "root");
define('PASS', "root");
define('DATABASE', "abcpublisher");
$connection = mysqli_connect(HOST_NAME, USER, PASS, DATABASE);
//handle the error
if (mysqli_connect_error() != null) {
    die(mysqli_connect_error());
}

$retrive = "SELECT * FROM `book`";
$result = mysqli_query($connection, $retrive);

?>
<html>
    <head>
        <title>title</title>
        <style>
            table, th, td {
                border: 1px solid black;
                border-collapse: collapse;
              
            }
        </style>
      
    </head>
    <body>
        <table width="100%">
            <tr>
                <th>Book Title</th>
                <th>Book Category</th>
            </tr>
            <?php
            while ($row = mysqli_fetch_assoc($result)) {
                $id = $row['bookID'];
                $tital = $row['title'];
                echo "<tr id ='$id'>";
                echo '<td>';
                echo "<a href='bookPage.php?id=$id' >$tital</a>";
                echo '</td>';
                echo '<td>';
                echo $row['category'];
                echo '</td>';
                echo '</tr>';
            }
            ?>
        </table>
       
    </body>
</html>

