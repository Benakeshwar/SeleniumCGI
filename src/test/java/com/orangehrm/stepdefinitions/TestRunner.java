package com.orangehrm.stepdefinitions;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features="C:\\Users\\Benakesh\\git\\repository\\CGI_Aug25\\src\\test\\resources\\Features"
,glue= {"com.orangehrm.stepdefinitions"}

,dryRun=false

,monochrome=true)
 
 
public class TestRunner {

 
}

 