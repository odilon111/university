package grapheQL.example.universityGrapheQL.controller;

import grapheQL.example.universityGrapheQL.entitiers.University;
import grapheQL.example.universityGrapheQL.service.UniversityService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller

public class UniversityController {
    @Autowired
    private UniversityService universityService;

    @QueryMapping
    public List<University> findAllUniversity(){
        return universityService.findAllUniversity();
    }

    @MutationMapping
    public University createUniversity(@Argument University university){
        return universityService.createUniversity(university);
    }
}
