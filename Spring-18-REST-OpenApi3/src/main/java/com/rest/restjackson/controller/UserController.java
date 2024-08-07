package com.rest.restjackson.controller;

import com.rest.restjackson.entity.User;
import com.rest.restjackson.repository.UserRepository;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
@Tag(name = "User", description = "User CRUD Operations")
@AllArgsConstructor
public class UserController {

    private final UserRepository userRepository;

    @GetMapping("/users")
    @Operation(summary = "Read all users")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully retrieved users (OK)",
                    content = {@Content(mediaType = "application/json")}),
            @ApiResponse(responseCode = "400", description = "Something went wrong", content = @Content),
            @ApiResponse(responseCode = "404", description = "Not Found", content = @Content)
    })
    public List<User> readAllUsers() {
        return userRepository.findAll();
    }
}
