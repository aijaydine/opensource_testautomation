package com.automationpractice;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
		plugin = {"pretty", 
					"html:target/cucumber",
					"json:target/cucumber/report-json",
				 	"junit:target/cucumber/report-xml.xml"}
		,features = {"src/test/resources"}
		,monochrome = true 
		,snippets = SnippetType.CAMELCASE
		,tags = {"@wip"}
//		,glue = {"src/test/java"}
		)

public class RunnerCukesTest {}
