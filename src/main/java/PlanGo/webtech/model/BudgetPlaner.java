package PlanGo.webtech.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;
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
    private Long id;

    @NotNull
    private Double kosten;

    @NotNull
    private Double budget;

    private String beschreibung;

    public Double calculateRemainingBudget() {
        return (budget != null ? budget : 0) - (kosten != null ? kosten : 0);
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

