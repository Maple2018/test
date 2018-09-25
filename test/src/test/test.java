package test;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class test {

	public static void main(String[] args) {
		String regex = "(fileId=)(.*)";
		String content="http://10.108.5.13:18080/gzgas/client/downloadTemplate.action?type=protocol&templateId=5b20e3fb0cf2ed7f348cbd52&fileId=67e91f3e-7f04-46cd-9456-b3a00f507eda";
		Pattern p = Pattern.compile(regex);
		Matcher m = p.matcher(content);
		System.out.println("Strat");
		if(m.find()){
			System.out.println(m.group(2)+"\n");
		}
	}
}
