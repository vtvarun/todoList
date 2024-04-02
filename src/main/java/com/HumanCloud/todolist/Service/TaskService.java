package com.HumanCloud.todolist.Service;

import com.HumanCloud.todolist.DTO.RequestDTO.AddTaskDTO;
import com.HumanCloud.todolist.DTO.ResponseDTO.ShowTaskDTO;
import com.HumanCloud.todolist.Models.Task;
import com.HumanCloud.todolist.Models.UserTable;
import com.HumanCloud.todolist.Repository.TaskRepository;
import com.HumanCloud.todolist.Repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class TaskService {
    @Autowired
    TaskRepository taskRepository;

    @Autowired
    UserRepository userRepository;

    public ResponseEntity<ShowTaskDTO> addTask(AddTaskDTO addTaskDTO) {

        Task task = new Task();
        task.setTaskName(addTaskDTO.getTaskName());
        task.setTaskDueDate(addTaskDTO.getTaskDueDate());

        task.setPlanned(addTaskDTO.getIsPlanned());
        task.setImportant(addTaskDTO.getIsImportant());
        task.setCompleted(false);

        UserTable user = userRepository.getById(addTaskDTO.getUserId());
        task.setAssignedBy(user);

        taskRepository.save(task);
        // I don't want to send the task id to the user as it is not important for the

        ShowTaskDTO showTaskDTO = new ShowTaskDTO();
        showTaskDTO.setTaskName(task.getTaskName());
        showTaskDTO.setTaskDueDate(task.getTaskDueDate());
        showTaskDTO.setImportant(task.isImportant());
        showTaskDTO.setPlanned(task.isPlanned());
        showTaskDTO.setCompleted(task.isCompleted());
        showTaskDTO.setAssignedBy(task.getAssignedBy().getFirstName());

        return new ResponseEntity<>(showTaskDTO,HttpStatus.CREATED);
    }

    public List<Task> getTasks(Integer userId) {

        List<Task> allTasks = taskRepository.getAllTasks(userId);

        return allTasks;
    }

    public List<Task> getImportantTasks(Integer userId) {

        List<Task> allImportantTasks = taskRepository.getImportantTasks(userId);


        return allImportantTasks;
    }

    public List<Task> getUnimportantTasks(Integer userId) {
        List<Task> allUnimportantTasks = taskRepository.getUnimportantTasks(userId);

        return allUnimportantTasks;
    }

    public String makeImportant(Integer taskId) {
        log.info("IN TASK SERVICE : GOING TO MAKE TASK IMPORTANT");

        Task task = taskRepository.getById(taskId);

        task.setImportant(true);

        taskRepository.save(task);

        log.info("TASK MADE IMPORTANT : END");

        return "The task has been made important";
    }

    public String completeTask(Integer taskId) {

        Task task = taskRepository.getById(taskId);

        task.setCompleted(true);

        taskRepository.save(task);

        return "The task has been marked complete";
    }

    public String deleteTask(Integer taskId) {
        taskRepository.deleteById(taskId);
        return "The task has been deleted";
    }
}
