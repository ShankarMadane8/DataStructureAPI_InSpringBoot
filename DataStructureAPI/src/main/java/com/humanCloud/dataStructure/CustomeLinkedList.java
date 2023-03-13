package com.humanCloud.dataStructure;

import com.humanCloud.customeException.EmptyLinkedListException;
import com.humanCloud.customeException.LinkedListIndexOutOfBoundException;
import org.springframework.stereotype.Service;

@Service 
public class CustomeLinkedList {
	
	private Node head;
	private int size=0;
	
	//create Node Class
	class Node{
	   	private int val;
		private Node next;
		
		public Node(int val) {
			this.val = val;
		}		
	}
	
	//----------------------------------------------------
	
	//insert Node Val 1n
	public  Node insert(int val) {  
		Node node=new Node(val);		
//		node.next=head;
//		head=node;
		Node temp=head;
		if(head==null) {
			head=node;
		}else {
			for(int i=1;i<size;i++) 
				temp=temp.next;		
       		temp.next=node;			
		}
		
		++size;
		return node;
	}
	
	//---------------------------------------------------------------
	
	//display val
	public int[] display() throws EmptyLinkedListException {
		Node temp=head;
		int[] linkedListArray=new int[size];
		int c=0;
		if(size!=0) {
			while(temp!=null) {
				System.out.print(temp.val+" ");
				linkedListArray[c]=temp.val;
				temp=temp.next;
				c++;
			}
			System.out.println();
			return linkedListArray;
		}else {
			//System.out.println("linked list is empty");
			throw new EmptyLinkedListException("linked list is empty");
		}
	
	}
	
	//------------------------------------------------------------
	
	// delete val
	public void delete() throws EmptyLinkedListException {
//		Node temp=head.next;
//		head=temp;
		if(size==0) {
			throw new EmptyLinkedListException("Linked list is Empty");
		}
		head=head.next;
		--size;
	}
	
	
	//------------------------------------------------------------
	
	//delete val using index
   public void delete(int index) throws LinkedListIndexOutOfBoundException, EmptyLinkedListException {
	   Node temp=head;
//	   System.out.println("----------- Address of temp and head ----------------");
//	   System.out.println(System.identityHashCode(temp));
//	   System.out.println(System.identityHashCode(head));
//	   System.out.println(temp.hashCode()+" --> "+head.hashCode());
//	   System.out.println("---------------------------");
	   
	   
	   if(size==0) {
		   throw new EmptyLinkedListException("linked list is empty");
	   }
	   
	   if(index>size) {
		   //System.err.println(index+" index out of bound Exception");
		   //return;
		   throw new LinkedListIndexOutOfBoundException("index out of bound Exception");
	   }
	   if(1==index) {
		   delete();
	   }else {
         // previce node of deleted Node		   
		 for(int i=2;i<index;i++) {	
			 
			  temp=temp.next;
			  System.out.println(temp+" "+i);	  
		 }	
			
			 Node node = temp.next.next;
		     temp.next = node;	     	    
		     --size;
				 
	   }  
	   
	   
	  
	  
   }
	
   
   
   
   

   
   //---------------------------------------------------------------
   
   
	
	public static void main(String[] args) throws LinkedListIndexOutOfBoundException, EmptyLinkedListException {
		CustomeLinkedList l=new CustomeLinkedList();
		l.insert(4);
		l.insert(5);
		l.insert(6);
		l.insert(7);
		l.delete();
		l.display();
		l.delete(2);
		l.display();					
	}

}
