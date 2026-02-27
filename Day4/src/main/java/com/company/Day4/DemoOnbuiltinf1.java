package com.company.Day4;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class DemoOnbuiltinf1 {
	public static void main(String[] args) {
		//supplier
	
		Supplier<String>strSupplier=()->"Hello World";
		System.out.println(strSupplier.get());//suppplier always return value with taking input
		Supplier<Integer>otpSupplier=()->{
			int otp=(int)(Math.random()*10000);
			return otp;
		};
		/*System.out.println(otpSupplier.get());
		Supplier<Ineger[]>evenSupplier=()->{
			for(int i=1;i<=10;i++)
				
		}*/
			
			
		
		//Consumer
		Consumer<String>strConsumer=(str1)->System.out.println(str1.toUpperCase());
		strConsumer.accept("ASHU");
		
		Consumer<Integer>squareConsumer=(num)->System.out.println(num*num);
		for (int i =1;i>=10;i++)
			squareConsumer.accept(i);
		Consumer<Integer>factorial=(num)->{
			int fact=1;
			for(int i=1;i<=num;i++)
				fact=fact*i;
			System.out.println(fact);
		};
		factorial.accept(5);
	//function
		Function<Integer,String>isEvenorOdd=(num)->{
			if(num%2==0)
				return "even";
			else
				return "odd";
			
		};
		System.out.println(isEvenorOdd.apply(572));
		Function<String,String>greet=(name)->"heelo"+name;
		System.out.println(greet.apply("amit"));
		
		
		
		//predicate it return boolean value
		
		
		Predicate<Integer>checkNum=(num)->num%2==0;
		if(checkNum.test(56))
			System.out.println("evenno");
		else
			System.out.println("odd no");
		Predicate<String>chkLength=(str)->str.length()>5;
		
		System.out.println(chkLength.test("Ashu"));
		
		Predicate<String>authenticateUsername=(uname)->uname.equals("Narendra");
		Predicate<String>authenticatePassword=(pwd)->pwd.equals("123");
		String result=authenticateUsername.test("Narendra")&&authenticatePassword.test("123")?
				"authentication Sucessful":"authentication failed";
		System.out.println(result);
		
		
		//validation
		
		Predicate<String>validateUsername=(uname)->uname.length()>3&&uname!=null&&
				!uname.isBlank();
		System.out.println(validateUsername.test("   "));
		
		
		
		
	

}}
