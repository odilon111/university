package grapheQL.example.universityGrapheQL.repository;

import grapheQL.example.universityGrapheQL.entitiers.Lecture;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LectureRepository extends JpaRepository<Lecture, Long> {
}
