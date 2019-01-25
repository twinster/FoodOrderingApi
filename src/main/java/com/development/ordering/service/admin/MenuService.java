package com.development.ordering.service.admin;

import com.development.ordering.model.Menu;
import com.development.ordering.repository.MenuRepository;
import org.apache.velocity.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

@Service
@Transactional
public class MenuService {
    @Autowired
    MenuRepository menuRepository;

    @Autowired
    private EntityManager em;

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
//        if (week.equals("current")){
//            Date date = new Date();
//            Calendar cal = Calendar.getInstance();
//            cal.setTime(date);
//            menu.setWeekNum(cal.get(Calendar.WEEK_OF_YEAR));
//        }
        return menuRepository.save(menu);
    }

    public boolean deleteMenu(long id){
        try{
            menuRepository.deleteMenuById(id);
            return true;
        }catch (Exception e){
            throw e;
        }
    }
}
