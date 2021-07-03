package com.openweathermap.runners;

import org.testng.annotations.Listeners;

import com.openweathermap.listeners.TestNGListener;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@Listeners(TestNGListener.class)
@CucumberOptions(features = "src/test/resources/features",
		plugin = { "json:target/cucumber.json","html:target/site/cucumber-pretty" },
		glue = { "com.openweathermap.steps" }, monochrome = true)
public class TestRunner extends AbstractTestNGCucumberTests {

}
