package 数据结构大作业;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
import java.util.Scanner;

public class SinglyList<T>
{
    public Node<T> head;                         // 头指针，指向单链表的头结点
    //注意，head不能是其他权限，因为7.2.2节，图的邻接表中，删除顶点要遍历。2014年8月3日
    
    //（1）构造方法
    public SinglyList()                          //构造方法，构造空单链表
    {
        this.head = new Node<T>();               //创建头结点，data和next值均为null
    }
    
    //构造单链表，尾插入values数组元素，忽略其中空对象。单链表元素次序与数组元素次序相同。O(n)
    public SinglyList(T[] values)
    {
        this();                                  //创建空单链表，只有头结点
        Node<T> rear = this.head;                //rear指向单链表最后一个结点
        for(int i=0; i<values.length; i++)       //若values.length==0，则构造空链表
        {
        	if(values[i]!=null)
            {
                rear.next = new Node<T>(values[i], null);  //尾插入，创建结点链入rear结点之后
                rear = rear.next;                //rear指向新的链尾结点
            }
        }
    }

    //（2）判空、存取元素、求长度、返回描述字符串等方法
    public boolean isEmpty()                     //判断是否空，O(1)
    {
        return this.head.next==null;
    }

    public T get(int i)                          //返回第i个元素，0≤i<单链表长度。若i越界，则返回null。O(n)
    {
        Node<T> p=this.head.next;
        for(int j=0;  p!=null && j<i;  j++)      //遍历单链表，寻找第i个结点（p指向）
            p = p.next;
        return (i>=0 && p!=null) ? p.data : null;//若p指向第i个结点，则返回其元素值
    }
   
    //设置第i个元素为x，0≤i<单链表长度且x!=null。
    //若x==null，抛出空对象异常；若i序号越界，抛出序号越界异常。O(n)////没有返回值
    public void set(int i, T x)
    {
        if(x==null)
            throw new NullPointerException("x==null");     //抛出空对象异常
        else
        {
            Node<T> p=this.head.next;
            for(int j=0;  p!=null && j<i;  j++)  //遍历寻找第i个结点（p指向）
               p = p.next;
            if(i>=0 && p!=null)
               p.data = x;                       //p指向第i个结点
            else throw new IndexOutOfBoundsException(i+"");//抛出序号越界异常
        }
    }
    
    //返回所有元素的描述字符串，形式为“(,)”。覆盖Object类的toString()方法，O(n)
    public String toString()
    {
        String str="(";
       // String str=this.getClass().getName()+"(";//返回类名
        for(Node<T> p=this.head.next;  p!=null;  p=p.next) //p遍历单链表
        {
            str += p.data.toString();
            if(p.next!=null) 
                str += ","; 
            str += p.data.toString()+(p.next!=null?",":"");//不是最后一个结点时，加“,”分隔符
        }
        return str+")";                          //空表返回()
    }
    
    public int size()                            //返回单链表长度，O(n)
    {
        int i=0; 
        for(Node<T> p=this.head.next;  p!=null;  p=p.next) //p遍历单链表
            i++;
        return i;
    }
    
    //（3）插入
    //插入x作为第i个元素，x!=null，返回插入结点。对i容错，若i<0，则头插入；若i>长度，则尾插入。O(n)
    public Node<T> insert(int i, T x)
    {
        if(x==null)
            return null;               ////没有插入结点。返回一种执行结果，不是错误，不抛出异常
        Node<T> front=this.head;                 //front指向头结点
        for(int j=0;  front.next!=null && j<i;  j++)  //寻找第i-1个或最后一个结点（front指向）
            front = front.next;
        front.next = new Node<T>(x, front.next); //在front之后插入值为x结点，包括头插入、中间/尾插入
        return front.next;
    }
    public Node<T> insert(T x)                   //单链表尾插入x，O(n)，重载
    {
        //调用insert(i,x)，用整数最大值指定插入在最后，遍历一次，i必须容错
        return insert(Integer.MAX_VALUE, x);     //Integer.MAX_VALUE（0x7fffffff）是整数最大值
   //   return insert(this.size(), x);           //需遍历单链表两次，效率较低
    }
    //何处用到此返回值？第8章【例8.2】  使用散列表表示元素互异的集合。
    
//    public void insert(SinglyList<T> list){}
    //【说明】可以声明重载。虽然当调用参数为null时，参数列表相同，编译错，产生二义性，编译器不能确定执行重载方法中的哪一个。

    
    //（4）删除
    public T remove(int i)         //删除第i个元素，0≤i<单链表长度，返回被删除元素。若i越界，则返回null。O(n)
    {
        Node<T> front=this.head;                 //front指向头结点
        for(int j=0;  front.next!=null && j<i;  j++)//遍历寻找第i-1结点（front指向）
            front = front.next;
        if(i>=0 && front.next!=null)             //若front的后继结点存在，则删除之
        {
            T x = front.next.data;               //获得待删除结点引用的对象
            //删除front的后继结点，包括头删除、中间/尾删除。由Java虚拟机稍后释放结点占用存储单元
            front.next = front.next.next;
            return x;
        }
        return null;                             //若i<0或i>表长，则返回null
        //throw new IndexOutOfBoundsException(i+"");       //抛出序号越界异常
    }

