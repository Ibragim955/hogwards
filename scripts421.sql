select * from student_1 where age between 10 and 20;

select name from student_1;

select * from student_1 where name LIKE '%o%';

select * from student_1 where age < student_1.id;

select * from student_1 ORDER BY age;

ALTER TABLE student_1
    ADD CONSTRAINT UniqueName UNIQUE (name),
    ADD CONSTRAINT NotNullName CHECK ( name is not null );

ALTER TABLE faculty_1
    ADD CONSTRAINT name_color_unique UNIQUE (name, color);

ALTER TABLE student_1
    ADD CONSTRAINT add_constraint CHECK ( age >= 16 );

ALTER TABLE student_1
    ALTER COLUMN  age SET default (20);