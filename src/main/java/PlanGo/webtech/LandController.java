package PlanGo.webtech;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


import java.util.Optional;

@Controller
@AllArgsConstructor
@RequestMapping("/api/laender") // Basis-URL für die API-Endpunkte
public class LandController {

    private LandService landService;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Iterable<Land>> getLaender(
            @RequestParam final Optional<Boolean> besucht,
            @RequestParam final Optional<Boolean> geplant
    ) {
        final Iterable<Land> result = (besucht.isEmpty() && geplant.isEmpty())
                ? landService.getLaender()
                : landService.getLaender(besucht.orElse(null), geplant.orElse(null));
        return ResponseEntity.ok(result);
    }


    @GetMapping("/{id}")
    public ResponseEntity<Land> getLand(@PathVariable("id") final Long id) {
        final Optional<Land> landOptional = landService.getLand(id);
        return landOptional.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }


    @PostMapping
    public ResponseEntity<Land> addLand(@Valid @RequestBody final Land land) {
        final Land created = landService.addLand(land);
        return new ResponseEntity<>(created, HttpStatus.CREATED);
    }


    @PutMapping(path = "/{id}")
    public ResponseEntity<Land> updateLand(@PathVariable("id") final Long id, @RequestBody Land body) {
        body.setId(id);
        final Land updatedLand = landService.editLand(body);
        return updatedLand == null ? ResponseEntity.notFound().build() : ResponseEntity.ok(updatedLand);
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Void> deleteLand(@PathVariable("id") final Long id) {
        return landService.removeLand(id)
                ? ResponseEntity.noContent().build()
                : ResponseEntity.notFound().build();
    }
}