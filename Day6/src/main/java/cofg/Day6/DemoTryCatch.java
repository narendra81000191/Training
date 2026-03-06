package cofg.Day6;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class DemoTryCatch {
	public static void readFile()throws FileNotFoundException {
		FileReader readfile=new FileReader("data.txt");
		
	}
	public static void main(String[] args) throws FileNotFoundException {
		/*
		 * int a=5,b[]= {1,2,3,4,5}; try { for (int i=0;i<b.length;i++)
		 * 
		 * System.out.println(a/b[i]);} catch(ArithmeticException e) {
		 * System.out.println("exception occured"); e.printStackTrace();// for tracing
		 * the stack//if we do not write it working fine stiil for genric ans we used it
		 * System.out.println(e.getMessage()); } catch(RuntimeException re) {
		 * re.printStackTrace(); System.out.println(re.getMessage());
		 * 
		 * 
		 * } catch(Exception e) { e.printStackTrace();
		 */ }
	/*
	 * String s="Ashu"; try { System.out.println(s.charAt(0)); }
	 * 
	 * catch (NullPointerException ne) { ne.printStackTrace(); } finally {
	 * System.out.println("application completed"); }
	 * 
	 * File f=new File("data.txt"); f.delete(); if(f!=null)
	 * System.out.println("file exists"); else throw new FileNotFoundException();
	 * 
	 * FileReader reader=null; try { FileReader reader=new FileReader("data.txt");}
	 * int ch; while(ch=reader.read())!=-1) System.out.println((char)ch);
	 * 
	 * } catch(IOException ex) { ex.printStackTrace();
	 * 
	 * 
	 * } finally { try {
	 * 
	 * 
	 * if (reader!=null); reader.close(); } catch(IOException ex){
	 * System.out.println("exception occured");
	 * 
	 * }
	 */

	reader.();
}
