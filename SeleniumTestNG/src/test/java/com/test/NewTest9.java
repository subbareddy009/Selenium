package com.test;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class NewTest9 {
	
	@Test
	public void test1()
	{
		System.out.println("in test1");
	}
	@Test
	public void test2()
	{
		System.out.println("in test2");
	}
	@BeforeMethod
	public void testBeforeMethod()
	{
		System.out.println("in before method");
	}
	@AfterMethod
	public void testAfterMethod()
	{
		System.out.println("in after method");
	}
	@AfterClass
	public void testAfterClass()
	{
		System.out.println("in after class 9");
	}
	@BeforeClass
	public void testBeforeClass()
	{
		System.out.println("in before class 9");
	}

}
