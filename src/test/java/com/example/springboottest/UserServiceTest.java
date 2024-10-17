package com.example.springboottest;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class UserServiceTest {
    @InjectMocks
    private UserService userService;

    @Mock
    private UserRepository userRepository;

    @Test
    void testCreateUser() {
        User user = new User();
        user.setName("ahmed");
        user.setEmail("ahmed@gmail.com");
        when(userRepository.save(user)).thenReturn(user);

        User users = userService.createUser(user);
        assertEquals("ahmed", users.getName());
        verify(userRepository, times(1)).save(user);
    }


    @Test
    void testGetAllUsers() {
        User user = new User();
        user.setName("John Doe");
        user.setEmail("john@example.com");

        when(userRepository.findAll()).thenReturn(List.of(user));

        List<User> users = userService.getAllUsers();

        assertEquals(1, users.size());
        assertEquals("John Doe", users.get(0).getName());
    }

}
