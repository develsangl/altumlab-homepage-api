package kr.altumlab.homepage.configure;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import springfox.documentation.annotations.ApiIgnore;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Configuration
@EnableWebMvc
public class SwaggerConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .components(new Components())
                .info(new Info().title("알툼랩 홈페이지 api")
                        .description("API 명세")
                        .version("0.1.0")
                );
    }

    @Controller
    @RequestMapping("/swagger-ui")
    static class SwaggerRedirector {
        @ApiIgnore
        @GetMapping
        public void api(HttpServletResponse response) throws IOException {
            response.sendRedirect("/swagger-ui/index.html");
        }
    }
}