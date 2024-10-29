package grapheQL.example.universityGrapheQL.repository;

import grapheQL.example.universityGrapheQL.entitiers.Lecture;
import grapheQL.example.universityGrapheQL.entitiers.Semester;
import grapheQL.example.universityGrapheQL.entitiers.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LectureRepository extends JpaRepository<Lecture, Long> {

    List<Lecture> findAllLectureBySemester(Semester semester);
    List<Lecture>findAllLectureByTeacher(Teacher teacher);
}
