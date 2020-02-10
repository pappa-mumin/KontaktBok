package test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.File;

import org.junit.jupiter.api.Test;

import main.Fil;

class FilTest {
	
	Fil f = new Fil();

	@Test
	void testFinnsFilen() {
		File test = new File(f.getFilNamn());
		boolean finns = test.exists();
		assertFalse(finns);
	}

}
