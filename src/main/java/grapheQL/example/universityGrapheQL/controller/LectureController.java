package grapheQL.example.universityGrapheQL.controller;

import grapheQL.example.universityGrapheQL.entitiers.Lecture;
import grapheQL.example.universityGrapheQL.entitiers.Semester;
import grapheQL.example.universityGrapheQL.entitiers.Teacher;
import grapheQL.example.universityGrapheQL.service.LectureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/lecture")
public class LectureController {
    @Autowired
    LectureService lectureService;

    @GetMapping
    public List<Lecture> findAllLecture(){
        return lectureService.findAllLecture();
    }

    @PostMapping("/teacherId")
    public Lecture createLecture(@PathVariable int teacherId, @RequestBody Lecture lecture){

        return lectureService.createLecture(teacherId,lecture);

    }

    @GetMapping
    public List<Lecture> getAllLectureBySemester(@RequestBody Semester semester){
        return lectureService.getAllLectureBySemester(semester);
    }

    @GetMapping("/all")
    public List<Lecture> getAllLectureByTeacher(@RequestBody Teacher teacher){
        return lectureService.getAllLectureByTeacher(teacher);
    }
}
