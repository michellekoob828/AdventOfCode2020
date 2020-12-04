package src.main;

import java.io.FileNotFoundException;
import java.io.IOException;

import src.processor.Day3Processor;

public class Day3Main {

	public static void main(String[] args) throws IOException {
		System.out.println("Day 3 Program Started");
		Day3Processor day3 = new Day3Processor();
		try {
			day3.process();
			day3.processPart2();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		System.out.println("Day 3 Program Completed");
	}
}
