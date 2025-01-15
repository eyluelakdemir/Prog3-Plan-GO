package PlanGo.webtech.model;
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

    private String text; // <-- Muss hinzugefügt werden
    private String category; // <-- Muss hinzugefügt werden
    private boolean completed;

    
}

