package grapheQL.example.universityGrapheQL.service;

import grapheQL.example.universityGrapheQL.entitiers.Lecture;
import grapheQL.example.universityGrapheQL.entitiers.Semester;
import grapheQL.example.universityGrapheQL.entitiers.Teacher;
import grapheQL.example.universityGrapheQL.repository.LectureRepository;
import grapheQL.example.universityGrapheQL.repository.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class LectureService {
    @Autowired
    private final TeacherRepository teacherRepository;
    @Autowired
    private final LectureRepository lectureRepository;

    public LectureService(TeacherRepository teacherRepository, LectureRepository lectureRepository) {
        this.teacherRepository = teacherRepository;
        this.lectureRepository = lectureRepository;
    }

    @Transactional
    public Lecture createLecture(int teacherId,Lecture lecture){
        Teacher teacher = teacherRepository.findById(teacherId).orElseThrow(() -> new RuntimeException("Teacher not found with ID: " + teacherId));
        lecture.setTeacher(teacher);
        return lectureRepository.save(lecture);


    }

    public List<Lecture> findAllLecture(){
        return lectureRepository.findAll();
    }

    public List<Lecture> getAllLectureBySemester(Semester semester){
        if (semester.equals(null)){
            throw new RuntimeException("lecture not found with semester: " + semester);
        }
        return lectureRepository.findAllLectureBySemester(semester);
    }

    public List<Lecture> getAllLectureByTeacher(Teacher teacher){
        int teacherId = teacher.getId();
        if (teacher.getId()<=0){
            throw new RuntimeException("lecture not found with semester: " + teacher);
        }
        return lectureRepository.findAllLectureByTeacher(teacher);
    }
}
