package Service;

import Model.ToDo;
import Repository.ToDoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class ToDoService {

    @Autowired
    private ToDoRepository toDoRepository;

    public Iterable<ToDo> getToDos() {
        return toDoRepository.findAll();
    }

    public Optional<ToDo> getToDoById(Long id) {
        return toDoRepository.findById(id);
    }

    public ToDo addToDo(ToDo toDo) {
        return toDoRepository.save(toDo);
    }

    public ToDo editToDo(ToDo toDo) {
        if (!toDoRepository.existsById(toDo.getId())) {
            return null;
        }
        return toDoRepository.save(toDo);
    }

    public boolean removeToDoById(Long id) {
        if (toDoRepository.existsById(id)) {
            toDoRepository.deleteById(id);
            return true;
        }
        return false;
    }
}

