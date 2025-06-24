package com.examly.springapp;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.io.File;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import jakarta.persistence.ManyToOne;

import java.lang.reflect.Field;
 
@SpringBootTest
@AutoConfigureMockMvc
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class SpringappApplicationTests {

    @Autowired
    private MockMvc mockMvc;

    // Day 15: Test Controller Directory Exists
    @Test
    @Order(1)
    public void backend_day15_testControllerDirectoryExists() {
        String directoryPath = "src/main/java/com/examly/springapp/controller";
        File directory = new File(directoryPath);
        assertTrue(directory.exists() && directory.isDirectory());
    }

    // Day 15: Test JobController File Exists
    @Test
    @Order(2)
    public void backend_day15_testControllerFileExists() {
        String filePath = "src/main/java/com/examly/springapp/controller/TestController.java";
        File file = new File(filePath);
        assertTrue(file.exists() && file.isFile());
    }

    // Day 15: Test Welcome API
    @Test
    @Order(3)
    public void backend_day15_testWelcomeApi() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/api/test/welcome"))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    // Day 16: Test Model Directory Exists
    @Test
    @Order(4)
    public void backend_day16_testModelDirectoryExists() {
        String directoryPath = "src/main/java/com/examly/springapp/model";
        File directory = new File(directoryPath);
        assertTrue(directory.exists() && directory.isDirectory());
    }

    // Day 16: Test Job Model File Exists
    @Test
    @Order(5)
    public void backend_day16_testJobModelFileExists() {
        String filePath = "src/main/java/com/examly/springapp/model/Job.java";
        File file = new File(filePath);
        assertTrue(file.exists() && file.isFile());
    }

    // Day 16: Test Get All Jobs API
    @Test
    @Order(6)
    public void backend_day16_testGetAllJobList() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/api/test/job")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(jsonPath("$").isArray())
                .andReturn();
    }

    // Day 17: Test JobController File Exists
    @Test
    @Order(7)
    public void backend_day17_testJobControllerFileExists() {
        String filePath = "src/main/java/com/examly/springapp/controller/JobController.java";
        File file = new File(filePath);
        assertTrue(file.exists() && file.isFile());
    }

    // Day 17: Test JobService File Exists
    @Test
    @Order(8)
    public void backend_day17_testJobServiceFileExists() {
        String filePath = "src/main/java/com/examly/springapp/service/JobService.java";
        File file = new File(filePath);
        assertTrue(file.exists() && file.isFile());
    }

    // Day 17: Test Add Job API
    @Test
    @Order(9)
    public void backend_day17_testAddJob() throws Exception {
        String jobData = "{\"title\": \"Software Developer\", \"description\": \"Develop and maintain software\", \"company\": \"Tech Corp\", \"location\": \"New York\"}";

        mockMvc.perform(MockMvcRequestBuilders.post("/api/jobs")
                .contentType(MediaType.APPLICATION_JSON)
                .content(jobData)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isCreated())
                .andExpect(jsonPath("$.title").value("Software Developer"))
                .andExpect(jsonPath("$.description").value("Develop and maintain software"))
                .andExpect(jsonPath("$.company").value("Tech Corp"))
                .andExpect(jsonPath("$.location").value("New York"))
                .andReturn();
    }

    // Day 18: Test Get All Jobs API
    @Test
    @Order(10)
    public void backend_day18_testGetAllJobs() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/api/jobs")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(jsonPath("$").isArray())
                .andReturn();
    }

    // Day 19: Test Application Model File Exists
    @Test
    @Order(11)
    public void backend_day19_testApplicationModelFileExists() {
        String filePath = "src/main/java/com/examly/springapp/model/Application.java";
        File file = new File(filePath);
        assertTrue(file.exists() && file.isFile());
    }

    // Day 19: Test ApplicationRepo File Exists
    @Test
    @Order(12)
    public void backend_day19_testApplicationRepoFileExists() {
        String filePath = "src/main/java/com/examly/springapp/repository/ApplicationRepo.java";
        File file = new File(filePath);
        assertTrue(file.exists() && file.isFile());
    }

    // Day 20: Test Application Has ManyToOne Annotations
    @Test
    @Order(13)
    public void backend_day20_testApplicationHasManyToOneAnnotations() {
        try {
            Class<?> applicationClass = Class.forName("com.examly.springapp.model.Application");
            Field[] declaredFields = applicationClass.getDeclaredFields();

            boolean hasJobManyToOne = false;
            boolean hasUserManyToOne = false;

            for (Field field : declaredFields) {
                if (field.getName().equals("job") && field.isAnnotationPresent(ManyToOne.class)) {
                    hasJobManyToOne = true;
                }
                if (field.getName().equals("user") && field.isAnnotationPresent(ManyToOne.class)) {
                    hasUserManyToOne = true;
                }
            }

            if (!hasJobManyToOne || !hasUserManyToOne) {
                fail("Missing @ManyToOne annotation for 'job' or 'user' in Application class.");
            }

        } catch (ClassNotFoundException e) {
            fail("Class not found: " + e.getMessage());
        }
    }

    // Day 21: Test ApplicationService Interface and Implementation
    @Test
    @Order(14)
    public void backend_day21_testApplicationServiceInterfaceAndImplementation() {
        try {
            Class<?> interfaceClass = Class.forName("com.examly.springapp.service.ApplicationService");
            Class<?> implementationClass = Class.forName("com.examly.springapp.service.ApplicationServiceImpl");

            assertTrue(interfaceClass.isInterface(), "The specified class is not an interface");
            assertTrue(interfaceClass.isAssignableFrom(implementationClass), "Implementation does not implement the interface");
        } catch (ClassNotFoundException e) {
            fail("Interface or implementation not found: " + e.getMessage());
        }
    }

    // Day 22: Test Exception File Exists
    @Test
    @Order(15)
    public void backend_day22_testExceptionFile() {
        String filePath = "src/main/java/com/examly/springapp/exception/AlreadyAppliedForJobException.java";
        File file = new File(filePath);
        assertTrue(file.exists() && file.isFile());
    }

    // Day 23: Test BookingController File Exists
    @Test
    @Order(16)
    public void backend_day23_testApplicationControllerFileExists() {
        String filePath = "src/main/java/com/examly/springapp/controller/ApplicationController.java";
        File file = new File(filePath);
        assertTrue(file.exists() && file.isFile());
    }

	@Test
	@Order(17)
	void backend_day23_testGetAllApplication() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.get("/api/applications")
				.accept(MediaType.APPLICATION_JSON)).andDo(print())
				.andExpect(status().isOk()).andExpect(jsonPath("$").isArray())
				.andReturn();
	}

    // Day 24: Test User Entity File Exists
    @Test
    @Order(18)
    public void backend_day24_testEntityUserFileExists() {
        String filePath = "src/main/java/com/examly/springapp/model/User.java";
        File file = new File(filePath);
        assertTrue(file.exists() && file.isFile());
    }

    // Day 25: Test CORS Configuration File Exists
    @Test
    @Order(19)
    public void backend_day25_testCorsConfigFileExists() {
        String filePath = "src/main/java/com/examly/springapp/config/CorsConfig.java";
        File file = new File(filePath);
        assertTrue(file.exists() && file.isFile());
    }
}
