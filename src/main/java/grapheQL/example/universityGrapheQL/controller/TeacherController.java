package grapheQL.example.universityGrapheQL.controller;

import grapheQL.example.universityGrapheQL.entitiers.Teacher;
import grapheQL.example.universityGrapheQL.repository.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

@Controller
public class TeacherController {
    @Autowired
    private TeacherRepository teacherRepository;

    @QueryMapping
    public List<Teacher> getAllTeacher(){
        return teacherRepository.findAll();
    }

    @MutationMapping
    public Teacher createTeacher(@Argument Teacher teacher){
        return teacherRepository.saveAndFlush(teacher);

    }


    public void loadData() throws IOException {
       // List<Teacher> teachers = new ArrayList<>();
        Path sourceOfTeacherData  = Paths.get
                ("F:\\Dokumente\\grapheQL\\universityGrapheQL\\src\\main\\resources\\university\\dbteacher\\programmationLanguage.txt");
        List<String> teachingLine = Files.readAllLines(sourceOfTeacherData);
        for (int i=1; i<teachingLine.size()-1;i++){
            String teacherLine = teachingLine.get(i);
            String[] teacherInfo = teacherLine.split(";");
            int teacherId =Integer.parseInt(teacherInfo[0].replaceAll("\\s",""));
            String teacherName = teacherInfo[1];
            String teacherFirstName = teacherInfo[2];
            int teacherOld = Integer.parseInt(teacherInfo[3].replaceAll("\\s",""));
            Teacher teachers = Teacher.builder()
                    .id(teacherId)
                    .name(teacherName)
                    .firstName(teacherFirstName)
                    .old(teacherOld)
                              .build();

         teacherRepository.save(teachers);
        }


    }

}
