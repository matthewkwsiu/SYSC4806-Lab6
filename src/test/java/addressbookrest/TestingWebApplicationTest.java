package addressbookrest;


import static org.hamcrest.Matchers.containsString;
import static org.mockito.Mockito.reset;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.aspectj.lang.annotation.After;
import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest
@AutoConfigureMockMvc
public class TestingWebApplicationTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testCreateAddressBook() throws Exception {
        this.mockMvc.perform(get("/createaddressbook")).andDo(print()).andExpect(status().isOk())
                .andExpect(content().json("[{\"id\":1,\"buddies\":[],\"name\":\"\"}]"));

    }

//    @Test
//    public void testViewAddressBook() throws Exception {
//        this.mockMvc.perform(get("/viewaddressbook")).andDo(print()).andExpect(status().isOk())
//                .andExpect(content().json("[]"));
//    }
//
//    @Test
//    public void testGetAddressBook() throws Exception {
//        this.mockMvc.perform(get("/createaddressbook")).andDo(print()).andExpect(status().isOk());
//        this.mockMvc.perform(get("/getaddressbook?1")).andDo(print()).andExpect(status().isOk())
//                .andExpect(content().json("{\"id\":1,\"buddies\":[],\"name\":\"\"}"));
//    }

    @Test
    public void testCreateBuddyInfo() throws Exception {
        this.mockMvc.perform(get("/createaddressbook")).andDo(print()).andExpect(status().isOk());
        this.mockMvc.perform(post("/buddyinfo")).andDo(print()).andExpect(status().isOk())
                .andExpect(content().string(containsString("viewgui?i=0")));
    }

    @Test
    public void testRemoveBuddyInfo() throws Exception {
        this.mockMvc.perform(get("/createaddressbook")).andDo(print()).andExpect(status().isOk());
        this.mockMvc.perform(post("/buddyinfo")).andDo(print()).andExpect(status().isOk());
    }

    @Test
    public void testViewAddressBooks() throws Exception {
        this.mockMvc.perform(get("/viewaddressbooks")).andDo(print()).andExpect(status().isOk()).andExpect(content().string(containsString("Add new addressbook")));
    }

    @Test
    public void testViewAddressBooksPost() throws Exception {
        this.mockMvc.perform(post("/viewaddressbooks")).andDo(print()).andExpect(status().isOk()).andExpect(content().string(containsString("1")));
    }


    @Test
    public void shouldReturnDefaultMessage2() throws Exception {
    }

}