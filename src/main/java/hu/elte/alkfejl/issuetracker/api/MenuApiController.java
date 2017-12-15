/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.elte.alkfejl.issuetracker.api;
 
import hu.elte.alkfejl.issuetracker.model.Menu;
import static hu.elte.alkfejl.issuetracker.model.User.Role.BOSS;
import static hu.elte.alkfejl.issuetracker.model.User.Role.MAJOR;
import static hu.elte.alkfejl.issuetracker.model.User.Role.USER;
import hu.elte.alkfejl.issuetracker.service.MenuService;
import hu.elte.alkfejl.issuetracker.service.annotations.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
 
@RestController
@RequestMapping("/api/menus")
public class MenuApiController {
   
   
    @Autowired
    private MenuService menuService;
   
    @Role({USER, MAJOR, BOSS})
    @GetMapping
    private ResponseEntity<Iterable<Menu>> list() {
        Iterable<Menu> menus = menuService.menus();
        return ResponseEntity.ok(menus);
    }
   
   
    @Role(BOSS)
    @PostMapping
    private ResponseEntity<Menu> create(@RequestBody Menu menu) {
        Menu saved = menuService.create(menu);
        return ResponseEntity.ok(saved);
    }
   
   
    @Role({USER, MAJOR, BOSS})
    @GetMapping("/{id}")
    private ResponseEntity<Menu> read(@PathVariable String id) {
        Menu read = menuService.read(Integer.parseInt(id));
        return ResponseEntity.ok(read);
    }
   
    @Role(BOSS)
    @DeleteMapping("/{id}")
    private ResponseEntity delete(@PathVariable int id) {
        menuService.delete(id);
        return ResponseEntity.ok().build();
    }
   
    @Role(BOSS)
    @PutMapping("/{id}")
    private ResponseEntity<Menu> update(@PathVariable int id, @RequestBody Menu menu) {
        Menu updated = menuService.update(id, menu);
        return ResponseEntity.ok(updated);
    }
}