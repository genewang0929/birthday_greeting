package genewang.controller;

import genewang.entity.AppUser;
import genewang.repository.UserRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@AutoConfigureMockMvc
public class GreetingControllerTest {
    private HttpHeaders httpHeaders;
    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private UserRepository userRepository;

    @BeforeEach
    public void insertAllData() {
        userRepository.deleteAll();

        httpHeaders = new HttpHeaders();
        httpHeaders.add(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE);

        AppUser appUser1 = new AppUser(
                "Robert",
                "Yen",
                "Male",
                "1985/8/8",
                "robert.yen@linecorp.com"
        );
        userRepository.insert(appUser1);

        AppUser appUser2 = new AppUser(
                "Cid",
                "Change",
                "Male",
                "1990/10/10",
                "cid.change@linecorp.com"
        );
        userRepository.insert(appUser2);

        AppUser appUser3 = new AppUser(
                "Miki",
                "Lai",
                "Female",
                "1993/4/5",
                "miki.lai@linecorp.com"
        );
        userRepository.insert(appUser3);

        AppUser appUser4 = new AppUser(
                "Sherry",
                "Chen",
                "Female",
                "1993/8/8",
                "sherry.lai@linecorp.com"
        );
        userRepository.insert(appUser4);

        AppUser appUser5 = new AppUser(
                "Peter",
                "Wang",
                "Male",
                "1950/12/22",
                "peter.wang@linecorp.com"
        );
        userRepository.insert(appUser5);
    }

    @Test
    public void testGetGreeting() throws Exception {
        RequestBuilder requestBuilder = MockMvcRequestBuilders
                .get("/api/v3/2022/12/22")
                .headers(httpHeaders);

        mockMvc.perform(requestBuilder)
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.message.[0].title").value("Subject: Happy birthday!"))
                .andExpect(jsonPath("$.message.[0].content").value(
                        "Happy birthday, dear `Peter`! " +
                        "https://hr.jhu.edu/wp-content/uploads/elder-care-GettyImages-912073272.jpg"))
                .andExpect(header().string(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE));
    }

    @AfterEach
    public void deleteAllData() {
        userRepository.deleteAll();
    }
}
