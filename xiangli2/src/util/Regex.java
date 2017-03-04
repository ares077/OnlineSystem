package util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Regex {
	Pattern p;
	public boolean courseidisvalis(String a)
	{
		p=Pattern.compile("\\D\\d\\d\\d\\d");
		Matcher m=p.matcher(a);
		boolean b=m.matches();
		return b;
	}
	public boolean classinfoisvalud(String a) {
		p=Pattern.compile("\\d{6}");
		Matcher m=p.matcher(a);
		boolean b=m.matches();
		return b;	
	}
	public boolean pwisvalid(String a)
	{
		p=Pattern.compile(".{6,20}");
		Matcher m=p.matcher(a);
		boolean b=m.matches();
		return b;		
	}
	public boolean stuidisvalid(String a)
	{
		p=Pattern.compile("\\d{11}");
		Matcher m=p.matcher(a);
		boolean b=m.matches();
		return b;		
	}
	public boolean phonumisvalid(String a)
	{
		p=Pattern.compile("^[1][3,4,5,8][0-9]{9}$");
		Matcher m=p.matcher(a);
		boolean b=m.matches();
		return b;		
	}
	public boolean mailisvalid(String a)
	{
		p=Pattern.compile("\\w{3,20}@(qq|hotmail|sina|yahoo|126|163|sohu|sogou)+\\.(com|org|cn|net|gov)");
		Matcher m=p.matcher(a);
		boolean b=m.matches();
		return b;		
	}
	
	

}
