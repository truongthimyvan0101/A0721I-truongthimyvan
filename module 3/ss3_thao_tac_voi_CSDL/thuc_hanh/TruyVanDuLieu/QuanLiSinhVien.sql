use quan_ly_sinh_vien_new;
select * from student;

select * from student 
where `status` = true;
select * from `subject`
where Credit < 10;

select student.StudentID, student.StudentName, class.ClassName
from student join class on student.ClassID = class.ClassID
where ClassName = "A02";

select student.StudentID, student.StudentName, mark.Mark, subject.SubName
from student join mark on student.StudentID = mark.StudentID 
			 join subject on mark.SubID = subject.SubID
where subject.SubName = "CF";
