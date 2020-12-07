package src.processor;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import src.vo.Constants;

public class Day7Processor {
	
	public static final String FILE_NAME = "src/resources/InputDay7";
	
	public void process() throws Exception {
		Map<String,Map<String,Integer>> luggageRules = this.parseInput();
		this.processPart1(luggageRules);
		//this.processPart2(groups);
	}

	private void processPart1(Map<String,Map<String,Integer>> luggageRules) throws Exception {
		System.out.println("Part 1 Started");
		int bagColorCount = 0;
		for(Map.Entry<String, Map<String,Integer>> bag : luggageRules.entrySet()) {
			if(this.canContainBagColor(luggageRules, bag.getKey(), "shiny gold")) {
				bagColorCount++;
			}
		}
		
		System.out.println("Bag color count: " + bagColorCount);
		System.out.println("Part 1 Ended");
	}
	
	private boolean canContainBagColor(Map<String,Map<String,Integer>> luggageRules, String currentColorRule, String bagColor) {
		//TODO: Add logic
		
		
		
		return false;
	}
	
	private Map<String,Map<String,Integer>> parseInput() throws IOException {
		Map<String,Map<String,Integer>> luggageRules = new HashMap<>();
		
		FileReader fr = new FileReader(FILE_NAME); 
		BufferedReader bufr = new BufferedReader(fr);
		String line = bufr.readLine();
		
		while(line != null){
			String[] a = line.split("bags contain");
			String bagColor = a[0].trim();
			Map<String,Integer> bagContents = this.parseBagContents(a[1].trim());
			luggageRules.put(bagColor, bagContents);			
			line = bufr.readLine(); 
		}
		
		bufr.close();
		return luggageRules;
	}
	
	private Map<String,Integer> parseBagContents(String bagContents) {
		Map<String,Integer> bagContentMap = new HashMap<>();
		
		String[] b = bagContents.split(Constants.COMMA);
		//parse through contents of the bag
		for(String c : b) {
			String bagContent = c.trim();
			String[] d = bagContent.split(Constants.SPACE);
			int numBags;
			StringBuilder color = new StringBuilder();
			if("no".equals(d[0])) {
				numBags = 0;
				color.append(Constants.EMPTY_STRING);
			} else {
				numBags = Integer.parseInt(d[0]);
				for(int i = 1; i<(d.length-1); i++) {
					color.append(d[i]);
					color.append(Constants.SPACE);
				}
			}
			bagContentMap.put(color.toString().trim(), numBags);
		}
		return bagContentMap;
	}
	
}
