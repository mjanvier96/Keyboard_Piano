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

public class GuitarString {
	private RingBuffer buffer;
	private int tics;
	
	// create a guitar string of the given frequency
	public GuitarString(double frequency){
		buffer = new RingBuffer(Math.round((float)4410/(float)frequency));
	}
	
	// create a guitar string whose size and initial values are given by the array
	public GuitarString(double init[]){
		buffer = new RingBuffer(init.length);
		for(int i = 0; i < init.length; i++){
			buffer.enqueue(init[i]);
		}
	}
	
	 // pluck the guitar string by setting the buffer to white noise
	public void pluck(){
		for(int i = 0; i < buffer.getSize(); i++){
			buffer.enqueue(Math.random() - .5);
		}
	}
	
	// advance the simulation one time step
	public void tic(){
		double x = buffer.dequeue();
		double y = buffer.peek();
		buffer.enqueue(.996 * .5*(x + y));
		tics++;
	}
	
	// return the current sample
	public double sample(){
		return buffer.peek();
	}
	
	// return number of times tic was called
	public int time(){
		return tics;
	}
	
	
}
