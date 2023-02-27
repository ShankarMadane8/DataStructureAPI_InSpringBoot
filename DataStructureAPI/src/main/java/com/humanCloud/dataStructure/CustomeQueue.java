package com.humanCloud.dataStructure;

import com.humanCloud.customeException.EmptyQueueException;

public class CustomeQueue {

	private int size;
	private int rear;
	private int front;
	public int[] queueArray;

	public CustomeQueue(int inialSize) {
		this.size = inialSize;
		this.front = -1;
		this.rear = -1;
		this.queueArray = new int[inialSize];
	}

	public void enQueue(int val) {
		if (isFull()) {
			System.out.println("Queue is full");

		} else {

			if (front == -1) {
				front = 0;
			}

			queueArray[++rear] = val;
		}
	}

	public int deQueue() throws EmptyQueueException {
		if (isEmpty()) {
			// System.out.println("Queue is Empty");
			throw new EmptyQueueException("The stack is empty. can not delete element");
			// return -1;
		} else {
			if (front == size) {
				front = -1;
				rear = -1;
				// System.out.println("queue element is not delete becaue empty");
				throw new EmptyQueueException("The stack is empty. can not delete element");
				// return -1;
			}
			return queueArray[front++];

		}
	}

	public int[] display() throws EmptyQueueException {
		int[] newqueueArray=new int[rear-front];
		System.out.println("difference: "+rear+" "+front);
		if (!isEmpty()) {
			int c=0;
			for (int i = front; i <= rear; i++) {
				System.out.print(queueArray[i] + " ");
				newqueueArray[c]=queueArray[i];	
				c++;
			}
			return newqueueArray;
		} else {
			// System.out.println("queue is empty");
			throw new EmptyQueueException("The stack is empty. can not display value");
		}
	}

	public boolean isEmpty() {
		return front == -1;
	}

	public boolean isFull() {
		return rear == size - 1;
	}

//	public static void main(String[] args) throws EmptyQueueException {
//		CustomeQueue queue = new CustomeQueue(5);
//
////		System.out.println(queue.isEmpty());
////		System.out.println(queue.isFull());
//
//		queue.enQueue(1);
//
//		queue.enQueue(2);
//		queue.enQueue(3);
//		queue.enQueue(4);
//		queue.enQueue(5);
//
//		queue.display();
//
//		queue.deQueue();
//		System.out.println();
//		queue.display();
//
//		System.out.println();
//
//	}

}
