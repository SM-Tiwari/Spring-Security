package com.siddheshjunit;

import static org.junit.Assume.assumeFalse;
import static org.junit.Assume.assumeTrue;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assumptions.assumingThat;

import java.time.LocalDateTime;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

class MathUtilsTest {
	
	/*
	 * @BeforeAll static void beforeAll() {
	 * System.out.println("Executed once before call all test methods in this class"
	 * ); }
	 * 
	 * @BeforeEach void beforeEach() {
	 * System.out.println("Executed before each test mehtod in this class"); }
	 */
	@Test
	void testAdd() {
		MathUtils mu = new MathUtils();
		System.out.println("test for add");
		assertEquals(2, mu.add(1,1));
		//fail("Not yet implemented");
	}

	
	  @Test 
	  void testSubtract() {
		  MathUtils mu = new MathUtils();
		  System.out.println("test for sub");
		  assertEquals(2, mu.subtract(4, 2));
		  //fail("Not yet implemented"); 
		  }
	  
	  @Test
	  void testMethod1() {
		  System.out.println("Test method1 executed");
	  }
	  
	  @DisplayName("Test method2 condition")
	  @Test
	  void testMethod2() {
		  System.out.println("Test method2 executed");
	  }
	  
	  @Test
	  @Disabled("Implementation pending")
	  void testMethod3() {
		  System.out.println("Test method3 executed");
	  }
	  
	  @Test
	  void testAssertEqual() {
		  assertEquals("ABC", "ABC");
		  assertEquals(20, 20, "optional assertion message");
		  assertEquals(2+2, 4);
	  }
	  
	  @Test
	  void testAssertFalse() {
		  assertFalse("FirstName".length()==10);
		  assertFalse(10>20, "assertion message");
	  }
	  
	  @Test
	  void testAssertNull() {
		  String str1 = null;
		  String str2 = "abc";
		  assertNull(str1);
		  assertNotNull(str2);
		  
	  }
	  
	  @Test
	  void testAssertAll() {
		  String str1 = "abc";
		  String str2 = "pqr";
		  String str3 = "xyz";
		
		  assertAll("numbers", 
				  ()->assertEquals(str1, "abc"), 
				  ()->assertEquals(str2,"pqr"), 
				  ()->assertEquals(str3, "xyz"));
		 
		  
		
		/*
		 * assertAll("numbers", ()->assertEquals(str1, "abc"), ()->assertEquals(str2,
		 * "pqr1"), ()->assertEquals(str3, "xyz1"));
		 */
		 
		  
	  }
	
	
	  @Test 
	  void testAssertTrue() { 
		  assertTrue("FirstName".startsWith("F"));
		/*
		 * assertTrue(10 { throw new
		 * IllegalArgumentException("Illegal Argument Exception occured"); });
		 * assertEquals("Illegal Argument Exception occured", exception.getMessage());
		 */
	  }
	  
	  @Test
	  void  testAssumeTrue() {
		  boolean b = 'A' == 'A';
		  assumeTrue(b);
		  assertEquals("Hello", "Hello");
	  }
	  
	  @Test
	  @DisplayName("Tests executes only on saturday")
	  public void testAssumeTrueSaturday() {
		  LocalDateTime dt = LocalDateTime.now();
		  assumeTrue(dt.getDayOfWeek().getValue()==6);
		  System.out.println("further code will execute only if above assumption holds true");
		  
	  }
	  
	  @Test
	  void testAssumeFalse() {
		  boolean b = 'A' != 'A';
		  assumeFalse(b);
		  assertEquals("Hello", "Hello");
	  }
	  
	  @Test
	  void testAssumeFalseEnvProp() {
		  System.setProperty("env", "prod");
		  assumeFalse("dev".equals(System.getProperty("env")));
		  System.out.println("further code will execute only if above assumption hold");
		  
	  }
	  
	  @Test
	  void testAssumingThat() {
		  System.setProperty("env", "test");
		  assumingThat("test".equals(System.getProperty("env")), 
				  ()->{
					  assertEquals(10, 10);
					  System.out.println("perform below assertions only on the test env");
				  });
		     assertEquals(20, 20);
		     System.out.println("perform below assertions on all env");
		  
	  }
	  
	  @RepeatedTest(5)
	  void test() {
		  System.out.println("@RepeatedTest simple Example");
		  
	  }
	 
	 
	  
	  
	  
	  
	  
	  
	  
	/*
	 * @Test void testMultiply() { fail("Not yet implemented"); }
	 * 
	 * @Test void testDivide() { fail("Not yet implemented"); }
	 * 
	 * @Test void testComputeCircleArea() { fail("Not yet implemented"); }
	 */
	  
	/*
	 * @AfterEach void afterEach() {
	 * System.out.println("Executed after each test method in this class"); }
	 * 
	 * @AfterAll static void afterAll() {
	 * System.out.println("Executed once after call all test method in this class");
	 * }
	 */
	  
	 
	}
