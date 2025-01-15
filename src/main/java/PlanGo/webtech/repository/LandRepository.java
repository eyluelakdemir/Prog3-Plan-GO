package PlanGo.webtech.repository;
import PlanGo.webtech.model.Land;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LandRepository extends JpaRepository<Land,Long>{

}