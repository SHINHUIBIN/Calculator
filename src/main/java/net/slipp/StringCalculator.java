package net.slipp;

import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class StringCalculator {

	public int add(String arg) throws Exception {
		int temp = 0;
		
		if (arg.isEmpty()) {
			temp = 0;
		}
		else if (arg.length() > 0 && arg.startsWith("//")) {
			Matcher m = Pattern.compile("//(.)\n(.*)").matcher(arg);
			m.find();
			String customeDelimeter = m.group(1);
			String[] numbers = m.group(2).split(Pattern.quote(customeDelimeter));
			
			temp = sum(numbers);
		}
		else if (arg.length() > 0) {
			String[] numbers = arg.split(",|\n");
			
			temp = sum(numbers);
		}
		
		return temp;
	}
	
	public int sum(String[] numbers) {
		int temp = 0;
		
		if (numbers != null && numbers.length > 0) {
			for (String number : numbers) {
				number = number.trim();
				if (isStringDouble(number)) {
					int num = Integer.parseInt(number);
					
					if (temp < 0)
						throw new RuntimeException();
					
					temp += num;
				}
			}
		}
		
		return temp;
	}
	
	public boolean isStringDouble(String s) {
	    try {
	        Double.parseDouble(s);
	        return true;
	    } catch (NumberFormatException e) {
	        return false;
	    }
	  }

}
