

select s.name, s.age, f.name
from student_1 as s
         inner join faculty_1 as f on f.id = s.faculty_id;

select s.name, s.age, a.file_path
from student_1 s
         right join avatar as a on s.id = a.student_id;
