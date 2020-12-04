package src.main;

import java.io.FileNotFoundException;
import java.io.IOException;

import src.processor.Day2Processor;

public class Day2Main {

	public static void main(String[] args) throws IOException {
		System.out.println("Day 2 Program Started");
		Day2Processor day2 = new Day2Processor();
		try {
			day2.process();
			day2.processPart2();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		System.out.println("Day 2 Program Completed");
	}
}
