package grapheQL.example.universityGrapheQL.controller;

import grapheQL.example.universityGrapheQL.entitiers.Department;
import grapheQL.example.universityGrapheQL.entitiers.Teacher;
import grapheQL.example.universityGrapheQL.repository.TeacherRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;


@Slf4j
@Controller
public class TeacherController {
    @Autowired
    private TeacherRepository teacherRepository;

    public TeacherController(TeacherRepository teacherRepository) {
        this.teacherRepository = teacherRepository;
    }

    @QueryMapping
    public List<Teacher> getAllTeacher(){
        return teacherRepository.findAll();
    }

    @MutationMapping
    public Teacher createTeacher(@Argument Teacher teacher){
        return teacherRepository.saveAndFlush(teacher);

    }

    @QueryMapping
    //@GetMapping("/employees/{teacherId}")
    public Teacher getTeacherById(@Argument int teacherId){
        if (teacherId <= 0) {  // Überprüfung auf ungültige Werte
            throw new IllegalArgumentException("Invalid teacher ID: " + teacherId);
        }
        Teacher teacher1 = teacherRepository.getReferenceById(teacherId);
        String name = teacher1.getName();
        int old = teacher1.getOld();
        return teacherRepository.findById(teacherId).orElseThrow(() -> new RuntimeException("Teacher not found with ID: " + teacherId));
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
            String teacherDepartmentColumn = teacherInfo[4];
            Department teacherDepartment = Department.valueOf(teacherDepartmentColumn);

            Teacher teachers = Teacher.builder()
                    .id(teacherId)
                    .name(teacherName)
                    .firstName(teacherFirstName)
                    .old(teacherOld)
                    .department(teacherDepartment


                    )
                              .build();

         teacherRepository.save(teachers);
        }


    }
    public static void main(String[] args){

        StringFunction exclaim = (s) -> s + "!";
        System.out.println(exclaim);
    }

}
interface StringFunction {
    String run(String str);
}