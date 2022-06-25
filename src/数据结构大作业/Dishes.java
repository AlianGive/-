package 数据结构大作业;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;

public class Dishes {
	String name;
	String taste;
	String prize;
	public Dishes(String name,String taste,String prize) {
		this.name=name;
		this.taste=taste;
		this.prize=prize;
	}
	public Dishes() {
		this(null,null,null);
	}
	public String toString() {
		String str=name+","+taste+","+prize;
		return str;
	}
	//第一饭堂菜品数量
	public int number1() throws IOException {
		int i=0;
		File file=new File("D:\\饭堂一菜单.txt");
		FileInputStream inone=new FileInputStream(file);
		InputStreamReader intwo;
		intwo = new InputStreamReader(inone,"UTF-8");
		BufferedReader inthree=new BufferedReader(intwo);
		while((inthree.readLine())!=null) 
			i++;
		return i;
	}
	//获取第一饭堂菜品已链表的形式储存
	public Dishes[] getmenu1() throws IOException {
			int j=this.number1();
	    	int i=0;
	    	String str1;
	    	Dishes x;
	    	Dishes[] dishes=new Dishes[j];
			File file=new File("D:\\饭堂一菜单.txt");
			FileInputStream inone=new FileInputStream(file);
			InputStreamReader intwo;
			intwo = new InputStreamReader(inone,"UTF-8");
			BufferedReader inthree=new BufferedReader(intwo);
			while((str1=inthree.readLine())!=null) {
			String str2[]=str1.split(",");
			    x=new Dishes(str2[0],str2[1],str2[2]);
				dishes[i]=x;
				i++;
				}
			inthree.close();
			return dishes;
			
	}
	//第二饭堂菜品数量
	public int number2() throws IOException {
		int i=0;
		File file=new File("D:\\饭堂二菜单.txt");
		FileInputStream inone=new FileInputStream(file);
		InputStreamReader intwo;
		intwo = new InputStreamReader(inone,"UTF-8");
		BufferedReader inthree=new BufferedReader(intwo);
		while((inthree.readLine())!=null) 
			i++;
		return i;
	}
	//获取第二饭堂菜品已链表的形式储存
	public Dishes[] getmenu2() throws IOException {
		int j=this.number2();
    	int i=0;
    	String str1;
    	Dishes x;
    	Dishes[] dishes=new Dishes[j];
		File file=new File("D:\\饭堂二菜单.txt");
		FileInputStream inone=new FileInputStream(file);
		InputStreamReader intwo;
		intwo = new InputStreamReader(inone,"UTF-8");
		BufferedReader inthree=new BufferedReader(intwo);
		while((str1=inthree.readLine())!=null) {
		String str2[]=str1.split(",");
		    x=new Dishes(str2[0],str2[1],str2[2]);
			dishes[i]=x;
			i++;
			}
		inthree.close();
		return dishes;
	}
}
