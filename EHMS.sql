####################################E-Health-CareManagement-System#################################################################
drop database HealthcareMangaementSystem;
create database HealthcareMangaementSystem;
use HealthcareMangaementSystem;
create table Users(
	userID int,
    userType varchar(100),
	Password varchar(100),
	primary key(userID)
);
create table Patients(
	PatientID int not null,
	First_Name varchar(30), 
    Last_Name varchar(30), 
    Gender enum('M','F'),
    ContactNumber varchar(11),
    Age int ,
    EmailID varchar(20),
    BloodGroup varchar(5),
    Address varchar(50),
	primary key(PatientID)
);
select * from Patients;
create table Doctors(
	DoctorID int not null,
	First_Name varchar(30), 
    Last_Name varchar(30), 
    Gender varchar(10),
    ContactNumber varchar(11),
    Age int ,
    Entry_Charge int,
    Degree varchar(50),
    Department varchar(50),
    address varchar(20),
    primary key(DoctorID)
);
create table Appointments
(
	AppointmentID int,
    DoctorName varchar(20),
    DoctorID int,
    PatientId int,
    PatientName varchar(30),
    DoctorDepartment varchar(20),
    Problem varchar(50),
    DoctorFees int,
    AppointmentDate Date,
    AppointmentTime time,
    Status varchar(30)
);
select * from Users;
create table Reports
(
	ReportID int,
    patientID int,
    DoctorName varchar(20),
    Department varchar(20),
    MedicinePrescribed varchar(20),
    DoctorComment varchar(100),
    billAmount int,
    status varchar(10),
    primary key (ReportID)
);
create table feedback
(
	feedbackID int not null,
	UsersName varchar(20),
    Services varchar(20),
    points int,
    Doc_Nature varchar(20),
    Location varchar(30),
    Feedback varchar(100)
    #reg_date Date
);
    
