package PlanGo.webtech;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api") // Basis-URL für alle Routen in diesem Controller
public class LandController {
    private List<Land> laender = new ArrayList<>();

    public LandController() {
        // Beispiel-Daten hinzufügen
        laender.add(new Land("Deutschland", true, false));
        laender.add(new Land("Italien", false, false));
        laender.add(new Land("Japan", false, false));
    }

    // GET: Gibt die Liste aller Länder zurück
    @GetMapping("/laender")
    public List<Land> getLaender() {
        return laender;
    }

    // POST: Fügt ein neues Land hinzu
    @PostMapping("/laender")
    public void addLand(@RequestBody Land neuesLand) {
        laender.add(neuesLand);
    }

    // PUT: Aktualisiert ein Land basierend auf dem Namen
    @PutMapping("/laender/{name}")
    public String updateLand(@PathVariable String name, @RequestBody Land updatedLand) {
        for (Land land : laender) {
            if (land.getName().equalsIgnoreCase(name)) {
                land.setBesucht(updatedLand.isBesucht());
                land.setGeplant(updatedLand.isGeplant());
                return "Land erfolgreich aktualisiert!";
            }
        }
        return "Land mit dem Namen nicht gefunden!";
    }

    // DELETE: Löscht ein Land basierend auf dem Namen
    @DeleteMapping("/laender/{name}")
    public String deleteLand(@PathVariable String name) {
        boolean removed = laender.removeIf(land -> land.getName().equalsIgnoreCase(name));
        return removed ? "Land erfolgreich gelöscht!" : "Land mit dem Namen nicht gefunden!";
    }
}


