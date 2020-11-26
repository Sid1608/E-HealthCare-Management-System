/********************----E-Health-CareManagement-System-----***************/
#drop database HealthcareMangaementSystem;
create database HealthcareMangaementSystem;#Creating a Database
use HealthcareMangaementSystem;
/*************************Users Table******************************/
create table Users(
	userID int,
    userType varchar(100),
	Password varchar(100),
	primary key(userID,userType)
);
select * from Users;
insert into Users ( userID , userType, Password)
values
(1,'Patient','One'),
(2,'Patient','Two'),
(3,'Patient','Three'),
(4,'Patient','Four'),
(5,'Patient','Five'),
(6,'Patient','Six'),
(7,'Patient','Seven'),
(8,'Patient','Eight'),
(9,'Patient','Nine'),
(10,'Patient','Ten'),
(11,'Patient','Eleven'),
(12,'Patient','Twelve'),
(13,'Patient','Thirteen'),
(14,'Patient','Fourteen'),
(15,'Patient','Fifteen'),
(16,'Patient','Sixteen'),
(17,'Patient','Seventeen'),
(18,'Patient','Eighteen'),
(19,'Patient','Nineteen'),
(20,'Patient','Twenty'),
(1,'Doctor','One'),
(2,'Doctor','Two'),
(3,'Doctor','Three'),
(4,'Doctor','Four'),
(5,'Doctor','Five'),
(6,'Doctor','Six'),
(7,'Doctor','Seven'),
(8,'Doctor','Eight'),
(9,'Doctor','Nine'),
(10,'Doctor','Ten'),
(11,'Doctor','Eleven'),
(12,'Doctor','Twelve'),
(13,'Doctor','Thirteen'),
(14,'Doctor','Fourteen'),
(15,'Doctor','Fifteen'),
(16,'Doctor','Sixteen'),
(17,'Doctor','Seventeen'),
(18,'Doctor','Eighteen'),
(19,'Doctor','Nineteen'),
(20,'Doctor','Twenty');
/****************************Patients Table*************************************/
create table Patients(
	PatientID int not null,
	First_Name varchar(30), 
    Last_Name varchar(30), 
    Gender varchar(5),
    ContactNumber varchar(11),
    Age int ,
    EmailID varchar(30),
    BloodGroup varchar(5),
    Address varchar(50),
	primary key(PatientID)
);
insert into Patients ( PatientID , First_Name , Last_Name ,Gender , ContactNumber ,Age,EmailId,BloodGroup,Address)
values
(1,"Sanjay","Gosavi","M","9828698648",28,"sanjay24gosavi@gmail.com","B+","D-402 Anand Nagar M.I. road Delhi"),
(2,"Anand","Sharma","M","9858688788",30,"anand54sharma@gmail.com","B+","E-002 Tilak Nagar New Delhi"),
(3,"Subhash","Garg","M","9667479292",34,"gargsubash1703@gmail.com","A+","Basant Vihar Pune"),
(4,"Priya","Khandelwal","F","8005629518",28,"sanjay24gosavi@gmail.com","B-","PlotNo. 104 Subhash chowk Chandigarh"),
(5,"Pritam","Yadav","M","9828652524",18,"letsmailprit02@gmail.com","AB+","C-03 Vaishali Nagar Jaipur"),
(6,"Sanju","Sharma","M","9279264253",42,"sansharma8@gmail.com","B-","Gopal Nagar Bharatpur"),
(7,"Tejaswani","Goswami","F","8005263213",32,"goswamiteja@gmail.com","A-","Prasad Dham Mumbai"),
(8,"Sumit","Bhardwaj","M","8214358648",46,"sumit4566bhardwaj@gmail.com","O+","Surya Path Roorki"),
(9,"Kavita","Jain","F","9825426363",15,"jain78kavi@gmail.com","AB+","Gaurav Path M.I. road Delhi"),
(10,"Yogesh","Sihra","M","9828565642",28,"yogeshshira28@gmail.com","AB-","Durgapur road Kolkatta"),
(11,"Bhanu","Pratap","M","8052674312",68,"bahnupratap@gmail.com","O+","vivekanand street Malipura"),
(12,"Sonam","Tiwari","F","9797465823",18,"sonamtiwari423@gmail.com","A+","E-03 Tonk Phatak Jaipur"),
(13,"Neha","Mehta","F","7073165498",24,"mehtaneha556@gmail.com","AB-","rani chawk jalandhar"),
(14,"Roop","Devi","F","8302567823",56,"roopdevima@gmail.com","B-","Chandni chawak Delhi"),
(15,"Yash","Chaudary","M","9886756678",36,"chaudaryash011@gmail.com","AB+","Rashi Mansion Indore"),
(16,"Suraj","Yadav","M","8308576312",24,"itssuraj@gmail.com","A+","Usha vihar bhilwada"),
(17,"Arjun","Sethi","M","7782385721",42,"arjun11sethi@gmail.com","B+"," Flat no.33 Behind Uday Street Bhopal"),
(18,"Priya","Goyal","F","8857283942",32,"angelpriya@gmail.com","A-","Bajri Mandi Gandhi Path Kota"),
(19,"Aanvi","Singhal","F","9815215367",12,"aanvisinghal100@gmail.com","B-","Chhatrapati Shivaji Mansion Mumbai"),
(20,"Rohit","Singh","M","8358032156",27,"rohitsingh124@gmail.com","O+","Ganesh Vihar Mudrai");
select * from Patients;
/*****************************Doctor Table**********************************/
#drop table Doctors;
create table Doctors(
	DoctorID int not null,
	First_Name varchar(30), 
    Last_Name varchar(30), 
    Gender varchar(10),
    ContactNumber varchar(11),
    Age int ,
    Entry_Charge int,#
    Qualification varchar(50),
    Doctor_Type varchar(50),
    Email_Id varchar(30),
    primary key(DoctorID)
);
insert into Doctors (DoctorID,First_Name,Last_Name,Gender,ContactNumber,Age,Entry_Charge,Qualification,Doctor_Type,Email_Id)
values
(1,"Vivek","Bhardwaj","M","9243668213",32,400,"MD","Ear","bhardwajvivek@gmail.com"),
(2,"Vinod","Gupta","M","9382674321",42,300,"BDS","Lungs","vinod24gupta@gmail.com"),
(3,"Ashish","Arora","M","8213264251",47,200,"BHMS","Eye","arorashish5871@gmail.com"),
(4,"Poonam","Mishra","F","7782934712",27,700,"MD","Kidney","punamishra@gmail.com"),
(5,"Madhu","Srivastva","F","9982675837",33,500,"MD","Heart","srivastvamadhu@gmail.com"),
(6,"Anoop","Faujdar","M","9788855387",58,550,"MBBS","Lungs","anoopfauji@gmail.com"),
(7,"Ankita","Khandelwal","F","9985671358",36,300,"BAMS","General_Physicist","khandelwalankita@gmail.com"),
(8,"Abhishek","Agarwal","M","8763505789",25,200,"Phd","Kidney","abhishekagarwal25@gmail.com"),
(9,"Piyush","Gupta","M","7855671213",52,400,"MBBS","Heart","piyushgupta562@gmail.com"),
(10,"Priyanka","Jangid","F","8005628135",68,600,"BDS","Lungs","prinyanka456jangid@gmail.com"),
(11,"Deepak","Sharma","M","9505745565",38,250,"MS","General_Physicist","dipakshramtalks@gmail.com"),
(12,"Prakash","Yadav","M","9460812415",47,350,"BAMS","Eye","yadavprakash79@gmail.com"),
(13,"Harish","Chauhan","M","9855762432",54,450,"PhD","Ear","harishchauhanstarts@gmail.com"),
(14,"Seema","Patodi","F","9651404283",63,500,"BHMS","Bone","meseemapatodi@gmail.com"),
(15,"Mukesh","Saxena","M","9887635723",69,450,"BUMS","Bone","saxenamukesh@gmail.com"),
(16,"Ashok","Gupta","M","9988735721",29,300,"BDS","Ear","ashokgupta@gmail.com"),
(17,"Ashish","Maheshwari","M","7082172315",35,300,"MBBS","Heart","maheswariashish@gmail.com"),
(18,"Neelam","rao","F","9652385745",39,350,"MD","Kidney","raoneelam46@gmail.com"),
(19,"Priyanka","Sharma","F","8857638923",24,250,"BDS","Lungs","priyanka24sharma@gmail.com"),
(20,"Gaurav","Tripathi","M","8112857382",40,400,"MBBS","Heart","gaurav00tripathi@gmail.com");
select * from Doctors;
/********************************Appointments Table***************************************/
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
    Appointment_Status varchar(30),
    CONSTRAINT FK_p FOREIGN KEY (patientId)REFERENCES Patients(PatientID),
    CONSTRAINT FK_docid FOREIGN KEY (DoctorID) REFERENCES Doctors(DoctorID)
);
SELECT * FROM Appointments;
/*******************************Reports Table**********************************************/
create table Reports
(
	ReportID int,
    appointmentID int,
    patientID int,
    DoctorID int,
    MedicinePrescribed varchar(200),
    DoctorComment varchar(200),
    primary key (ReportID),
    CONSTRAINT FK_apid FOREIGN KEY (appointmentID) REFERENCES Appointments(AppointmentID),
    CONSTRAINT FK_p FOREIGN KEY (patientID)REFERENCES Patients(PatientID),
    CONSTRAINT FK_docid FOREIGN KEY (DoctorID) REFERENCES Doctors(DoctorID)
);
select * from Reports;
/******************************Feedback Table************************************************/
create table feedback
(
	PatientID int,
    points int,
    Doc_Nature varchar(200),
    Location varchar(200),
    PatientComment varchar(1000),
    CONSTRAINT FK_pid FOREIGN KEY (PatientID)
    REFERENCES Patients(PatientID)
);
select * from feedback;