package com.humanCloud.dataStructure;

import com.humanCloud.customeException.DoubleLinkedListIndexOutOfBoundException;
import com.humanCloud.customeException.EmptyDoubleLinkedListException;
import org.springframework.stereotype.Service;

@Service
public class CustomeDoubleLinkedList {
	
	private Node head;

	private int size;
	
	class Node {
		
		private Node pre;
		private int data;
		private Node next;
		
		
		public Node(int data) {
			this.pre=null;
			this.data=data;
			this.next=null;
		}
	}
		
		
		//---------------addInEnd------------------------
		
		public void addInEnd(int val) {
			Node node=new Node(val);		
			if(size==0) {
				head=null;
			}
			
			Node temp=head;
			if(head==null) {
				head=node;
			}else {
				for(int i=1;i<size;i++) {
					temp=temp.next;
				}
				temp.next=node;
				node.pre=temp;
			}
			size++;
		}
		
		//---------addinbegining---------------------
		
		public void addInBegining(int val) {
			Node node=new Node(val);
			
			if(size==0) {
				head=node;
			}else {
				Node temp=head;
				head=node;
				temp.pre=node;
				head.next=temp;
			}
				
			size++;
		}
		
		
		//--------display forward-----------------------
		
		public void displayForward() throws EmptyDoubleLinkedListException {
			if(size==0) {
				//System.out.println("Empty");
				//return;
				throw new EmptyDoubleLinkedListException("Double Linked List is Empty. can not perform displayForward operation.");
			}
			
			Node temp=head;
		    while(temp!=null) {
		    	System.out.print(temp.data+" ");
		    	temp=temp.next;
		    }
		    System.out.println();
			
		}
		
		//------------display backword direction----------------
		
		public void displayBackword() throws EmptyDoubleLinkedListException {
			if(size==0) {
				//System.out.println("Empty");
				//return;
				throw new EmptyDoubleLinkedListException("Double Linked List is Empty. can not perform displayBackword operation.");  
			}
			
			
			Node temp=head;
			for(int i=1;i<size;i++) {
				temp=temp.next;
			}
			
			while(temp!=null) {
				System.out.print(temp.data+" ");
				temp=temp.pre;
			}
			System.out.println();
		}
		
		
		//--------------delete in forwards------------
		
		public void deleteForward() throws  EmptyDoubleLinkedListException {
			if(size==0) {
				throw new EmptyDoubleLinkedListException("Double linked list is Empty");
			}
			if(size==1) {
				head=null;
			}else {
			head=head.next;
			head.pre=null;
			}
		    size--;
		}
		
		
		//---------delete forward uing index-----------
		
		public void deleteForward(int index) throws EmptyDoubleLinkedListException, DoubleLinkedListIndexOutOfBoundException {
			if(size==0) {
				throw new EmptyDoubleLinkedListException("Double linked list is Empty");
				
			}
			
			if(index>size) {
				throw new DoubleLinkedListIndexOutOfBoundException("double linked list index out of bound exception");
				
			}
			
			Node temp=head;
			if(index==1) {
				deleteForward();
			}else {
				for(int i=2;i<index;i++) {
					temp=temp.next;
				}
				
				if(size==index) {
					temp.next=null;
				}else {
					Node node =temp.next.next;
					node.pre=temp;
					temp.next=node;
				}
					    		
				size--;		
				
			}
		}
		
		//---------delete in backword----------------
		
		public void deleteInBackword() throws EmptyDoubleLinkedListException {
			if(size==0) {
				throw new EmptyDoubleLinkedListException("Double linked list is Empty");
			}
			Node temp=head;
			for(int i=1;i<size-1;i++) {
				temp=temp.next;
			}
			//System.out.println(temp.data);
			temp.next=null;
			size--;
			
		}
		
		
		//-------------------------------------------
		
		public static void main(String[] args) throws Exception {
			CustomeDoubleLinkedList l=new CustomeDoubleLinkedList();
			l.addInEnd(1);
			l.addInEnd(2);
			l.deleteForward();
			System.out.println(l.size);
			l.deleteForward();
			l.displayForward();
			
			
		
			
			
		}
			
	

}
