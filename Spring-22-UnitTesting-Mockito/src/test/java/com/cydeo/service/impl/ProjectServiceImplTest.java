package com.cydeo.service.impl;

import com.cydeo.dto.ProjectDTO;
import com.cydeo.entity.Project;
import com.cydeo.mapper.ProjectMapper;
import com.cydeo.repository.ProjectRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class ProjectServiceImplTest {

    @Mock
    ProjectRepository projectRepository;

    @Mock
    ProjectMapper projectMapper;

    @InjectMocks
    ProjectServiceImpl projectService;

    @Test
    void getByProjectCode_test() {

        // Given
        when(projectRepository.findByProjectCode(anyString())).thenReturn(new Project());
        when(projectMapper.convertToDto(new Project())).thenReturn( new ProjectDTO());

        // When
        ProjectDTO projectDTO1 = projectService.getByProjectCode(anyString());

        // Then
        verify(projectRepository).findByProjectCode(anyString());
        verify(projectMapper).convertToDto(any(Project.class));

        assertNotNull(projectDTO1);

    }

    @Test
    void getByProjectCode_exception_test() {

        when(projectRepository.findByProjectCode(" ")).thenThrow(new RuntimeException("Project Not Found"));

        Throwable exception = assertThrows(RuntimeException.class, () -> projectService.getByProjectCode(""));

//        verify(projectRepository).findByProjectCode(anyString());

        assertEquals("Project Not Found", exception.getMessage());

    }

    @Test
    void save_test() {

        ProjectDTO projectDTO = new ProjectDTO();
        Project project = new Project();

        when(projectMapper.convertToEntity(projectDTO)).thenReturn(project);
        when(projectRepository.save(project)).thenReturn(project);

        projectService.save(projectDTO);

        verify(projectRepository).save(project);
        verify(projectMapper).convertToEntity(any(ProjectDTO.class));

    }

    @Test
    void listOfProjects_test() {

        // Arrange
        List<Project> projects = new ArrayList<>();
        projects.add(new Project()); // Add a sample project to the list
        when(projectRepository.findAll()).thenReturn(projects);
        when(projectMapper.convertToDto(any(Project.class))).thenReturn(new ProjectDTO()); // Mock the mapper behavior

        // Act
        projectService.listAllProjects();

        // Assert
        verify(projectRepository).findAll();
        verify(projectMapper).convertToDto(any(Project.class));

    }

}
