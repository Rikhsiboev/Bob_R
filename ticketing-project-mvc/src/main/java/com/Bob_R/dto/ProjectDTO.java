package com.Bob_R.dto;

import com.Bob_R.enums.Status;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProjectDTO {
    private String name;
    private String projectCode;
    private UserDTO assignedManager;
    private LocalDate startDate;
    private LocalDate endDate;
    private String projectDetail;
    private Status projectStatus;


}
