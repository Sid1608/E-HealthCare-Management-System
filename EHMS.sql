####################################E-Health-CareManagement-System#################################################################
#drop database HealthcareMangaementSystem;
create database HealthcareMangaementSystem;
use HealthcareMangaementSystem;
create table Users(
	userID int,
    userType varchar(100),
	Password varchar(100),
	primary key(userID,userType)
);
create table Patients(
	PatientID int not null,
	First_Name varchar(30), 
    Last_Name varchar(30), 
    Gender varchar(5),
    ContactNumber varchar(11),
    Age int ,
    EmailID varchar(20),
    BloodGroup varchar(5),
    Address varchar(50),
	primary key(PatientID)
);
select * from Patients;
drop table Doctors;
create table Doctors(
	DoctorID int not null,
	First_Name varchar(30), 
    Last_Name varchar(30), 
    Gender varchar(10),
    ContactNumber varchar(11),
    Age int ,
    Entry_Charge int,
    Qualification varchar(50),
    Doctor_Type varchar(50),
    Email_Id varchar(20),
    primary key(DoctorID)
);
create table Appointments
(
	AppointmentID int,
    Problem varchar(50),
	PatientId int,
    DoctorName varchar(20),
    DoctorID int,
    DoctorType varchar(20),
    Qualification varchar(20),
    DoctorFees int,
    Status varchar(30)
);

select * from Users;
create table Reports
(
	ReportID int,
    appointmentID int,
    patientID int,
    DoctorID int,
    MedicinePrescribed varchar(200),
    DoctorComment varchar(200),
    billAmount int,
    status varchar(20),
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
    Feedback varchar(100),
    reg_date Date
);
    
