package JUnitInfo;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class JUnitIntroduction {
	//runs before everything
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		System.out.println("Executed before class...");
	}
	//runs after everything
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		System.out.println("Executed after everything is done...");
	}
	//runs before every test
	@Before
	public void setUp() throws Exception {
		System.out.println("Executed before test...");
	}
	//runs after every test
	@After
	public void tearDown() throws Exception {
		System.out.println("Executed after test...");
	}
	//test case 1
	@Test
	public void test1() {
		System.out.println("Executed Test1...");
	}
	//test case 2
	@Test
	public void test2() {
		System.out.println("Executed Test2...");
	}

}
