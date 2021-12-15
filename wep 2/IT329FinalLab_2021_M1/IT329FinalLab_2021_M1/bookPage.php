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
$id = $_GET['id'];
$sql = "SELECT * FROM `book` WHERE bookID =$id";
$result = mysqli_query($connection, $sql);
$row = mysqli_fetch_assoc($result);
?>
<!doctype html>
<html>
    <head>
        <title>book info</title>
        <style>
            table, th, td {
                border: 1px solid black;
                border-collapse: collapse;

            }
        </style>
        <script src="//ajax.googleapis.com/ajax/libs/jquery/2.1.1/jquery.min.js"></script>
        <script>
            $(document).ready(function () {
                $("button").click(function () {
                    var data = "Bookstore=" + $('#bookstore').val() + "&quantity=" + $('#quantity').val() + "&month=" + $("#month option:selected").val() + "&bookID=" + $('#bookID').val();
                    $.ajax({
                        type: "POST",
                        url: "newOrder.php",
                        data: data,
                        success: function (respond) {
                            window.alert(respond);
                        }
                    });
                });
            });
        </script>
    </head>
    <body>
        <h1></h1>
        <?php
        $tital = $row['title'];
        echo "<h1>$tital</h1>";
        $cat = $row['category'];
        echo "<h2>category : $cat</h2>";
        $athu = $row['authors'];
        echo "<h2>Auther :$athu</h2>";
        $price = $row['price'];
        echo "<h2>Price : $price</h2>";
        //------------------------
        echo "<h1>Book order</h1>";
        $ordernum =  mysqli_query($connection, "SELECT * FROM `bookorders` WHERE bookID=$id");
        $cont=0;
          while ($all = mysqli_fetch_assoc($ordernum)) {
              $quantity = $all['quantity'];
              $cont +=$quantity;
          }
       if ($cont != 0) {
        echo "<h2>Total of brdered book :$cont</h2>";
       
            $BookStorse = mysqli_query($connection, "SELECT * FROM `bookorders` WHERE bookID=$id");
            echo"<table>"
            . "<tr>"
            . "<th>Book store Name</th>"
            . "<th>Order quntity</th>"
            . "<th>Month</th><"
            . "/tr>";
            while ($row = mysqli_fetch_assoc($BookStorse)) {
                $bookStore = $row['bookStore'];
                $quantity = $row['quantity'];
                $month = $row['month'];
               
                echo"
            <tr>
                <td>$bookStore</td>
                <td>$quantity</td>
                <td>$month</td>
            </tr>";
            }
            echo "</table>";
        } else {
            echo '<h2>No Orders Yet</h2>';
        }
        //------------------------

        echo "<h2>Add New Order</h2>";
        echo "Bookstore: <input type='text' id='bookstore'/><br/>";
        echo "Quantity: <input type='text' id='quantity'/><br/>";
        echo "Month: <select id='month'>
            <option value='Jan'>Jan</option><option value='Feb'>Feb</option><option 
value='Mar'>Mar</option><option value='Apr'>Apr</option></select>";
        echo "<input type='hidden' id='bookID' value='" . $id . "'><br/>";
        echo "<button>Add</button>";
        ?>

    </body>
</html>
