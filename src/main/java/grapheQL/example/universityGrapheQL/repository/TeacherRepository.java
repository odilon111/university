package grapheQL.example.universityGrapheQL.repository;

import grapheQL.example.universityGrapheQL.entitiers.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TeacherRepository extends JpaRepository<Teacher, Integer> {
}
