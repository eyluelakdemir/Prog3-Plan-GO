package PlanGo.webtech.controller;

import PlanGo.webtech.model.ToDo;
import PlanGo.webtech.service.ToDoService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("/api/todos")
public class ToDoController {

    private final ToDoService toDoService;


    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Iterable<ToDo>> getAllBudgetEntries() {
        return ResponseEntity.ok(toDoService.getToDos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ToDo> getToDoById(@PathVariable Long id) {
        return toDoService.getToDoById(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<ToDo> addToDo(@Valid @RequestBody ToDo toDo) {
        // Stelle sicher, dass "text" und "category" korrekt gesetzt sind
        if (toDo.getText() == null || toDo.getCategory() == null) {
            return ResponseEntity.badRequest().build();
        }

        ToDo created = toDoService.addToDo(toDo);
        return new ResponseEntity<>(created, HttpStatus.CREATED);
    }


    @PutMapping("/{id}")
    public ResponseEntity<ToDo> updateToDo(@PathVariable Long id, @RequestBody ToDo toDo) {
        toDo.setId(id);
        ToDo updated = toDoService.editToDo(toDo);
        return updated == null ? ResponseEntity.notFound().build() : ResponseEntity.ok(updated);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteToDo(@PathVariable Long id) {
        return toDoService.removeToDoById(id) ? ResponseEntity.noContent().build() : ResponseEntity.notFound().build();
    }
}