package co.learning.webclient.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class WebConfiguration {
    @Bean
    public WebClient webClient(){
        WebClient webClient = WebClient.builder().build();
        return webClient;
    }
}
