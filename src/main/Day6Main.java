package src.main;

import java.io.FileNotFoundException;

import src.processor.Day6Processor;

public class Day6Main {

	public static void main(String[] args) throws Exception {
		System.out.println("Day 6 Program Started");
		Day6Processor day6 = new Day6Processor();
		try {
			day6.processPart1();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		System.out.println("Day 6 Program Completed");
	}
}
