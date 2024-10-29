package PlanGo.webtech;


import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/user")
public class UserController {
    private List<User> users = new ArrayList<>();

    // Registrierung eines neuen Benutzers
    @PostMapping("/register")
    public String register(@RequestBody User user) {
        users.add(user);
        return "Benutzer erfolgreich registriert!";
    }

    // Anmeldung eines Benutzers
    @PostMapping("/login")
    public String login(@RequestBody User user) {
        for (User u : users) {
            if (u.getUsername().equals(user.getUsername()) && u.getPassword().equals(user.getPassword())) {
                return "Login erfolgreich für Benutzer: " + u.getUsername();
            }
        }
        return "Ungültiger Benutzername oder Passwort!";
    }
}
