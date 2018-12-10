package com.development.ordering.repository;

import com.development.ordering.model.Menu;
import org.springframework.data.repository.CrudRepository;

public interface MenuRepository extends CrudRepository<Menu, Long> {
    public Menu findMenuById(Long id);
}
