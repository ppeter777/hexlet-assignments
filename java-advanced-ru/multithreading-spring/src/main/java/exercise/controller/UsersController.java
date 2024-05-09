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

    @PatchMapping(path = "/{id}")
    public Mono<User> update(@RequestBody User userData, @PathVariable int id) {
        return userService.update(id, userData);
    }

    @DeleteMapping(path = "/{id}")
        public Mono<Void> delete(@PathVariable int id) {
        return userService.delete(id);
    }
    // END
}
