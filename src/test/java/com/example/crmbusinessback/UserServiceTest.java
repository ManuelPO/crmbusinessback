package com.example.crmbusinessback;

import com.example.crmbusinessback.model.entity.User;
import com.example.crmbusinessback.service.UserService;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class UserServiceTest {

    @Autowired
    public UserService userService;


    @ParameterizedTest
    @MethodSource("generator")
    public void loginTestWithRightCredentialsAndWithWrongCredentials (User goodUser, User badUser){
        boolean goodUserStatus = userService.login(goodUser);
        boolean badUserStatus = userService.login(badUser);
        assertAll(()->assertTrue(goodUserStatus), ()->assertFalse(badUserStatus));
    }

    private static Stream<Arguments> generator(){
        return Stream.of(
                Arguments.of(new User("firstAdmin", "12345"), new User("secondAdmin", "22222")));
    }

//    @Test
//    public void createUser (){
//        userService.borrarLuego();
//
//    }
}
