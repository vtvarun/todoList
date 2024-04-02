package com.HumanCloud.todolist.Repository;

import com.HumanCloud.todolist.Models.Task;
import com.HumanCloud.todolist.Models.UserTable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UserRepository extends JpaRepository<UserTable, Integer> {

}
