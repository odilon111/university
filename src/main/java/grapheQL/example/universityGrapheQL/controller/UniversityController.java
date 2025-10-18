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
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/university")
public class UniversityController {
    @Autowired
    private UniversityService universityService;

    @GetMapping
    public List<University> findAllUniversity(){
        return universityService.findAllUniversity();
    }

    @PostMapping
    public University createUniversity(@RequestBody University university){
        return universityService.createUniversity(university);
    }
}
