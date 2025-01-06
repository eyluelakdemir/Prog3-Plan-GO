package Controller;

import Model.ToDo;
import Service.ToDoService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("/api/todos")
public class ToDoController {

    private final ToDoService toDoService;


    @GetMapping("/{id}")
    public ResponseEntity<ToDo> getToDoById(@PathVariable Long id) {
        return toDoService.getToDoById(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<ToDo> addToDo(@Valid @RequestBody ToDo toDo) {
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