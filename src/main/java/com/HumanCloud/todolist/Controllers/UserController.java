package com.HumanCloud.todolist.Controllers;

import com.HumanCloud.todolist.DTO.RequestDTO.AddUserDTO;
import com.HumanCloud.todolist.DTO.ResponseDTO.ShowUserDTO;
import com.HumanCloud.todolist.Models.UserTable;
import com.HumanCloud.todolist.Service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping("/add_user")
    public ResponseEntity<UserTable> addUser(@Valid @RequestBody AddUserDTO addUserDTO){
        return userService.addUser(addUserDTO);
    }

    @DeleteMapping("/delete_user")
    public String deleteUser(@RequestParam Integer userId){
        return userService.deleteUser(userId);
    }

    @GetMapping("/get_user")
    public ShowUserDTO getUser(@RequestParam Integer userId){
        return userService.getUser(userId);
    }
}
