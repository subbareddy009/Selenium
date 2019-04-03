package com.test;

import org.testng.annotations.Test;

public class NewTest1 {
	@Test(priority=1)
	public void testGoogleHomePage()
	{
		System.out.println("in google home page");
	}
	@Test(priority=2)
	public void testLinkedIn()
	{
		System.out.println("in linked in page");
	}
	@Test(priority=3)
	public void testAccenturePage()
	{
		System.out.println("in accenture home page");
	}
}
