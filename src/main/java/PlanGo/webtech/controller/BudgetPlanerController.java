package PlanGo.webtech.controller;

import PlanGo.webtech.model.BudgetPlaner;
import PlanGo.webtech.service.BudgetPlanerService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("/api/budget")
public class BudgetPlanerController {

    private final BudgetPlanerService budgetPlanerService;

    @GetMapping
    public ResponseEntity<Iterable<BudgetPlaner>> getAllBudgetEntries() {
        return ResponseEntity.ok(budgetPlanerService.getAllBudgets());
    }

    @GetMapping("/{id}")
    public ResponseEntity<BudgetPlaner> getBudgetEntry(@PathVariable Long id) {
        return budgetPlanerService.getBudgetById(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping("/{id}/status")
    public ResponseEntity<String> getBudgetStatus(@PathVariable Long id) {
        return budgetPlanerService.getBudgetById(id)
                .map(budgetPlaner -> ResponseEntity.ok(budgetPlaner.getBudgetStatus()))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }


    @PostMapping
    public ResponseEntity<BudgetPlaner> addBudgetEntry(@Valid @RequestBody BudgetPlaner budgetPlaner) {
        System.out.println("Empfangene Daten im Backend: " + budgetPlaner);
        BudgetPlaner created = budgetPlanerService.addBudget(budgetPlaner);
        return new ResponseEntity<>(created, HttpStatus.CREATED);
    }


    @PutMapping("/{id}")
    public ResponseEntity<BudgetPlaner> updateBudgetEntry(@PathVariable Long id, @RequestBody BudgetPlaner budgetPlaner) {
        budgetPlaner.setId(id);
        BudgetPlaner updated = budgetPlanerService.updateBudget(budgetPlaner);
        return updated == null ? ResponseEntity.notFound().build() : ResponseEntity.ok(updated);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBudgetEntry(@PathVariable Long id) {
        return budgetPlanerService.deleteBudgetById(id)
                ? ResponseEntity.noContent().build()
                : ResponseEntity.notFound().build();
    }

}