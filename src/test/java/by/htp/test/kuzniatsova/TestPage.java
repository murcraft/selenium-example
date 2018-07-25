package by.htp.test.kuzniatsova;

import org.testng.annotations.*;

import entity.Page;

public class TestPage {
	
	@Parameters()
	@BeforeSuite
	public void testCreatePage() {
		Page page = new Page();
	}

}
