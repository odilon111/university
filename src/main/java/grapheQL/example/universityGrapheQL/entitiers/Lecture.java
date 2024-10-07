package grapheQL.example.universityGrapheQL.entitiers;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "lecture")
public class Lecture {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;
    @Column(name = "name")
    private String name;
    @ManyToOne
    @JoinColumn(name = "teacher_id")
    private Teacher teacher;
    @Column(name = "creditPoint")
    private int creditPoint;
    @Column(name = "semester")
    @Enumerated(EnumType.STRING)
    private Semester semester;
    @Column(name = "descriptionModule")
    private String descriptionModule;
}
