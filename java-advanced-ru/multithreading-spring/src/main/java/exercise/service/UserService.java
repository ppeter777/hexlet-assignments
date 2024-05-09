package exercise.service;

import exercise.model.User;
import exercise.repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;


import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

//    @Autowired
//    UserService userService;

    public Flux<User> findAll() {
        return userRepository.findAll();
    }

    // BEGIN
    public Mono<User> create(User user) {
        return userRepository.save(user);
    }

    public Mono<User> findById(int userId) {
        return userRepository.findById(userId);
    }

    public Mono<User> delete(int userId) {
        var user = userRepository.findById(userId);
        userRepository.deleteById(userId);
        return user;
    }

    public Mono<User> update(User userData, int userId) {
//        userService.update(userData, userId);
//        userRepository.
        return userRepository.findById(userId);
    }
        // END
}
