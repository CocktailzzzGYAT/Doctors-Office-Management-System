# Doctor's-Office-Management-System
L2 ACAD PROJECT GOES BRRRR



DATABASE HOSTED ON PHPMYADMIN : 
CREATION : 
DB NAME : hospital
PORT : default
IF THE PORT YOU'RE USING ON XAMPP IS NOT THE DEFAULT ADD :(PORT) AFTER localhost in Database
SHOW PASSWORD AFTER FULLY TYPING IT IN LOGIN/SIGNUP TO AVOID ERROR MESSAGE 

ADD FONTAWESOME JAR TO DEPENDECIES IN THE IDE (FOUND IN LIBRARY FOLDER WITHING THE PROJECT)
ADD SQLCONNECTOR JAR TO BUILDPATH IN THE IDE (FOUND IN THE LIBRARY FOLDER WITHIN THE PROJECT)


CREATE TABLE `admin` (
 `admin_id` int(11) NOT NULL AUTO_INCREMENT,
 `email` varchar(100) NOT NULL,
 `username` varchar(100) NOT NULL,
 `password` varchar(100) NOT NULL,
 `full_name` varchar(100) DEFAULT NULL,
 `image` varchar(500) DEFAULT NULL,
 `gender` varchar(50) DEFAULT NULL,
 `date` date NOT NULL,
 PRIMARY KEY (`admin_id`)
) ENGINE=InnoDB AUTO_INCREMENT=36 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci

CREATE TABLE `appointment` (
 `id` int(11) NOT NULL AUTO_INCREMENT,
 `appointment_id` int(50) NOT NULL,
 `patient_id` bigint(50) DEFAULT NULL,
 `name` varchar(100) NOT NULL,
 `gender` varchar(100) NOT NULL,
 `description` varchar(200) NOT NULL,
 `diagnosis` varchar(200) DEFAULT NULL,
 `treatment` varchar(200) DEFAULT NULL,
 `mobile_number` bigint(50) NOT NULL,
 `address` varchar(500) NOT NULL,
 `date` date DEFAULT NULL,
 `date_modify` date DEFAULT NULL,
 `date_delete` date DEFAULT NULL,
 `status` varchar(50) NOT NULL,
 `doctor` varchar(50) NOT NULL,
 `specialized` varchar(100) DEFAULT NULL,
 `schedule` date NOT NULL,
 PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci

CREATE TABLE `doctor` (
 `id` int(11) NOT NULL AUTO_INCREMENT,
 `doctor_id` varchar(50) NOT NULL,
 `password` varchar(100) NOT NULL,
 `full_name` varchar(100) NOT NULL,
 `email` varchar(100) NOT NULL,
 `gender` varchar(100) DEFAULT NULL,
 `mobile_number` varchar(100) DEFAULT NULL,
 `specialized` varchar(100) DEFAULT NULL,
 `address` varchar(200) DEFAULT NULL,
 `image` varchar(500) DEFAULT NULL,
 `date` date NOT NULL,
 `modify_date` date DEFAULT NULL,
 `delete_date` date DEFAULT NULL,
 `status` varchar(50) NOT NULL,
 PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci

CREATE TABLE `patient` (
 `id` int(11) NOT NULL AUTO_INCREMENT,
 `patient_age` varchar(50) DEFAULT NULL,
 `patient_name` varchar(30) NOT NULL,
 `gender` varchar(100) DEFAULT NULL,
 `patient_phone` varchar(30) NOT NULL,
 `patient_adress` varchar(100) NOT NULL,
 `doctor` varchar(100) DEFAULT NULL,
 `date` date NOT NULL,
 `date_modify` date DEFAULT NULL,
 `date_delete` date DEFAULT NULL,
 PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=36 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci
