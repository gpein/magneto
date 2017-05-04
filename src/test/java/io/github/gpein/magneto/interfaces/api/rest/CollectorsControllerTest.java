package io.github.gpein.magneto.interfaces.api.rest;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.github.gpein.magneto.MagnetoApplication;
import io.github.gpein.magneto.domain.Collector;
import io.github.gpein.magneto.domain.CollectorRepository;
import io.github.gpein.magneto.domain.magnet.Department;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.util.Collection;
import java.util.Collections;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = MagnetoApplication.class)
public class CollectorsControllerTest {

    @Autowired
    private WebApplicationContext wac;

    @Autowired
    private ObjectMapper objectMapper;

    @MockBean
    private CollectorRepository mockCollectorRepository;

    private MockMvc mockMvc;

    private Collection<Collector> collectors;

    @Before
    public void setup() {
        mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();

        Collector collector = new Collector();
        collector.lookForNewMagnet(Department.Charente);
        collector.oldDuplicate(Department.Cher);
        collectors = Collections.singletonList(collector);
        given(mockCollectorRepository.all()).willReturn(collectors);
    }

    @Test
    public void all() throws Exception {
        mockMvc.perform(get("/api/collectors")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json;charset=UTF-8"))
                .andExpect(content().string(objectMapper.writeValueAsString(collectors)));
    }
}