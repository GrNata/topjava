package ru.javawebinar.topjava.web.user;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import ru.javawebinar.topjava.model.Role;
import ru.javawebinar.topjava.model.User;

import java.util.List;

@RestController
@RequestMapping("/admin/users")
public class AdminUIController extends AbstractUserController {

    @Override
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<User> getAll() {
        return super.getAll();
    }

    @PostMapping
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void createOrUpdate(@RequestParam Integer id,
                               @RequestParam String name,
                               @RequestParam String email,
                               @RequestParam String password) {

        User user = new User(id, name, email, password, Role.USER);
        if (user.isNew()) {
            super.create(user);
        }
    }

    @Override
    @DeleteMapping("/{id}")
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void delete(@PathVariable int id) {
        System.out.println("DELETE !!! id = "+id);
        super.delete(id);
    }
}
