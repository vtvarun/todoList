package com.HumanCloud.todolist.Controllers;

import com.HumanCloud.todolist.DTO.RequestDTO.AddTaskDTO;
import com.HumanCloud.todolist.DTO.ResponseDTO.ShowTaskDTO;
import com.HumanCloud.todolist.Models.Task;
import com.HumanCloud.todolist.Service.TaskService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/task")
public class TaskController {

    @Autowired
    TaskService taskService;
    @PostMapping("/add_task")
    public ResponseEntity<ShowTaskDTO> addTask(@RequestBody AddTaskDTO addTaskDTO){
        return taskService.addTask(addTaskDTO);
    }

    @GetMapping("/get_tasks_by_userId")
    public List<Task> getTasks(@RequestParam Integer userId){
        return taskService.getTasks(userId);
    }

    @GetMapping("/get_important_tasks")
    public List<Task> getImportantTasks(@RequestParam Integer userId){
        return taskService.getImportantTasks(userId);
    }

    @GetMapping("/get_UnImportant_tasks")
    public List<Task> getUnimportantTasks(@RequestParam Integer userId){
        return taskService.getUnimportantTasks(userId);
    }

    @PutMapping("/make_task_important")
    public String makeImportant(@RequestParam Integer taskId){
        log.info("ENTERED TASK CONTROLLER : GOING TO TASK SERVICE TO MAKE TASL IMPORTANT");
        return taskService.makeImportant(taskId);
    }

    @PutMapping("/complete_task")
    public String taskComplete(@RequestParam Integer taskId){
        return taskService.completeTask(taskId);
    }


    @DeleteMapping("/delete_task")
    public String deleteTask(@RequestParam Integer taskId){
        return taskService.deleteTask(taskId);
    }

}
