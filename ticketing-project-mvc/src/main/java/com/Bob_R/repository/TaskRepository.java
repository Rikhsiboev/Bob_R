package com.Bob_R.repository;

import com.Bob_R.entity.Project;
import com.Bob_R.entity.Task;
import com.Bob_R.entity.User;
import com.Bob_R.enums.Status;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface TaskRepository extends JpaRepository<Task, Long> {

    @Query("SELECT COUNT(t) FROM Task t WHERE t.project.projectCode = ?1 AND t.taskStatus <> 'COMPLETE'")
    int totalNonCompletedTasks(String projectCode);

    @Query(value = "SELECT COUNT(*) " +
            "FROM tasks t JOIN projects p on t.project_id=p.id " +
            "WHERE p.project_code=?1 AND t.task_status='COMPLETE'",nativeQuery = true)
    int totalCompletedTasks(String projectCode);


    List<Task> findAllByProject(Project project); // from db finding project which have some task which we have to delete

    List <Task> findAllByTaskStatusIsNotAndAssignedEmployee(Status status, User user);
    List <Task> findAllByTaskStatusAndAssignedEmployee(Status status, User user);
}
