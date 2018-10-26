package com.development.ordering.repository;

import com.development.ordering.model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {
    public User findByUsername(String username);
    public List<User> findByUserRoleId(Long id);
    public List<User> findByUserRoleName(String userRoleName);
    public void delete(Long id);
    public User findOne(Long id);
}
