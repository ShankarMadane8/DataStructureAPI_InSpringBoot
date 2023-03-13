package com.humanCloud.dataStructure;

import com.humanCloud.customeException.EmptyQueueException;
import org.springframework.stereotype.Service;

@Service
public class CustomeDynamicQueue {
	
	
	private int dynamicSize;
	private int rear;
    private int front;
    public int[] queueArray;
    int c=0;
    
    public CustomeDynamicQueue() {
		this(5);
	}
    
    public CustomeDynamicQueue(int inialSize) {
		this.dynamicSize=inialSize;
		this.front=-1;
		this.rear=-1;
		this.queueArray=new int[inialSize];
	}
    
    
    
    public void enQueue(int val) {
    	if(isFull()) {
    		resize(dynamicSize*2);
    		enQueue(val);
    		
    	}else {
    		
    		if(front==-1) {
    			front=0;
    		}
    		c++;
    		queueArray[++rear]=val;		 		
    	}
    }
    
    
    
    
    public int deQueue() throws EmptyQueueException  {
    	if(isEmpty()) {
    		//System.out.println("Queue is Empty");
    		throw new EmptyQueueException("Queue is Empty. can not perform deQueue operation.");
    		//return -1;
    	}else 
    	{
    		if(front==dynamicSize || front==rear+1) {
    			//System.out.println("queue empty");
    			front=-1;
    			rear=-1;
    			throw new EmptyQueueException("Queue is Empty. can not perform deQueue operation.");
    			//return -1;
    		}
    		c--;
    		return queueArray[front++];	
    	}
    }
    
    
    
    public int[] display() throws EmptyQueueException  {
    	
    	int[] newarray=new int[c];
    	if(!isEmpty()) {
    		int j=0;
    	for(int i=front;i<=rear;i++) {
    		System.out.print(queueArray[i]+" ");
    		newarray[j++]=queueArray[i];
    	}
    	return newarray;
    	}else{
    				
    		throw new EmptyQueueException("Queue is Empty. can not perform display operation.");
    		
    	}
    	//System.out.println();
    }
    
    
    
    public void resize(int newDynamicSize) {
		int[] newQueueArray=new int[newDynamicSize];
		for(int i=0;i<queueArray.length;i++) {
			newQueueArray[i]=queueArray[i];
		}
		queueArray=newQueueArray;
		dynamicSize=newDynamicSize;
		
	}



	public boolean isEmpty() {
    	return front==-1 ||front==rear+1;
    }
    
    public boolean isFull() {
    	return rear==dynamicSize-1;
    }
    
  
    public static void main(String[] args) throws EmptyQueueException {
		CustomeDynamicQueue stack=new CustomeDynamicQueue(2);
		stack.enQueue(1);
		stack.enQueue(2);
		stack.enQueue(3);
		stack.enQueue(4);
		stack.display();
		
	}
    

}
