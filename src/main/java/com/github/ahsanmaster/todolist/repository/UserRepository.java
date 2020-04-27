package com.github.ahsanmaster.todolist.repository;

import com.github.ahsanmaster.todolist.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
