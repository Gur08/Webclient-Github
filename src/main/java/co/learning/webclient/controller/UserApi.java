package co.learning.webclient.controller;

import co.learning.webclient.entity.User;
import co.learning.webclient.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.Optional;

@RestController
@RequestMapping("/app")
public class UserApi {
    @Autowired
    UserRepo repo;

    @Autowired
    WebClient webClient;

    @GetMapping("/user/{loginName}")
    public User getUser(@PathVariable String loginName){
        Optional<User> optional = repo.findById(loginName);
        if (!optional.isPresent()){
            User user = getUserbyId(loginName).block();
            repo.save(user);
        optional = repo.findById(loginName);
        }
        return optional.get();
    }
    private Mono<User> getUserbyId(String loginName){
        Mono<User> userMono = webClient.get()
                .uri("https://api.github.com/users/{loginName}",loginName)
                .retrieve()
                .bodyToMono(User.class);
return userMono;
    }

}
/*
.uri("https://api.github.com/users/"+loginName)
        .retrieve().bodyToMono(User.class);*/
