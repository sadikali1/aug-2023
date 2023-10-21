package com.steps;

import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class StepsDef {

	int result;
	int a;
	int b;
	
	@Given("I have two integer values {int} and {int}")
	public void i_have_two_integer_values_and(Integer int1, Integer int2) {
		a = int1;
		b = int2;
	}

	@When("I added both number")
	public void i_added_both_number() {
		result = a+b;
	}

	@Then("I verify result is {int}")
	public void i_verify_result_is(Integer int1) {
		Assert.assertEquals(int1, result);
	}
	
	@Given("I login into the application")
	public void i_login_into_the_application() {
	    // Write code here that turns the phrase above into concrete actions
	    //throw new io.cucumber.java.PendingException();
	}

}
