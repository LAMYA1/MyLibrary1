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

$Bookstore = $_POST['Bookstore'];
$quantity = $_POST['quantity'];
$month = $_POST['month'];
$bookID = $_POST['bookID'];
$sql_i = "INSERT INTO `bookorders` (`bookID`, `bookStore`, `quantity`, `month`) VALUES "
        . "('$bookID', '$Bookstore', '$quantity', '$month');";
$result = mysqli_query($connection, $sql_i);

if ($result) {
    header("Content-Type: text/html");
    echo 'added successfully';
    exit();
} else {
    header("Content-Type: text/html");
       echo "added unsuccessfully ";
 
}
?>
