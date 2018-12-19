package com.development.ordering.controller.admin;

import com.development.ordering.model.Menu;
import com.development.ordering.service.admin.MenuService;
import org.apache.velocity.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/admin/menus")
@PreAuthorize("hasAuthority('ADMIN')")
public class MenuController {
    @Autowired
    private MenuService menuService;

    @RequestMapping(method= RequestMethod.GET, value="/list")
    public List<Menu> getAllMenus() {
        return menuService.getAllMenus();
    }

    @RequestMapping(method=RequestMethod.POST, value="/")
    public ResponseEntity<Menu> createMenu(@Valid @RequestBody Menu menu) {
        return ResponseEntity.ok().body(menuService.addOrUpdateMenu(menu));
    }

    @RequestMapping(method=RequestMethod.GET, value="/{id}/edit")
    public Menu getMenu(@PathVariable long id) throws ResourceNotFoundException {
        return menuService.getMenu(id);
    }

    @RequestMapping(method=RequestMethod.PUT, value="/{id}")
    public ResponseEntity<Menu> updateMenu(@RequestBody Menu menu, @PathVariable(value = "id") long id) {
        return  ResponseEntity.ok().body(menuService.addOrUpdateMenu(menu));
    }

    @RequestMapping(method=RequestMethod.DELETE, value="/{id}")
    public ResponseEntity<?> deleteMenu(@PathVariable(value = "id") long id) throws ResourceNotFoundException {
        menuService.deleteMenu(id);
        return ResponseEntity.ok().build();
    }


}
