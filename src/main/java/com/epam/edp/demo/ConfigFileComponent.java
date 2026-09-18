package com.epam.edp.demo;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;

import org.springframework.stereotype.Component;

@Component
public class ConfigFileComponent {

    private static final Path CONFIGMAP_FILE =
            Path.of("/config/application.properties");
    private static final Path SECRET_FILE =
            Path.of("/secret-config/application.secret.properties");

    public String readConfigMapProperties() {
        return readQuietly(CONFIGMAP_FILE);
    }

    public String readSecretProperties() {
        return readQuietly(SECRET_FILE);
    }

    private String readQuietly(Path path) {
        try {
            return Files.readString(path, StandardCharsets.UTF_8);
        } catch (IOException e) {
            return "N/A: " + e.getMessage();
        }
    }
}