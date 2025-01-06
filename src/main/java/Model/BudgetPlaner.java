package Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class BudgetPlaner {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // Primärschlüssel korrekt definiert

    private Double kosten;
    private Double budget;
    private String beschreibung;

    public Double calculateRemainingBudget() {
        return budget - kosten;
    }

    public String getBudgetStatus() {
        double remaining = calculateRemainingBudget();
        if (remaining < 0) {
            return "Budget überschritten!";
        } else {
            return "Verfügbares Restbudget: " + remaining + " €";
        }
    }
}



