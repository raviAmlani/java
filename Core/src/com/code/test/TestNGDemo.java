package com.code.test;

import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.AssertJUnit;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;

public class TestNGDemo {
  

	@Test
	public void sum() {
		AssertJUnit.assertEquals(7, 4 + 4);
	}

	@Test
	public void sub() {
		AssertJUnit.assertEquals(0, 4 - 4);
	}

	@BeforeClass
	public void beforeClass() {
	}


	@AfterClass
	public void afterClass() {
	}

  
}
