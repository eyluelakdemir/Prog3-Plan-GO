package Model;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import lombok.ToString;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ToDo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Primärschlüssel korrekt definiert
    private Long id;

    private String title;

    private boolean completed;

    private Long landId; // Verknüpfung zu einem Land
}

