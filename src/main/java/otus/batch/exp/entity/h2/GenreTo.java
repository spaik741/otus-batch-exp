package otus.batch.exp.entity.h2;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@Table(name = "genres")
@AllArgsConstructor
@NoArgsConstructor
public class GenreTo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "genre")
    private String genre;

    @Override
    public String toString() {
        return "Genre:" +
                "id=" + id +
                ", genre='" + genre + '.';
    }
}
