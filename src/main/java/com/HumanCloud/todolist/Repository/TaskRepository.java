package com.HumanCloud.todolist.Repository;

import com.HumanCloud.todolist.Models.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface TaskRepository extends JpaRepository<Task, Integer> {

    @Query(value = "SELECT * FROM task WHERE assigned_by_user_id = :userId",nativeQuery = true)
    List<Task> getAllTasks(@Param("userId") Integer userId);

    @Query(value = "SELECT * FROM task WHERE assigned_by_user_id = :userId AND is_important = true",nativeQuery = true)
    List<Task> getImportantTasks(@Param("userId") Integer userId);

    @Query(value = "SELECT * FROM task WHERE assigned_by_user_id = :userId AND is_important = false",nativeQuery = true)
    List<Task> getUnimportantTasks(@Param("userId") Integer userId);
}
