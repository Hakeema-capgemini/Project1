package com.example.project.bdd.runners;

import org.springframework.boot.test.context.SpringBootTest;

import com.example.project.ProjectApplication;

import io.cucumber.spring.CucumberContextConfiguration;

@CucumberContextConfiguration
@SpringBootTest(classes=ProjectApplication.class)

public class CucumberConfig {
	

}
