package com.Bob_R.service.impl;

import com.Bob_R.dto.ProjectDTO;
import com.Bob_R.dto.TaskDTO;
import com.Bob_R.dto.UserDTO;
import com.Bob_R.enums.Status;
import com.Bob_R.service.ProjectService;
import com.Bob_R.service.TaskService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProjectServiceImp extends AbstractMapService <ProjectDTO,String>  implements ProjectService {
    private final TaskService taskService;

    public ProjectServiceImp(TaskService taskService) {
        this.taskService = taskService;
    }


    @Override
    public ProjectDTO save(ProjectDTO project) {

        if(project.getProjectStatus()==null) {
            project.setProjectStatus(Status.OPEN);
        }
        return super.save(project.getProjectCode(),project);
    }

    @Override
    public ProjectDTO findById(String projectCode) {
        return super.findById(projectCode);
    }

    @Override
    public List<ProjectDTO> findAll() {
        return super.findAll();
    }

    @Override
    public void deleteById(String id) {
        super.deleteById(id);
    }

    @Override
    public void update(ProjectDTO object) {
        if (object.getProjectStatus()==null){
            object.setProjectStatus(findById(object.getProjectCode()).getProjectStatus());
        }
        super.update(object.getProjectCode(),object);
    }


    @Override
    public void complete(ProjectDTO project) {
       project.setProjectStatus(Status.COMPLETE);
    }

    @Override
    public List<ProjectDTO> getCountedListOfProjectDTO(UserDTO manager) {
        List<ProjectDTO> projectList =
                findAll()
                        .stream()
                        .filter(project -> project.getAssignedManager().equals(manager))  //John
                        .map(project ->{

                            List<TaskDTO> taskList = taskService.findTasksByManager(manager);

                            int completeTaskCounts = (int) taskList.stream()
                                    .filter(t -> t.getProject().equals(project) && t.getTaskStatus() == Status.COMPLETE).count();
                            int unfinishedTaskCounts = (int) taskList.stream()
                                    .filter(t -> t.getProject().equals(project) && t.getTaskStatus() != Status.COMPLETE).count();

                            project.setCompleteTaskCounts(completeTaskCounts);
                            project.setUnfinishedTaskCounts(unfinishedTaskCounts);

                            return project;

                        })
                        .collect(Collectors.toList());

        return projectList;
    }
}
