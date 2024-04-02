package com.HumanCloud.todolist.DTO.RequestDTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AddTaskDTO {

    private Integer userId;

    private String taskName;

    private LocalDate taskDueDate;

    private Boolean isImportant;

    private Boolean isPlanned;
}
