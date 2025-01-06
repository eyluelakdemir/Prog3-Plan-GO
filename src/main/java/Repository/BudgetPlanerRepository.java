package Repository;

import Model.BudgetPlaner;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BudgetPlanerRepository extends CrudRepository<BudgetPlaner, Long> {
}
