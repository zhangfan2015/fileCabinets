package org.uarrive.filecabinets.Controllor;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.uarrive.filecabinets.Entity.BDemoEntity;
import org.uarrive.filecabinets.Repository.UserRepository;

import java.util.List;


@RestController
@RequestMapping("/hi")
public class Hello {
    private final UserRepository userRepository;

    public Hello(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    @GetMapping("/hello1")
    public Page<BDemoEntity> hello1(String name, Integer id) {
        Pageable pageable = PageRequest.of(0, 10);
        return userRepository.findAllByNameContaining(name, pageable);
    }

    @GetMapping("/hello2")
    public List<BDemoEntity> hello2(String name, Integer id) {
        return userRepository.testPerson(id, name);
    }

}
