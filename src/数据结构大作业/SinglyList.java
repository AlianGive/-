package ���ݽṹ����ҵ;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
import java.util.Scanner;

public class SinglyList<T>
{
    public Node<T> head;                         // ͷָ�룬ָ�������ͷ���
    //ע�⣬head����������Ȩ�ޣ���Ϊ7.2.2�ڣ�ͼ���ڽӱ��У�ɾ������Ҫ������2014��8��3��
    
    //��1�����췽��
    public SinglyList()                          //���췽��������յ�����
    {
        this.head = new Node<T>();               //����ͷ��㣬data��nextֵ��Ϊnull
    }
    
    //���쵥����β����values����Ԫ�أ��������пն��󡣵�����Ԫ�ش���������Ԫ�ش�����ͬ��O(n)
    public SinglyList(T[] values)
    {
        this();                                  //�����յ�����ֻ��ͷ���
        Node<T> rear = this.head;                //rearָ���������һ�����
        for(int i=0; i<values.length; i++)       //��values.length==0�����������
        {
        	if(values[i]!=null)
            {
                rear.next = new Node<T>(values[i], null);  //β���룬�����������rear���֮��
                rear = rear.next;                //rearָ���µ���β���
            }
        }
    }

    //��2���пա���ȡԪ�ء��󳤶ȡ����������ַ����ȷ���
    public boolean isEmpty()                     //�ж��Ƿ�գ�O(1)
    {
        return this.head.next==null;
    }

    public T get(int i)                          //���ص�i��Ԫ�أ�0��i<�������ȡ���iԽ�磬�򷵻�null��O(n)
    {
        Node<T> p=this.head.next;
        for(int j=0;  p!=null && j<i;  j++)      //����������Ѱ�ҵ�i����㣨pָ��
            p = p.next;
        return (i>=0 && p!=null) ? p.data : null;//��pָ���i����㣬�򷵻���Ԫ��ֵ
    }
   
    //���õ�i��Ԫ��Ϊx��0��i<����������x!=null��
    //��x==null���׳��ն����쳣����i���Խ�磬�׳����Խ���쳣��O(n)////û�з���ֵ
    public void set(int i, T x)
    {
        if(x==null)
            throw new NullPointerException("x==null");     //�׳��ն����쳣
        else
        {
            Node<T> p=this.head.next;
            for(int j=0;  p!=null && j<i;  j++)  //����Ѱ�ҵ�i����㣨pָ��
               p = p.next;
            if(i>=0 && p!=null)
               p.data = x;                       //pָ���i�����
            else throw new IndexOutOfBoundsException(i+"");//�׳����Խ���쳣
        }
    }
    
    //��������Ԫ�ص������ַ�������ʽΪ��(,)��������Object���toString()������O(n)
    public String toString()
    {
        String str="(";
       // String str=this.getClass().getName()+"(";//��������
        for(Node<T> p=this.head.next;  p!=null;  p=p.next) //p����������
        {
            str += p.data.toString();
            if(p.next!=null) 
                str += ","; 
            str += p.data.toString()+(p.next!=null?",":"");//�������һ�����ʱ���ӡ�,���ָ���
        }
        return str+")";                          //�ձ���()
    }
    
    public int size()                            //���ص������ȣ�O(n)
    {
        int i=0; 
        for(Node<T> p=this.head.next;  p!=null;  p=p.next) //p����������
            i++;
        return i;
    }
    
