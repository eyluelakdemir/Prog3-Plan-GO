package PlanGo.webtech.service;

import org.springframework.stereotype.Service;
import PlanGo.webtech.model.BudgetPlaner;
import PlanGo.webtech.repository.BudgetPlanerRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

@Service
public class BudgetPlanerService {

    @Autowired
    private BudgetPlanerRepository budgetPlanerRepository;

    public Iterable<BudgetPlaner> getAllBudgets() {
        return budgetPlanerRepository.findAll();
    }

    public Optional<BudgetPlaner> getBudgetById(Long id) {
        return budgetPlanerRepository.findById(id);
    }

    public BudgetPlaner addBudget(BudgetPlaner budgetPlaner) {
        return budgetPlanerRepository.save(budgetPlaner);
    }

    public BudgetPlaner updateBudget(BudgetPlaner budgetPlaner) {
        if (!budgetPlanerRepository.existsById(budgetPlaner.getId())) {
            return null;
        }
        return budgetPlanerRepository.save(budgetPlaner);
    }

    public boolean deleteBudgetById(Long id) {
        if (budgetPlanerRepository.existsById(id)) {
            budgetPlanerRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
