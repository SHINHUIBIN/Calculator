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
	public void add_���ڿ�_��ȯ����0() throws Exception {
		logger.debug("IsEmpty: {}", stringCal.add(""));
		logger.debug("Test: {}", stringCal.add("Test"));
		assertThat(stringCal.add(""), is(0));
	}
	
	@Test
	public void add_�ΰ��Ǽ���_��ȯ������() throws Exception {
		logger.debug("�� ������ ��(251, 352): {}", stringCal.add("251, 352"));
		assertThat(stringCal.add("251, 352"), is(603));
	}
	
	@Test
	public void add_�����Ǽ���_��ȯ������() throws Exception {
		logger.debug("�� ������ ��(251, 352, 555): {}", stringCal.add("251, 352, 555"));
		assertThat(stringCal.add("251, 352, 555"), is(1158));
	}
	
	@Test
	public void add_������_���๮���߰�() throws Exception {
		logger.debug("�� ������ ��(251, 352, 555\n100): {}", stringCal.add("251, 352, 555\n100"));
		assertThat(stringCal.add("251, 352, 555\n100"), is(1258));
	}
	
	@Test
	public void add_Ŀ���ұ������߰�() throws Exception {
		logger.debug("�� ������ ��(251;352;555): {}", stringCal.add("//;\n251;352;555"));
		assertThat(stringCal.add("//;\n251;352;555"), is(1158));
	}
	
	@Test
	public void add_Ŀ���ұ�����_����ǥ���Ŀ�����߰�() throws Exception {
		logger.debug("�� ������ ��(251;352;555): {}", stringCal.add("//.\n251.352.555"));
//		assertThat(stringCal.add("//.\n251;352;555"), is(1158));
	}
	
	@Test (expected=RuntimeException.class)
	public void add_�����������Ұ��_RuntimeException�߻���() throws Exception {
		logger.debug("�� ������ ��(-251;352;555): {}", stringCal.add("-251,352,555"));
		
		stringCal.add("-251;352;555");
	}
	
	@After
	public void teardown() {
		
	}
}
