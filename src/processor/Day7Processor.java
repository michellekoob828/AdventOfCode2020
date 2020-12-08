package src.processor;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import src.vo.Constants;

public class Day7Processor {
	
	public static final String FILE_NAME = "src/resources/InputDay7";
	public static final String BAG_COLOR = "shiny gold";
	
	public void process() throws Exception {
		Map<String,Map<String,Integer>> luggageRules = this.parseInput();
		this.processPart1(luggageRules);
	}

	private void processPart1(Map<String,Map<String,Integer>> luggageRules) throws Exception {
		System.out.println("Part 1 Started");
		int bagColorCount = 0;
		
		for(Map.Entry<String,Map<String,Integer>> rule : luggageRules.entrySet()) {
			if(this.doesRuleContainBagColor(luggageRules, rule, BAG_COLOR)) {
				bagColorCount++;
			}
		}
		
		System.out.println("Bag color count: " + bagColorCount);
		System.out.println("Part 1 Ended");
	}
	
	private boolean doesRuleContainBagColor(Map<String,Map<String,Integer>> luggageRules, Map.Entry<String,Map<String,Integer>> rule, String bagColor) {
		Map<String,Integer> bagsUnderRule = this.findAllContainingBags(luggageRules, rule);
		if(bagsUnderRule.containsKey(bagColor)) {
			return true;
		}
		
		return false;
	}
	
	private Map<String,Integer> findAllContainingBags(Map<String,Map<String,Integer>> luggageRules, Map.Entry<String,Map<String,Integer>> rule) {
		Map<String,Integer> unprocessedBags = new HashMap<>();
		Map<String,Integer> processedBags = new HashMap<>();
		
		//process initial rule
		for(Map.Entry<String,Integer> bag : rule.getValue().entrySet()) {
			if(bag.getValue() > 0) {
				unprocessedBags.put(bag.getKey(), bag.getValue());
			}
		}
		
		while(!unprocessedBags.isEmpty()) {
			Map<String,Integer> tempUnprocessedBags = new HashMap<>();
			tempUnprocessedBags.putAll(unprocessedBags);
			
			//loop through each unprocessed bag
			for(Map.Entry<String,Integer> ub : tempUnprocessedBags.entrySet()) {
				//find the rule associated with the unprocessed bag
				Map<String,Integer> newRule = luggageRules.get(ub.getKey());
				//loop through each bag in the new rule
				for(Map.Entry<String,Integer> newBag : newRule.entrySet()) {
					if(newBag.getValue() > 0 && !processedBags.containsKey(newBag.getKey())) {
						unprocessedBags.put(newBag.getKey(), newBag.getValue());
					}
				}
				unprocessedBags.remove(ub.getKey());
				processedBags.put(ub.getKey(), ub.getValue());
			}
		}
		
		return processedBags;
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
