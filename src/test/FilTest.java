package test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import java.io.File;

import org.junit.jupiter.api.Test;

import main.Fil;

class FilTest {
	
	Fil f = new Fil();

	@Test
	void testFinnsFilen() {
		boolean finns = f.finnsFilen("test");
		assertFalse(finns);
	}

	@Test
	void testSkapaFil() {
		
	}

}
