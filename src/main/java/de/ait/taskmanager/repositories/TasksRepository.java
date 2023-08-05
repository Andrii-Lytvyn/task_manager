package de.ait.taskmanager.repositories;

import de.ait.taskmanager.models.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TasksRepository extends JpaRepository<Task,Long> {
}
