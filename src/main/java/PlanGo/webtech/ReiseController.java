package PlanGo.webtech;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class ReiseController {

    @GetMapping("/reisen")
    public List<Reise> getReisen() {
        List<Reise> reisen = new ArrayList<>();

        // Beliebte Reiseziele hinzufügen
        reisen.add(new Reise("New York", "Stadt", "2024-10-14"));
        reisen.add(new Reise("Paris", "Stadt", "2024-12-10"));
        reisen.add(new Reise("Tokio", "Stadt", "2024-04-05"));
        reisen.add(new Reise("Dubai", "Stadt", "2024-06-20"));
        reisen.add(new Reise("Bangkok", "Stadt", "2024-09-15"));
        reisen.add(new Reise("Rom", "Stadt", "2024-04-15"));
        reisen.add(new Reise("Barcelona", "Stadt", "2024-03-18"));
        reisen.add(new Reise("London", "Stadt", "2023-11-11"));
        reisen.add(new Reise("Amsterdam", "Stadt", "2024-05-30"));
        reisen.add(new Reise("Istanbul", "Stadt", "2024-07-25"));

        reisen.add(new Reise("Mallorca", "Strand", "2024-07-15"));
        reisen.add(new Reise("Hawaii", "Strand", "2024-08-25"));
        reisen.add(new Reise("Malibu", "Strand", "2024-08-10"));
        reisen.add(new Reise("Bahamas", "Strand", "2024-07-22"));
        reisen.add(new Reise("Phuket", "Strand", "2024-02-18"));
        reisen.add(new Reise("Santorini", "Strand", "2024-06-05"));
        reisen.add(new Reise("Ibiza", "Strand", "2024-06-18"));
        reisen.add(new Reise("Bali", "Strand", "2024-07-30"));
        reisen.add(new Reise("Malediven", "Strand", "2024-12-01"));
        reisen.add(new Reise("Seychellen", "Strand", "2024-08-12"));

        reisen.add(new Reise("Schwarzwald", "Land", "2024-05-05"));
        reisen.add(new Reise("Alpen", "Land", "2024-10-02"));
        reisen.add(new Reise("Bayern", "Land", "2024-05-25"));
        reisen.add(new Reise("Toskana", "Land", "2024-09-20"));
        reisen.add(new Reise("Schottland", "Land", "2024-04-10"));
        reisen.add(new Reise("Rocky Mountains", "Land", "2024-09-10"));
        reisen.add(new Reise("Grand Canyon", "Land", "2024-04-25"));
        reisen.add(new Reise("Andes", "Land", "2024-12-12"));
        reisen.add(new Reise("Yosemite", "Land", "2024-06-15"));
        reisen.add(new Reise("Lappland", "Land", "2024-01-10"));

        return reisen;
    }
}