SELECT age, student_id.avatar_id, faculty_id.student_id, faculte_id.user
FROM user
         INNER JOIN student_id ON age.student_id = student.id