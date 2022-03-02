package addressbookrest;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(GUIController.class)
//tag::test[]
public class WebLayerTest {

    @Autowired
    private MockMvc mockMvc;

//    @Test
//    public void shouldReturnDefaultMessage() throws Exception {
//        this.mockMvc.perform(get("/createaddressbook")).andDo(MockMvcResultHandlers.print()).andExpect(status().isOk())
//                .andExpect(content().string(containsString("id")));
//    }

    @Test
    public void shouldReturnDefaultMessage2() throws Exception {

    }
}