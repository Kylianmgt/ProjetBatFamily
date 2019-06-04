package view;

import static org.junit.Assert.assertEquals;

import java.util.Scanner;

import org.junit.Test;

public class viewtest {
	@Test
	public void pressKeyTest() throws Exception {
		final Scanner sc = new Scanner(System.in);
		final String key_input = sc.next();
		assertEquals("z", key_input);
		sc.close();
	}

	@Test
	public void testGetScanCode() {
	
	}
}
