package com.rest.controller;

import com.rest.client.EmployeeClient;
import com.rest.client.UserClient;
import com.rest.dto.ResponseWrapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;


@RestController
public class Consume_FeignClient {

    private final UserClient userClient;
    private final EmployeeClient employeeClient;

    public Consume_FeignClient(UserClient userClient, EmployeeClient employeeClient) {
        this.userClient = userClient;
        this.employeeClient = employeeClient;
    }

    @GetMapping("/api/v1/users")
    public ResponseEntity<ResponseWrapper> getUsers() {
        return ResponseEntity.ok(new ResponseWrapper("UserList Retrieved", userClient.getUsers()));
    }

    @GetMapping("/api/v1/employee")
    public ResponseEntity<ResponseWrapper> getEmployee() {
        return ResponseEntity
                .ok(new ResponseWrapper("Retrieved", employeeClient.getEmployee("6298ebfecd0551211fce37a6")));
    }

}
