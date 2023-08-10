package de.ait.taskmanager.repositories;

import de.ait.taskmanager.models.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsersRepository extends JpaRepository<User,Long> {
    Page<User> findAllByRole(User.Role role, Pageable pageable);
    Page<User> findAllByState(User.State state, Pageable pageable);
}
