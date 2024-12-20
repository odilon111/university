package grapheQL.example.universityGrapheQL.entitiers;

import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name ="teacher")
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class Teacher {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "name")
    private String name;
    @Column(name = "first_name")
    private String firstName;
    @Column(name ="old")
    private  int old;
    @Enumerated(EnumType.STRING)
    @Column(name = "department")
    private Department department;
//    @Column(name = "university_id")
//    private long universityId;
}
