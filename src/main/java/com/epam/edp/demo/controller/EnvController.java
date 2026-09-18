package com.epam.edp.demo.controller;

import java.util.Map;
import java.util.TreeMap;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.epam.edp.demo.ConfigFileComponent;

@RestController
public class EnvController {

    private final ConfigFileComponent configFileService;

    public EnvController(ConfigFileComponent configFileService) {
        this.configFileService = configFileService;
    }

    @GetMapping(value = "/env")
    public Map<String, String> getEnv() {
        Map<String, String> env = new TreeMap<>(System.getenv());

        env.put("application.properties.from.configmap",
                configFileService.readConfigMapProperties());
        env.put("application.secret.properties.from.secret",
                configFileService.readSecretProperties());

        return env;
    }
}
