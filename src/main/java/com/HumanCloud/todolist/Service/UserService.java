package com.HumanCloud.todolist.Service;

import com.HumanCloud.todolist.DTO.RequestDTO.AddUserDTO;
import com.HumanCloud.todolist.DTO.ResponseDTO.ShowUserDTO;
import com.HumanCloud.todolist.Exceptions.UserNotFoundException;
import com.HumanCloud.todolist.Models.UserTable;
import com.HumanCloud.todolist.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public ResponseEntity<UserTable> addUser(AddUserDTO addUserDTO) {

        UserTable user = new UserTable();
        user.setFirstName(addUserDTO.getFirstName());
        user.setLastName(addUserDTO.getLastName());
        user.setPhoneNumber(addUserDTO.getPhoneNumber());
        userRepository.save(user);

        return new ResponseEntity<>(user,HttpStatus.CREATED);
    }

    public String deleteUser(Integer userId) {

        UserTable userTable = userRepository.findById(userId).orElse(null);

        if(userTable == null){
            throw new UserNotFoundException("Id is already deleted from database Or Id doesn't exist");
        }

        userRepository.delete(userTable);
        return "The user has been deleted";
    }

    public ShowUserDTO getUser(Integer userId) {


        UserTable user = userRepository.findById(userId).orElse(null);

        if(user == null){
            throw new UserNotFoundException("This Id doesn't exist in the database"+userId);
        }

        ShowUserDTO showUserDTO = new ShowUserDTO();
        showUserDTO.setFirstName(user.getFirstName());
        showUserDTO.setLastName(user.getLastName());
        showUserDTO.setPhoneNumber(user.getPhoneNumber());
        showUserDTO.setNumberOfTasks(user.getTasks().size());

        return showUserDTO;
    }
}
