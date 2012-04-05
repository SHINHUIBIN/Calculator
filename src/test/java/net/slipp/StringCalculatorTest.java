package net.slipp;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.theories.suppliers.TestedOn;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class StringCalculatorTest {
	private static final Logger logger = LoggerFactory.getLogger(StringCalculatorTest.class);
	private StringCalculator stringCal;
	
	@Before
	public void setup() {
		stringCal = new StringCalculator();
	}
	
	
	@Test
	public void add_빈문자열_반환값은0() throws Exception {
		logger.debug("IsEmpty: {}", stringCal.add(""));
		logger.debug("Test: {}", stringCal.add("Test"));
		assertThat(stringCal.add(""), is(0));
	}
	
	@Test
	public void add_두개의숫자_반환값은합() throws Exception {
		logger.debug("두 숫자의 합(251, 352): {}", stringCal.add("251, 352"));
		assertThat(stringCal.add("251, 352"), is(603));
	}
	
	@Test
	public void add_세개의숫자_반환값은합() throws Exception {
		logger.debug("세 숫자의 합(251, 352, 555): {}", stringCal.add("251, 352, 555"));
		assertThat(stringCal.add("251, 352, 555"), is(1158));
	}
	
	@Test
	public void add_구분자_개행문자추가() throws Exception {
		logger.debug("세 숫자의 합(251, 352, 555\n100): {}", stringCal.add("251, 352, 555\n100"));
		assertThat(stringCal.add("251, 352, 555\n100"), is(1258));
	}
	
	@Test
	public void add_커스텀구분자추가() throws Exception {
		logger.debug("세 숫자의 합(251;352;555): {}", stringCal.add("//;\n251;352;555"));
		assertThat(stringCal.add("//;\n251;352;555"), is(1158));
	}
	
	@Test
	public void add_커스텀구분자_정규표현식예약어추가() throws Exception {
		logger.debug("세 숫자의 합(251;352;555): {}", stringCal.add("//.\n251.352.555"));
//		assertThat(stringCal.add("//.\n251;352;555"), is(1158));
	}
	
	@Test (expected=RuntimeException.class)
	public void add_음수를전달할경우_RuntimeException발생함() throws Exception {
		logger.debug("세 숫자의 합(-251;352;555): {}", stringCal.add("-251,352,555"));
		
		stringCal.add("-251;352;555");
	}
	
	@After
	public void teardown() {
		
	}
}
