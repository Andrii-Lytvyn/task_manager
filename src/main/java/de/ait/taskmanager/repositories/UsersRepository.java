package de.ait.taskmanager.repositories;

import de.ait.taskmanager.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsersRepository extends JpaRepository<User,Long> {
}
