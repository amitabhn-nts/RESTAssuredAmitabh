package api.testcases;

import java.io.IOException;

import org.testng.annotations.BeforeClass;

import utils.CommonOperations;

public class BaseClass {
	
	@BeforeClass
    public void startUp() throws IOException {
		CommonOperations.readAPIConfigs();
		CommonOperations.setBaseURI();
    }

}
