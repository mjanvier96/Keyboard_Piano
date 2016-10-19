/*
 * Programming Homework 3
 *
 *
 * (c) 2015 Michael V. Janvier
 *
 * I pledge my honor that I have abided by the Stevens honor System
 *
 */

package Assign3;

public class RingBuffer {
	private double[] buffer;
	int lastIndex = 0;
	int firstIndex = 0;
	
	// create an empty buffer, with given max capacity
	public RingBuffer(int capacity){
		buffer = new double[capacity];
		for(int i = 0; i < buffer.length; i++)
			buffer[i] = -Double.MAX_VALUE;
	}
	
	// return number of items currently in the buffer
	public int getSize(){
		int size = 0;
		for(int i = 0; i < buffer.length; i++){
			if(buffer[i] != (-Double.MAX_VALUE)){
				size++;
			}
			
		}
		return size;
	}
	
	// is the buffer empty (size equals zero)?
	public boolean isEmpty(){
		if(getSize() == 0)
			return true;
		
		return false;
	}
	
	 // is the buffer full (size equals array capacity)?
	public boolean isFull(){
		if(getSize() == buffer.length)
			return true;
		
		return false;
	}
	
	// add item x to the end
	public void enqueue(double x){
			buffer[lastIndex] = x;
			if(lastIndex == buffer.length - 1) { lastIndex = 0; }
			else { lastIndex++; } 
		}
	
	// delete and return item from the front
	public double dequeue(){
		if(!isEmpty()){
			double temp = buffer[firstIndex];
			buffer[firstIndex] = -Double.MAX_VALUE;
			if(firstIndex == buffer.length - 1) { firstIndex = 0; }
			else { firstIndex++; } 
			return temp;
		}
		System.out.println("Buffer is empty");
		return 0;
	}
	
	// return (but do not delete) item from the front
	public double peek(){
		if(!isEmpty() && buffer[firstIndex] != -Double.MAX_VALUE)
			return buffer[firstIndex];
		
		return 0;
	}
}
