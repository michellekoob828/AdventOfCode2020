package src.main;

import java.io.FileNotFoundException;

import src.processor.Day7Processor;

public class Day7Main {

	public static void main(String[] args) throws Exception {
		System.out.println("Day 7 Program Started");
		Day7Processor day7 = new Day7Processor();
		try {
			day7.process();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		System.out.println("Day 7 Program Completed");
	}
}