    //��3������
    //����x��Ϊ��i��Ԫ�أ�x!=null�����ز����㡣��i�ݴ���i<0����ͷ���룻��i>���ȣ���β���롣O(n)
    public Node<T> insert(int i, T x)
    {
        if(x==null)
            return null;               ////û�в����㡣����һ��ִ�н�������Ǵ��󣬲��׳��쳣
        Node<T> front=this.head;                 //frontָ��ͷ���
        for(int j=0;  front.next!=null && j<i;  j++)  //Ѱ�ҵ�i-1�������һ����㣨frontָ��
            front = front.next;
        front.next = new Node<T>(x, front.next); //��front֮�����ֵΪx��㣬����ͷ���롢�м�/β����
        return front.next;
    }
    public Node<T> insert(T x)                   //������β����x��O(n)������
    {
        //����insert(i,x)�����������ֵָ����������󣬱���һ�Σ�i�����ݴ�
        return insert(Integer.MAX_VALUE, x);     //Integer.MAX_VALUE��0x7fffffff�����������ֵ
   //   return insert(this.size(), x);           //��������������Σ�Ч�ʽϵ�
    }
    //�δ��õ��˷���ֵ����8�¡���8.2��  ʹ��ɢ�б��ʾԪ�ػ���ļ��ϡ�
    
//    public void insert(SinglyList<T> list){}
    //��˵���������������ء���Ȼ�����ò���Ϊnullʱ�������б���ͬ����������������ԣ�����������ȷ��ִ�����ط����е���һ����

    
    //��4��ɾ��
    public T remove(int i)         //ɾ����i��Ԫ�أ�0��i<�������ȣ����ر�ɾ��Ԫ�ء���iԽ�磬�򷵻�null��O(n)
    {
        Node<T> front=this.head;                 //frontָ��ͷ���
        for(int j=0;  front.next!=null && j<i;  j++)//����Ѱ�ҵ�i-1��㣨frontָ��
            front = front.next;
        if(i>=0 && front.next!=null)             //��front�ĺ�̽����ڣ���ɾ��֮
        {
            T x = front.next.data;               //��ô�ɾ��������õĶ���
            //ɾ��front�ĺ�̽�㣬����ͷɾ�����м�/βɾ������Java������Ժ��ͷŽ��ռ�ô洢��Ԫ
            front.next = front.next.next;
            return x;
        }
        return null;                             //��i<0��i>�����򷵻�null
        //throw new IndexOutOfBoundsException(i+"");       //�׳����Խ���쳣
    }

    public void clear()                          //ɾ�����������н��
    {
        this.head.next = null;                   //Java�Զ��ջ����н��ռ�õĴ洢�ռ�
    }

    //��5�����ң�ɢ�б���
    //���ܼ������������׸���key���Ԫ�ؽ�㣬�����Ҳ��ɹ�����null
    //�����������keyΪ�ն���Java���׳��ն����쳣
    //�㷨��Ч�ʣ�˳����ң�O(n)
    //����7.2.2��ͼ���ڽӱ����뷵�ؽ�㣬��ΪҪ���̽�㡣2014��8��6�գ�������Ӱ��δ�޸�

    //��5��˳����Һͻ��ڲ����㷨�Ĳ�����������ʡ��
    //8.3 ɢ�м����ã�
    public Node<T> search(T key)                 //˳����Ҳ������׸���key���Ԫ�ؽ�㣬�����Ҳ��ɹ����򷵻�null
    {
       //System.out.print(this.getClass().getName()+".search("+key+")��");
        for(Node<T> p=this.head.next;  p!=null;  p=p.next)
        {
        	//System.out.print(p.data.toString()+"��");
        	if (p.data.equals(key))              //ִ��T���equals(Object)����������ʱ��̬
              return p;
        }
        return null;
    }
    
    public SinglyList<T> searchAll(T key)                 //˳����Ҳ������׸���key���Ԫ�ؽ�㣬�����Ҳ��ɹ����򷵻�null
    {
    	SinglyList<T> results = new SinglyList();
       //System.out.print(this.getClass().getName()+".search("+key+")��");
        for(Node<T> p=this.head.next;  p!=null;  p=p.next)
        {
        	//System.out.print(p.data.toString()+"��");
        	if (p.data.equals(key))              //ִ��T���equals(Object)����������ʱ��̬
              results.insert(p.data);
        }
        
        if (0 == results.size())
        	return null;
        else
        	return results;
    }

    //˳����Ҳ�ɾ���׸���key���Ԫ�ؽ�㣬���ر�ɾ��Ԫ�أ������Ҳ��ɹ����򷵻�null
    public T remove(T key)
    {
        //����forѭ����p����������frontָ��p��ǰ����㣩��˳�������key���Ԫ�ؽ��
        for(Node<T> front=this.head, p=front.next; p!=null; front=p, p=p.next)
        {
            if(p.data.equals(key))               //�����ҳɹ�
            {
                front.next = p.next;             //ɾ��front�ĺ�̣�p��㣩������ͷɾ�����м�/βɾ��
                return p.data;
            }
        }
        return null;
    }
    
    public T get(T key)
    {
        //����forѭ����p����������frontָ��p��ǰ����㣩��˳�������key���Ԫ�ؽ��
        for(Node<T> front=this.head, p=front.next; p!=null; front=p, p=p.next)
        {
            if(p.data.equals(key))               //�����ҳɹ�
            {
                return p.data;
            }
        }
        
        return null;
    }
    //��������
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