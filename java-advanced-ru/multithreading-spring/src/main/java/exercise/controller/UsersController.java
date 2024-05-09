package exercise.controller;

import exercise.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import exercise.service.UserService;


@RestController
@RequestMapping("/users")
public class UsersController {

    @Autowired
    private UserService userService;

    @GetMapping(path = "")
    public Flux<User> getUsers() {
        return userService.findAll();
    }

    // BEGIN
    @GetMapping(path = "/{id}")
    public Mono<User> getUser(@PathVariable int id) {
        return userService.findById(id);
    }

    @PostMapping(path = "")
    public Mono<User> createCar(@RequestBody User user) {
        return userService.create(user);
    }

    @PutMapping(path = "/{id}")
    public Mono<User> update(@RequestBody User userData, int id) {
        return userService.update(userData, id);
    }

    @DeleteMapping(path = "/{id}")
        public Mono<User> delete(@PathVariable int id) {
        var user = userService.findById(id);
        userService.delete(id);
        return user;
    }
    // END
}
