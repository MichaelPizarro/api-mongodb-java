package com.example.controller;

import com.example.model.Task;
import com.example.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tasks")
public class TaskController {

    @Autowired
    private TaskService taskService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Task createTask(@RequestBody Task task){

        return taskService.addTask(task);
    }

    @GetMapping
    public List<Task> getTasks(){
        return taskService.findAllTasks();
    }

    @GetMapping("/{taskId}")
    public Task getTask(@PathVariable String taskId){
        return taskService.getTaskByTaskId(taskId);
    }

    @GetMapping("/severity/{severity}")
    public List<Task> getTaskWithSeverity(@PathVariable int severity){
        return taskService.getTasksBySeverity(severity);
    }

    @GetMapping("/assignee/{assignee}")
    public List<Task> getTaskByAssignee(@PathVariable String assignee){
        return taskService.getTasksByAssignee(assignee);
    }

    @PutMapping
    public Task modifyTask(@RequestBody Task task){

        return taskService.updateTask(task);
    }

    @DeleteMapping("/{taskId}")
    public String deleteTask(@PathVariable String taskId){

        return taskService.deleteTask(taskId);
    }





}
