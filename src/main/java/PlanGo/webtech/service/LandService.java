package PlanGo.webtech.service;
import PlanGo.webtech.model.Land;
import PlanGo.webtech.repository.LandRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class LandService {

    @Autowired
    private LandRepository repository;

    public Iterable<Land> getLaender() {
        return this.repository.findAll();
    }


    public Iterable<Land> getLaender(final Boolean besucht, final Boolean geplant) {
        return StreamSupport.stream(this.getLaender().spliterator(), false)
                .filter(land -> (besucht == null || Objects.equals(land.getBesucht(), besucht)) &&
                        (geplant == null || Objects.equals(land.getGeplant(), geplant)))
                .collect(Collectors.toSet());
    }

    public Optional<Land> getLand(final Long id) {
        return this.repository.findById(id);
    }

    public Land addLand(final Land land) {
        return this.repository.save(land);
    }

    public Land editLand(final Land land) {
        if (!this.repository.existsById(land.getId())) return null;
        return this.repository.save(land);
    }

    public boolean removeLand(final Long id) {
        final boolean exists = this.repository.existsById(id);
        if (exists) {
            this.repository.deleteById(id);
        }
        return exists;
    }
}
