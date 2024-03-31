package exercise.controller;

import org.junit.jupiter.api.Test;
import static net.javacrumbs.jsonunit.assertj.JsonAssertions.assertThatJson;
import static org.assertj.core.api.Assertions.assertThat;
import org.instancio.Instancio;
import org.instancio.Select;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;

import java.util.HashMap;
import com.fasterxml.jackson.databind.ObjectMapper;
import net.datafaker.Faker;
import exercise.repository.TaskRepository;
import exercise.model.Task;

// BEGIN
@SpringBootTest
@AutoConfigureMockMvc
// END
class ApplicationTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private Faker faker;

    @Autowired
    private ObjectMapper om;

    @Autowired
    private TaskRepository taskRepository;


    @Test
    public void testWelcomePage() throws Exception {
        var result = mockMvc.perform(get("/"))
                .andExpect(status().isOk())
                .andReturn();

        var body = result.getResponse().getContentAsString();
        assertThat(body).contains("Welcome to Spring!");
    }

    @Test
    public void testIndex() throws Exception {
        var result = mockMvc.perform(get("/tasks"))
                .andExpect(status().isOk())
                .andReturn();

        var body = result.getResponse().getContentAsString();
        assertThatJson(body).isArray();
    }


    private Task generateTask() {
        return Instancio.of(Task.class)
                .ignore(Select.field(Task::getId))
                .supply(Select.field(Task::getTitle), () -> faker.lorem().word())
                .supply(Select.field(Task::getDescription), () -> faker.lorem().paragraph())
                .create();
    }

    // BEGIN
    @Test
    public void testCreateTask() throws Exception {

        var data = new HashMap<>();
        data.put("title", "Mike");
        data.put("description","fakepost");
        var request = post("/tasks")
                .contentType(MediaType.APPLICATION_JSON)
                .content(om.writeValueAsString(data));
        var result = mockMvc.perform(request)
                .andExpect(status().isCreated())
                .andReturn();
        var body = result.getResponse().getContentAsString();
        assertThatJson(body).isObject().containsEntry("title", "Mike");
        var task = taskRepository.findByTitle("Mike");
        assertThat(task.isPresent()).isTrue();
        assertThat(task.get().getDescription()).isEqualTo("fakepost");

        var id = task.get().getId();
        var request3 = get("/tasks/" + id);
        var result3 = mockMvc.perform(request3)
                .andExpect(status().isOk())
                .andReturn();
        var body2 = result3.getResponse().getContentAsString();
        assertThatJson(body2).isObject().containsEntry("title", "Mike");

        var data4 = new HashMap<>();
        data4.put("title", "John");
        data4.put("description","fakepost2");
        var request4 = put("/tasks/" + id)
                .contentType(MediaType.APPLICATION_JSON)
                .content(om.writeValueAsString(data4));;
        var result4 = mockMvc.perform(request4)
                .andExpect(status().isOk())
                .andReturn();
        var body4 = result4.getResponse().getContentAsString();
        assertThatJson(body4).isObject().containsEntry("title", "John");
        var task4 = taskRepository.findById(id);
        assertThat(task4.isPresent()).isTrue();
        assertThat(task4.get().getDescription()).isEqualTo("fakepost2");

        var request2 = delete("/tasks/" + id);
        var result2 = mockMvc.perform(request2)
                .andExpect(status().isOk());
        var task2 = taskRepository.findByTitle("Mike");
        assertThat(task2.isPresent()).isFalse();
    }
}
