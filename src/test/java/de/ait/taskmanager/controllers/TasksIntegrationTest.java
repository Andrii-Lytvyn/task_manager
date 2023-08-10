package de.ait.taskmanager.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import de.ait.taskmanager.dto.NewTaskDto;

import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.web.servlet.MockMvc;

import java.time.LocalDate;

import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@DisplayName("TaskController is works: ")
@DisplayNameGeneration(value = DisplayNameGenerator.ReplaceUnderscores.class)
@ActiveProfiles("test")
class TasksIntegrationTest {

    private static final NewTaskDto NEW_TASK = NewTaskDto.builder()
            .title("Test Task")
                    .aboutUserId(1L)
                    .startDate(LocalDate.parse("2023-12-02"))
            .finishDate(LocalDate.parse("2023-12-12"))
            .build();

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Nested
    @DisplayName("POST /api/tasks is works: ")
    class AddArticleTest {

        @Test
        @Sql(scripts = "/sql/tasks.sql")
        @DirtiesContext(methodMode = DirtiesContext.MethodMode.AFTER_METHOD)
        public void add_task_for_exist_user() throws Exception {

            String body = objectMapper.writeValueAsString(NEW_TASK);

            mockMvc.perform(post("/api/tasks")
                            .header("Content-Type", "application/json")
                            .content(body))
                    .andExpect(status().isCreated())
                    .andExpect(jsonPath("$.id", is(1)))
                    .andExpect(jsonPath("$.text", is("Test Task")))
                    .andExpect(jsonPath("$.startDate", is("2023-12-02")))
                    .andExpect(jsonPath("$.finishDate", is("2023-12-12")))
                    .andExpect(jsonPath("$.about.id", is(1)))
                    .andExpect(jsonPath("$.about.email", is("test@mail.com")));
        }

        @Test
        public void add_task_for_not_exist_user() throws Exception {
            String body = objectMapper.writeValueAsString(NEW_TASK);

            mockMvc.perform(post("/api/tasks")
                            .header("Content-Type", "application/json")
                            .content(body))
                    .andExpect(status().isUnprocessableEntity());
        }
    }
}