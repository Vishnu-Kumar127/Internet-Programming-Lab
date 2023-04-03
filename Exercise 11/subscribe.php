<?php

$servername = "localhost";
$username = "root";
$password = "";
$db="subscription";


$conn = new mysqli($servername, $username, $password,$db);


if ($conn->connect_error) {
    die("Connection failed: " . $conn->connect_error);
}


$name = $_POST["name"];
$email = $_POST["email"];
$subscription_plan = $_POST["subscription_plan"];

if (empty($name) || empty($email) || empty($subscription_plan)) {
    die("All fields are required.");
}

if (!filter_var($email, FILTER_VALIDATE_EMAIL)) {
    die("Invalid email format.");
}


$sql = "INSERT INTO subscriptions VALUES ('$name', '$email', '$subscription_plan')";

if ($conn->query($sql) === TRUE) {
    echo "Thank you for subscribing!<br>";
    echo "Your data is inserted";

} else {
    echo "Error: " . $sql . "<br>" . $conn->error;
}


$conn->close();
?>
