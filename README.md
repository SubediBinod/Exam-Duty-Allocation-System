# Exam Duty Allocation System

## Overview

The **Exam Duty Allocation System** is a web-based application designed to efficiently allocate faculty members to exam duties. The system randomizes the allocation of faculty to exam rooms while ensuring that the required number of rooms and faculty per room are met. This project integrates **JSP**, **Servlets**, **MySQL**, and **Jakarta Mail** for seamless faculty allocation and notification processes.

## Features

- **Random Allocation**: Faculty members are randomly assigned to available rooms based on a shuffled list of faculty and rooms.
- **Faculty and Room Management**: The system manages faculty details, room allocations, and their corresponding details (e.g., block, floor, room number).
- **Email Notifications**: After allocation, emails are sent to faculty members with their assigned room details, exam date, timing, and duration using **Jakarta Mail**.
- **JSP Forms**: Provides an interface for inputting faculty details and updating allocations.
- **Database Integration**: Uses **MySQL** to store and retrieve faculty and room details.

  ## Screenshots

### Login Page
![1](https://github.com/user-attachments/assets/9e3a450d-fe48-4087-a314-c4f3accfec3a)

### Home Page
![2](https://github.com/user-attachments/assets/abf39ee9-8c3c-4ca7-ad28-ba2080b274b5)

### Faculty Availability
![3](https://github.com/user-attachments/assets/25bce4e8-1ec2-405d-a933-9a5e0e456ce6)

### Exam Duty Allocation
![4](https://github.com/user-attachments/assets/af0155e5-b8c4-43ac-937f-ef25bb3837cd)

### Notification Center
![5](https://github.com/user-attachments/assets/65366373-a569-4666-9a80-9b1e1be42c60)


## Technologies Used

- **Backend**: Java, Servlets, JSP
- **Database**: MySQL
- **Email**: Jakarta Mail
- **Frontend**: HTML, CSS, JavaScript

## Database Structure

The system uses two primary tables in **MySQL**:

1. **`faculty_allocation`**:
   - Contains faculty details such as name, room allocation, and other metadata.

2. **`room_details`**:
   - Stores information about available rooms (block, floor, room number, room code).

## How It Works

1. **Faculty Allocation**:
   - Faculty members are added to the system and are randomly assigned rooms.
   - A servlet processes the faculty data and allocates them to available rooms using a genetic algorithm (if applicable) or a randomization logic.

2. **Room Management**:
   - Rooms are pre-defined in the database and can be fetched dynamically to assign faculty.
   - Room codes (block + floor + room number) ensure unique identification for each room.

3. **Email Notification**:
   - After allocation, emails are sent to each faculty member with the allocation details.
   - The email includes exam date, room number, block, floor, and other important details.

## Email Configuration

The system uses **Jakarta Mail** to send email notifications to faculty members. To set up email notifications, you need to configure your Gmail SMTP server credentials, including the **secret key**.

### Steps to Configure Gmail Credentials:

1. **Update the NotificationServlet**:
   - Open the `NotificationServlet.java` file in your project.
   - Locate the part of the code that handles email sending (likely using `Session.getDefaultInstance()` for mail properties).
   - Update the Gmail credentials (SMTP settings) with your **Gmail secret key** and other necessary credentials.

2. **Generate Gmail Secret Key**:
   - If you haven’t done so already, generate an **App Password** for your Gmail account by following these steps:
     - Go to your **Google Account**: https://myaccount.google.com/
     - Navigate to **Security**.
     - Under **App passwords**, generate a password for your application.
     - Use this generated **App Password** instead of your Gmail account password.

3. **Update the Email Configuration** in the `NotificationServlet`:
   - Modify the `email.properties` or the corresponding section in the `NotificationServlet` to use your Gmail SMTP server details:
   
   ```java
   String host = "smtp.gmail.com";
   String port = "587";  // or 465 if using SSL
   String username = "your_email@gmail.com";
   String password = "your_app_password";  // Use the Gmail App Password here

   Properties props = new Properties();
   props.put("mail.smtp.host", host);
   props.put("mail.smtp.port", port);
   props.put("mail.smtp.auth", "true");
   props.put("mail.smtp.starttls.enable", "true");

   Session session = Session.getInstance(props, new Authenticator() {
       @Override
       protected PasswordAuthentication getPasswordAuthentication() {
           return new PasswordAuthentication(username, password);
       }
   });
## Contributions

We welcome contributions from the community! Whether it's a bug fix, new feature, or improvement, your help is appreciated. Here's how you can contribute:

1. **Fork the Repository**  
   Click on the "Fork" button at the top right of this repository to create a copy in your GitHub account.

2. **Clone the Repository**  
   Clone your forked repository to your local system:
   ```bash
   git clone https://github.com/SubediBinod/exam-duty-allocation-system.git
   ```

3. **Create a New Branch**  
   Use a meaningful name for your branch to describe the feature or issue:
   ```bash
   git checkout -b feature-name
   ```

4. **Make Changes**  
   Implement your changes and commit them:
   ```bash
   git add .
   git commit -m "Brief description of your changes"
   ```

5. **Push Changes**  
   Push your changes to your forked repository:
   ```bash
   git push origin feature-name
   ```

6. **Submit a Pull Request**  
   Go to the original repository and submit a pull request explaining your changes.

Contributions to improve functionality or enhance features are welcome. For major changes, please open an issue to discuss your ideas first.

---

### License

This project is licensed under the [MIT License](LICENSE). Feel free to use and modify it as per the terms of the license.
