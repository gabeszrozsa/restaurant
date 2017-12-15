package hu.elte.alkfejl.issuetracker.service;

import hu.elte.alkfejl.issuetracker.model.Menu;
import hu.elte.alkfejl.issuetracker.repository.MenuRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MenuService {
    
    @Autowired
    private MenuRepository menuRepository;
    
    public Iterable<Menu> menus() {
        return menuRepository.findAll();
    }
    
    public Menu create(Menu menu) {
        return menuRepository.save(menu);
    }
    
    public Menu read(int id) {
        return menuRepository.findOne(id);
    }
    
    public void delete(int id) {
        menuRepository.delete(id);
    }
    
    public Menu update(int id, Menu menu) {
        Menu currentMenu = menuRepository.findOne(id);

        currentMenu.setType(menu.getType());
        currentMenu.setName(menu.getName());
        return menuRepository.save(currentMenu);
    }
}
