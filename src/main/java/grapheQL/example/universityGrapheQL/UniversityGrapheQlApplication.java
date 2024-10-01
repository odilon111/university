package grapheQL.example.universityGrapheQL;

import grapheQL.example.universityGrapheQL.controller.TeacherController;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class UniversityGrapheQlApplication {

	public static void main(String[] args) {
		SpringApplication.run(UniversityGrapheQlApplication.class, args);
	}

	@Bean
	CommandLineRunner start(TeacherController teacherController){
		return args -> {
			teacherController.loadData();
		};

	}

}
