package grapheQL.example.universityGrapheQL.entitiers;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "university")
public class University {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private  long id;
    @Column(name = "name")
    private String name;
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, orphanRemoval = true)
    @JoinColumn(name = "university_id") // Creates foreign key in Teacher table
    private List<Teacher> teachers = new ArrayList<>();
}
