package src.main;

import java.io.FileNotFoundException;

import src.processor.Day5Processor;

public class Day5Main {

	public static void main(String[] args) throws Exception {
		System.out.println("Day 5 Program Started");
		Day5Processor day5 = new Day5Processor();
		try {
			day5.processPart1();
			day5.processPart2();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		System.out.println("Day 5 Program Completed");
	}
}
