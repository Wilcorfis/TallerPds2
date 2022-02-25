package co.com.poli.servicemovie.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Positive;

import java.util.Objects;

@Getter
@Setter
@Entity
@Table(name = "movie")
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false,nullable = false,unique = true)
    private Long id;
    @NotEmpty(message = "El nombre no debe ser vacio")
    @Column(name = "title")
    private String title;
    @NotEmpty(message = "El nombre no debe ser vacio")
    @Column(name = "director")
    private String director;

    @Positive(message = "El precio debe ser mayor que cero")
    @Column(name = "rating")
    private int rating;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "showtimes_id")
    @JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
    private Showtimes showtimes;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Movie movie = (Movie) o;
        return Objects.equals(id, movie.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
