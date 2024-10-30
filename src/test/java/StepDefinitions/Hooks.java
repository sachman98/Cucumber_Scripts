package StepDefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Hooks {
		
	@Before("@SmokeTest")
	public void smokeTestSetup() {
		System.out.println("**Smoke test Initiated**");
	}
	
	@After("@SmokeTest")
	public void smokeTestTearDown() {
		System.out.println("**Smoke test tear down completed**");
	}

}
