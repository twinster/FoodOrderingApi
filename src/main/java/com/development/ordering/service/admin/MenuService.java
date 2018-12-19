package com.development.ordering.service.admin;

import com.development.ordering.model.Menu;
import com.development.ordering.repository.MenuRepository;
import org.apache.velocity.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class MenuService {
    @Autowired
    MenuRepository menuRepository;

    public List<Menu> getAllMenus(){
        List<Menu> menus = new ArrayList<>();
        menuRepository.findAll().forEach(menus::add);
        return menus;
    }

    public Menu getMenu(long id) throws ResourceNotFoundException{
        try {
            return menuRepository.findMenuById(id);
        }catch (ResourceNotFoundException e){
            throw new ResourceNotFoundException("Menu not found with id ::" + id);
        }
    }

    public Menu addOrUpdateMenu(Menu menu){
        return menuRepository.save(menu);
    }

    public boolean deleteMenu(long id) throws ResourceNotFoundException {
        try{
            menuRepository.deleteById(id);
            return true;
        }catch (Exception e){
            throw new ResourceNotFoundException("Menu not found with id :: " + id);
        }
    }
}
