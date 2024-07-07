package com.cydeo.service.impl;

import com.cydeo.dto.RoleDTO;
import com.cydeo.entity.Role;
import com.cydeo.mapper.MapperUtil;
import com.cydeo.repository.RoleRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class RoleServiceImplTest {

    @Mock
    RoleRepository roleRepository;

    @Mock
    MapperUtil mapperUtil;

    @InjectMocks
    RoleServiceImpl roleServiceImpl;

    @Test
    void listAllRoles() {
        // Arrange
        List<Role> roles = new ArrayList<>();
        Role role = new Role(); // Create a sample Role
        roles.add(role); // Add the sample Role to the list

        RoleDTO roleDTO = new RoleDTO(); // Create a sample RoleDTO

        when(roleRepository.findAll()).thenReturn(roles);
        when(mapperUtil.convert(any(Role.class), any(RoleDTO.class))).thenReturn(roleDTO);

        // Act
        List<RoleDTO> result = roleServiceImpl.listAllRoles();

        // Assert
        verify(roleRepository).findAll();
        verify(mapperUtil).convert(any(Role.class), any(RoleDTO.class));
        assertEquals(1, result.size());
        assertEquals(roleDTO, result.get(0));
    }


    @Test
    void findById() {
        Role role = new Role();
        role.setId(1L);
        RoleDTO roleDTO = new RoleDTO();

        when(roleRepository.findById(role.getId())).thenReturn(Optional.of(role));
        when(mapperUtil.convert(any(Role.class),any(RoleDTO.class))).thenReturn(roleDTO);

        RoleDTO result = roleServiceImpl.findById(role.getId());

        verify(roleRepository).findById(role.getId());
        verify(mapperUtil).convert(any(Role.class),any(RoleDTO.class));
        assertEquals(roleDTO, result);
    }
}