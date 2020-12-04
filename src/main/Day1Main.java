package src.main;

import java.io.FileNotFoundException;

import src.processor.Day1Processor;

public class Day1Main {

	public static void main(String[] args) {
		System.out.println("Day 1 Program Started");
		Day1Processor day1 = new Day1Processor();
		try {
			day1.process();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		System.out.println("Day 1 Program Completed");
	}
}
