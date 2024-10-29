package PlanGo.webtech;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {
    private List<User> users = new ArrayList<>();

    public UserController() {
        // Beispiel-Benutzer hinzufügen
        users.add(new User("john_doe", "password123"));
        users.add(new User("jane_doe", "mypassword"));
        users.add(new User("alice_smith", "alicepass"));
    }

    // POST: Registrierung eines neuen Benutzers
    @PostMapping("/register")
    public String register(@RequestBody User newUser) {
        // Überprüfen, ob der Benutzername bereits existiert
        for (User user : users) {
            if (user.getUsername().equalsIgnoreCase(newUser.getUsername())) {
                return "Benutzername bereits vergeben: " + newUser.getUsername();
            }
        }
        users.add(newUser);
        return "Benutzer erfolgreich registriert: " + newUser.getUsername();
    }

    // POST: Anmeldung eines Benutzers
    @PostMapping("/login")
    public String login(@RequestBody User loginUser) {
        for (User user : users) {
            if (user.getUsername().equals(loginUser.getUsername()) &&
                    user.getPassword().equals(loginUser.getPassword())) {
                return "Login erfolgreich für Benutzer: " + user.getUsername();
            }
        }
        return "Ungültiger Benutzername oder Passwort!";
    }

    // GET: Gibt die Liste aller Benutzer zurück (zum Testen)
    @GetMapping
    public List<User> getUsers() {
        return users;
    }

    // DELETE: Löscht einen Benutzer basierend auf dem Benutzernamen
    @DeleteMapping("/{username}")
    public String deleteUser(@PathVariable String username) {
        boolean removed = users.removeIf(user -> user.getUsername().equalsIgnoreCase(username));
        return removed ? "Benutzer erfolgreich gelöscht: " + username : "Benutzername nicht gefunden!";
    }
}
