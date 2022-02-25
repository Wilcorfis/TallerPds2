package co.com.poli.serviceshowtime.entities;

import java.util.ArrayList;
import lombok.*;
import javax.persistence.*;
import java.util.Date;
import java.util.Objects;

@Getter
@Setter
@Entity
@Table(name = "showtime")
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ShowTime {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false, nullable = false, unique = true)
    public Long id;
    @Column(name = "fecha", nullable = false)
    private String fecha;


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ShowTime showTime = (ShowTime) o;
        return id.equals(showTime.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
