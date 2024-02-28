import static org.junit.jupiter.api.Assertions.*;

import org.junit.experimental.categories.Categories;
import org.junit.experimental.categories.Category;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;

import com.incubationtasks.hashmaptasks.HashMapTasks;

import stringrun.StringRun;
import utilities.InvalidInputException;

class LengthTest {
	@Test
	
	
	
	
	void test() {
		try {
			StringRun ss=new StringRun();
			assertEquals(7,ss.length(null));
		} catch (InvalidInputException e) {
			e.printStackTrace();
		}
	}
	
}
