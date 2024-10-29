package grapheQL.example.universityGrapheQL.repository;

import grapheQL.example.universityGrapheQL.entitiers.University;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UniversityRepository extends JpaRepository<University, Long> {
}
