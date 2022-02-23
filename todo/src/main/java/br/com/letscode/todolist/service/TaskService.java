package br.com.letscode.todolist.service;

import br.com.letscode.todolist.exception.TaskNotFoundException;
import br.com.letscode.todolist.model.Task;
import br.com.letscode.todolist.repository.TaskRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.util.Streamable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TaskService {

    private final TaskRepository taskRepository;

    public List<Task> getAll(){
        return Streamable.of(taskRepository.findAll()).toList();
    }

    public Task insert(Task task){
        return taskRepository.save(task);
    }

    public Task getById(Integer id){
        var optionalTask = taskRepository.findById(id);
        if(optionalTask.isPresent()){
            return optionalTask.get();
        }
        throw new TaskNotFoundException();
    }
}
