USE `institutemanagement`;

/*Department Table*/
CREATE TABLE `department` (
  `DeptId` varchar(255) NOT NULL,
  `DeptName` varchar(255) default NULL,
  PRIMARY KEY  (`DeptId`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*--------------------------------------------------------------------------------------------------------*/

/*Subject Table*/
CREATE TABLE `subject` (
  `SubjectCode` varchar(255) NOT NULL,
  `SubjectTitle` varchar(255) default NULL,
  `Semester` varchar(255) default NULL,
  `DeptId` varchar(255) default NULL,
  PRIMARY KEY  (`SubjectCode`),
  KEY `DeptId` (`DeptId`),
  CONSTRAINT `subject_ibfk_1` FOREIGN KEY (`DeptId`) REFERENCES `department` (`DeptId`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*--------------------------------------------------------------------------------------------------------*/

/*Student Table*/
CREATE TABLE `student` (
  `StudentId` varchar(255) NOT NULL,
  `StudentFirstName` varchar(255) default NULL,
  `StudentLastName` varchar(255) default NULL,
  `StudentFatherName` varchar(255) default NULL,
  `StudentMotherName` varchar(255) default NULL,
  `DeptId` varchar(255) default NULL,
  `Semester` varchar(255) default NULL,
  `StudentDOB` date NOT NULL,
  `DateOfAdmission` date default NULL,
  PRIMARY KEY  (`StudentId`),
  KEY `student_ibfk_1` (`DeptId`),
  CONSTRAINT `student_ibfk_1` FOREIGN KEY (`DeptId`) REFERENCES `department` (`DeptId`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*--------------------------------------------------------------------------------------------------------*/

/*Attendance Table*/
CREATE TABLE `attendance` (
  `StudentId` varchar(255) default NULL,
  `SubjectCode` varchar(255) default NULL,
  `Semester` varchar(255) default NULL,
  `NumOfClassAttend` int(5) default NULL,
  `NumOfClassPerSem` int(5) default NULL,
  `AttendanceId` int(11) NOT NULL auto_increment,
  PRIMARY KEY  (`AttendanceId`),
  KEY `attendance_ibfk_1` (`StudentId`),
  KEY `attendance_ibfk_2` (`SubjectCode`),
  CONSTRAINT `attendance_ibfk_1` FOREIGN KEY (`StudentId`) REFERENCES `student` (`StudentId`),
  CONSTRAINT `attendance_ibfk_2` FOREIGN KEY (`SubjectCode`) REFERENCES `subject` (`SubjectCode`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*--------------------------------------------------------------------------------------------------------*/

/*Faculty Table*/
CREATE TABLE `faculty` (
  `FacultyId` int(255) NOT NULL auto_increment,
  `FacultyName` varchar(255) default NULL,
  `DeptId` varchar(255) default NULL,
  `Qualification` varchar(255) default NULL,
  `FacultyDOB` date default NULL,
  `DateOfJoining` date default NULL,
  `Designation` varchar(255) default NULL,
  PRIMARY KEY  (`FacultyId`),
  KEY `dept_fk` (`DeptId`),
  CONSTRAINT `dept_fk` FOREIGN KEY (`DeptId`) REFERENCES `department` (`DeptId`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*--------------------------------------------------------------------------------------------------------*/

/*Result Table*/
CREATE TABLE `result` (
  `ResultId` int(11) NOT NULL auto_increment,
  `StudentId` varchar(20) NOT NULL,
  `SubjectCode` varchar(20) NOT NULL,
  `Semester` varchar(20) NOT NULL,
  `ResultDate` date default NULL,
  `Internal` int(11) NOT NULL,
  `Marks` double NOT NULL default '0',
  PRIMARY KEY  (`ResultId`),
  KEY `SubjectCode_fk` (`SubjectCode`),
  KEY `StudentId_fk` (`StudentId`),
  CONSTRAINT `StudentId_fk` FOREIGN KEY (`StudentId`) REFERENCES `student` (`StudentId`),
  CONSTRAINT `SubjectCode_fk` FOREIGN KEY (`SubjectCode`) REFERENCES `subject` (`SubjectCode`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*--------------------------------------------------------------------------------------------------------*/

/*UsersTable*/
CREATE TABLE `users` (
  `USER_ID` int(10) unsigned NOT NULL,
  `USERNAME` varchar(45) NOT NULL,
  `PASSWORD` varchar(45) NOT NULL,
  `ENABLED` tinyint(1) NOT NULL,
  PRIMARY KEY  (`USER_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*--------------------------------------------------------------------------------------------------------*/

/*USER_Role Table*/
CREATE TABLE `user_roles` (
  `USER_ROLE_ID` int(10) unsigned NOT NULL,
  `USER_ID` int(10) unsigned NOT NULL,
  `AUTHORITY` varchar(45) NOT NULL,
  PRIMARY KEY  (`USER_ROLE_ID`),
  KEY `FK_user_roles` (`USER_ID`),
  CONSTRAINT `FK_user_roles` FOREIGN KEY (`USER_ID`) REFERENCES `users` (`USER_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*--------------------------------------------------------------------------------------------------------*/

/*fees Table*/
CREATE TABLE `fees` (
  `ReceiptId` varchar(255) NOT NULL,
  `StudentId` varchar(255) default NULL,
  `RecieptDate` date default NULL,
  `AcademicYear` int(5) default NULL,
  `AmountPaid` double default NULL,
  PRIMARY KEY  (`ReceiptId`),
  KEY `StudentId` (`StudentId`),
  CONSTRAINT `fees_ibfk_1` FOREIGN KEY (`StudentId`) REFERENCES `student` (`StudentId`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*--------------------------------------------------------------------------------------------------------*/
