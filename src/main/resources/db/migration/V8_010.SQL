ALTER TABLE teacher
ADD COLUMN university_id BIGINT;

ALTER TABLE teacher
ADD CONSTRAINT fk_university_id
FOREIGN KEY (university_id) REFERENCES university(id)
ON DELETE CASCADE;

ALTER TABLE university
ADD CONSTRAINT `fk_teacher_id`
FOREIGN KEY (`teacher_id`) REFERENCES teacher(id)
ON DELETE CASCADE;


ALTER TABLE university
DROP FOREIGN KEY `university_ibfk_1`;

ALTER TABLE university
DROP FOREIGN KEY `fk_teacher_id`;

ALTER TABLE university
DROP COLUMN `teacher_id`;