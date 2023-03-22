-- student
DELETE FROM student;
INSERT INTO student (studid, name, email, dob) VALUES (1, 'student_1', 'student_1gmail.com', '2017-09-28');
INSERT INTO student (studid, name, email, dob) VALUES (2, 'student_2', 'student_2gmail.com', '2017-09-28');


--grade
DELETE FROM grade;
INSERT INTO grade (studid, grade) VALUES (1,  3);
INSERT INTO grade (studid, grade) VALUES (2,  64);