    public void clear()                          //删除单链表所有结点
    {
        this.head.next = null;                   //Java自动收回所有结点占用的存储空间
    }

    //（5）查找，散列表用
    //功能及参数：返回首个与key相等元素结点，若查找不成功返回null
    //特殊情况：若key为空对象，Java将抛出空对象异常
    //算法及效率：顺序查找，O(n)
    //用于7.2.2节图的邻接表，必须返回结点，因为要求后继结点。2014年8月6日，对其他影响未修改

    //（5）顺序查找和基于查找算法的操作。方法体省略
    //8.3 散列集合用，
    public Node<T> search(T key)                 //顺序查找并返回首个与key相等元素结点，若查找不成功，则返回null
    {
       //System.out.print(this.getClass().getName()+".search("+key+")，");
        for(Node<T> p=this.head.next;  p!=null;  p=p.next)
        {
        	//System.out.print(p.data.toString()+"？");
        	if (p.data.equals(key))              //执行T类的equals(Object)方法，运行时多态
              return p;
        }
        return null;
    }
    
    public SinglyList<T> searchAll(T key)                 //顺序查找并返回首个与key相等元素结点，若查找不成功，则返回null
    {
    	SinglyList<T> results = new SinglyList();
       //System.out.print(this.getClass().getName()+".search("+key+")，");
        for(Node<T> p=this.head.next;  p!=null;  p=p.next)
        {
        	//System.out.print(p.data.toString()+"？");
        	if (p.data.equals(key))              //执行T类的equals(Object)方法，运行时多态
              results.insert(p.data);
        }
        
        if (0 == results.size())
        	return null;
        else
        	return results;
    }

    //顺序查找并删除首个与key相等元素结点，返回被删除元素；若查找不成功，则返回null
    public T remove(T key)
    {
        //以下for循环，p遍历单链表（front指向p的前驱结点），顺序查找与key相等元素结点
        for(Node<T> front=this.head, p=front.next; p!=null; front=p, p=p.next)
        {
            if(p.data.equals(key))               //若查找成功
            {
                front.next = p.next;             //删除front的后继（p结点），包括头删除、中间/尾删除
                return p.data;
            }
        }
        return null;
    }
    
    public T get(T key)
    {
        //以下for循环，p遍历单链表（front指向p的前驱结点），顺序查找与key相等元素结点
        for(Node<T> front=this.head, p=front.next; p!=null; front=p, p=p.next)
        {
            if(p.data.equals(key))               //若查找成功
            {
                return p.data;
            }
        }
        
        return null;
    }
    //快速排序
    public static void quickSort(Dishes[] dis) {
    	quickSort(dis,0,dis.length-1);
    }
    private static void quickSort(Dishes[] dis,int begin,int end) {
    	if(begin>=0 &&begin<end && end<dis.length) {
    		int i=begin,j=end;
    		int x=Integer.parseInt(dis[i].prize);
    		Dishes m=dis[i];
    		while(i!=j) {
    			while(i<j && Integer.parseInt(dis[j].prize)>=x)
    				j--;
    			if(i<j)
    				dis[i++]=dis[j];
    			while(i<j &&Integer.parseInt(dis[i].prize)<=x)
    				i++;
    				if(i<j)
    					dis[j--]=dis[i];
    		}
    		dis[i]=m;
    		quickSort(dis,begin,j-1);
    		quickSort(dis,i+1,end);
    	}
    }
   
}