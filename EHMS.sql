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
select * from Users;
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
#drop table Doctors;
create table Doctors(
	DoctorID int not null,
	First_Name varchar(30), 
    Last_Name varchar(30), 
    Gender varchar(10),
    ContactNumber varchar(11),
    Age int ,
    Entry_Charge int,#
    Qualification varchar(50),#Mbbs etc
    Doctor_Type varchar(50),#"1.Eyes\n 2.EAR.\n3.Heart\n4.Bone\n5.Lungs\n6.Kidney\n7.General_Physicist"
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
    PaymentStatus varchar(33),
    Appointment_Status varchar(30)
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
   # billAmount int,//nahi hain
    #status varchar(20),//yeh nahi hain
    primary key (ReportID)
);
create table feedback
(
	PatientID int,
    points int,
    Doc_Nature varchar(20),
    PatientComment varchar(100)
);
    
