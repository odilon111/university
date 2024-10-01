package grapheQL.example.universityGrapheQL.controller;

import grapheQL.example.universityGrapheQL.entitiers.Lecture;
import grapheQL.example.universityGrapheQL.entitiers.Teacher;
import grapheQL.example.universityGrapheQL.service.LectureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class LectureController {
    @Autowired
    LectureService lectureService;

    @QueryMapping
    public List<Lecture> findAllLecture(){
        return lectureService.findAllLecture();
    }

    @MutationMapping
    public Lecture createLecture(int teacherId,Lecture lecture){

        return lectureService.createLecture(teacherId,lecture);

    }
}
