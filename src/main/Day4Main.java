package src.main;

import java.io.FileNotFoundException;
import java.io.IOException;

import src.processor.Day4Processor;

public class Day4Main {

	public static void main(String[] args) throws IOException {
		System.out.println("Day 4 Program Started");
		Day4Processor day4 = new Day4Processor();
		try {
			day4.processPart1();
			day4.processPart2();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		System.out.println("Day 4 Program Completed");
	}
}
