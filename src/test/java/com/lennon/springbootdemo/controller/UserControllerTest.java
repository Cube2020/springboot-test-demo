package com.lennon.springbootdemo.controller;

import com.lennon.springbootdemo.domain.User;
import com.lennon.springbootdemo.service.UserService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.reactive.server.WebTestClient;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.doReturn;


@WebFluxTest(controllers = UserController.class)
public class UserControllerTest {

    @Autowired
    private WebTestClient webTestClient;

    @Autowired
    private TestRestTemplate restTemplate;

    @Mock
    private UserService userService;

    @Test
    public void getUsersByIdTestWithWeb() {
        this.webTestClient.get().uri("/users/{id}", 1001).exchange().expectStatus().isOk().expectBody().jsonPath("$.age")
                .isEqualTo(29);

    }

    @Test
    public void getUsersByIdTestWithReturn() {
        User expectedUser = new User(20200717024001L,"lennon",30);
        doReturn(expectedUser).when(userService).findUserByUserId(anyLong());
        this.webTestClient.get().uri("/users/{id}", 1001).exchange().expectStatus().isOk().expectBody().jsonPath("$.age")
                .isEqualTo(30);

    }

    @Test
    public void getUsersByIdTestWithRest() {
        ResponseEntity<User> user = this.restTemplate.getForEntity("/users/{id}", User.class, 1001);
        Assertions.assertAll("user", () -> Assertions.assertEquals(20200717024001L, user.getBody().getId()),
                () -> assertEquals("lennon", user.getBody().getName()));
    }
}
