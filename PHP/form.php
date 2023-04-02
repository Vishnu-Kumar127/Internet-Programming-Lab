<?php
if($_SERVER['REQUEST_METHOD'] == 'POST') {
    
    $carType = $_POST['cars'];
    $carColor = $_POST['car'];
    $otherColor = $_POST['other'];
    $specification = $_POST['Specification'];
    $name = $_POST['name'];
    $phone = $_POST['no'];
    $email = $_POST['email'];
    $contactMe = isset($_POST['contactMe']) ? 'Yes' : 'No';

  
    $errors = array();
    if(empty($carType)) {
        $errors['carType'] = 'Please select a car type';
    }
    if(empty($carColor) && empty($otherColor)) {
        $errors['color'] = 'Please select a color or enter a value';
    }
    if(strlen($specification) < 10) {
        $errors['specification'] = 'Specification must be at least 10 characters';
    }
    if(empty($name)) {
        $errors['name'] = 'Please enter your name';
    }
    if(empty($phone)) {
        $errors['phone'] = 'Please enter your phone number';
    } elseif(!is_numeric($phone)) {
        $errors['phone'] = 'Phone number must be numeric';
    }
    if(empty($email)) {
        $errors['email'] = 'Please enter your email address';
    } elseif(!filter_var($email, FILTER_VALIDATE_EMAIL)) {
        $errors['email'] = 'Invalid email format';
    }

    
    if(count($errors) == 0) {
        $to = 'mjvishnukumar2003@gmail.com';
        $subject = 'Car Registration Form Submission';
        $message = "Car Type: $carType\n";
        $message .= "Car Color: ";
        if(!empty($carColor)) {
            $message .= "$carColor\n";
        } else {
            $message .= "$otherColor\n";
        }
        $message .= "Specification: $specification\n";
        $message .= "Name: $name\n";
        $message .= "Phone: $phone\n";
        $message .= "Email: $email\n";
        $message .= "Contact Me: $contactMe\n";
        $headers = "From: $email\r\n";
        $headers .= "Reply-To: $email\r\n";
        $success = mail($to, $subject, $message, $headers);
        if(!$success) {
            echo '<p>Thank you for submitting the form.</p>';
        } else {
            echo '<p>Sorry, there was a problem submitting the form. Please try again later.</p>';
        }
    } else {
        
        echo '<ul>';
        foreach($errors as $error) {
            echo "<li>$error</li>";
        }
        echo '</ul>';
    }
}
?>
