package com.example.crmbusinessback;

import com.example.crmbusinessback.model.entity.User;
import com.example.crmbusinessback.service.UserService;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
public class UserServiceTest {

    @Autowired
    public UserService userService;


    @ParameterizedTest
    @MethodSource("generator")
    public void loginTest (User user){
        boolean status = userService.login(user);
        assertTrue(status);
    }

    private static Stream<Arguments> generator(){
        return Stream.of(
                Arguments.of(new User("firstAdmin", "12345")),
                Arguments.of(new User("secondAdmin", "54321")));
    }
}
