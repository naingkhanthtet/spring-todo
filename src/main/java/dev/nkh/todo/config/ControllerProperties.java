package dev.nkh.todo.config;


import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(value = "tt")
public record ControllerProperties (String welcome, String about) {
}
