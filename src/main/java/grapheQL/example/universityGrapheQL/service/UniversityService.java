package grapheQL.example.universityGrapheQL.service;

import grapheQL.example.universityGrapheQL.entitiers.Teacher;
import grapheQL.example.universityGrapheQL.entitiers.University;
import grapheQL.example.universityGrapheQL.repository.TeacherRepository;
import grapheQL.example.universityGrapheQL.repository.UniversityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UniversityService {
    @Autowired
    private UniversityRepository universityRepository;
    @Autowired
    TeacherRepository teacherRepository;

    @Transactional
    public University createUniversity(University university){
        List<Teacher> teachers = teacherRepository.findAll();
        university.setTeachers(teachers);
        return universityRepository.saveAndFlush(university);
        
    }

    public List<University> findAllUniversity(){
        return universityRepository.findAll();
    }
}
