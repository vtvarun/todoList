package com.HumanCloud.todolist.DTO.ResponseDTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ShowTaskDTO {

    private String taskName;

    private LocalDate taskDueDate;

    private boolean isImportant;

    private boolean isPlanned;

    private boolean isCompleted;

    private String assignedBy;
}
