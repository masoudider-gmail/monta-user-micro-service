package montauserservice.userservice.controller;

import montauserservice.userservice.service.MontaUserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;


import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@ExtendWith(MockitoExtension.class)
class myControllerTest {

    @Mock
    MontaUserService service;

    @InjectMocks
    MyController controller;

    MockMvc mockMvc;

    @BeforeEach
    void setUp() {

        mockMvc = MockMvcBuilders.standaloneSetup(controller).build();

    }

    @Test
    void getAllUsers() throws Exception {

        mockMvc.perform(
                get("/users")
        ).andExpect(
                status().isOk()
        ).andExpect(
                content().contentType(MediaType.APPLICATION_JSON)
        );

        verify(service).findUsersAndTheNumberOfExams();
    }
}