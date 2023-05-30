package ssh8560.myproject.web.config;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ssh8560.myproject.web.lostark.Skill;

import java.io.File;
import java.io.IOException;
import java.util.List;

@Configuration
public class LostarkStaticDataBeanConfig {
    private final ObjectMapper objectMapper;

    public LostarkStaticDataBeanConfig(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    @Bean
    public List<Skill> skills() throws IOException {
        File file = new File("src/main/resources/static/json/lostark/skills.json");
        return objectMapper.readValue(file, new TypeReference<List<Skill>>() {});
    }
}
