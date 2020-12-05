package src.processor;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import src.vo.Constants;
import src.vo.PassportData;

public class Day4Processor {
	
	public static final String FILE_NAME = "src/resources/InputDay4";

	public void processPart1() throws IOException {
		System.out.println("Part 1 Started");
		List<PassportData> passportDataList = this.parsePassportData();
		int validPassportCount = 0;
		
		for(PassportData passport : passportDataList) {
			if(this.isPassportValid(passport)) {
				validPassportCount++;
			}
		}
		
		System.out.println("Valid passport count: " + validPassportCount);
		System.out.println("Part 1 Ended");
	}
	
	private boolean isPassportValid(PassportData passport) {
		return (!passport.getBirthYear().isEmpty() &&
				!passport.getExpirationYear().isEmpty() &&
				!passport.getEyeColor().isEmpty() &&
				!passport.getHairColor().isEmpty() &&
				!passport.getHeight().isEmpty() &&
				!passport.getIssueYear().isEmpty() &&
				!passport.getPassportId().isEmpty());
	}
	
	private List<PassportData> parsePassportData() throws IOException {
		List<PassportData> passportDataList = new ArrayList<>();
		int passportIndex = 0;
		boolean isNewPassport = true;
		
		FileReader fr = new FileReader(FILE_NAME); 
		BufferedReader bufr = new BufferedReader(fr);
		String line = bufr.readLine();
		
		while(line != null){
			if(Constants.EMPTY_STRING.equals(line)) {
				isNewPassport = true;
				passportIndex++;
			} else {
				this.initializeNewPassport(passportDataList, isNewPassport);
				String[] data = line.split(Constants.SPACE);
				for(String d : data) {
					String[] pair = d.split(Constants.COLON);
					this.setPassportField(pair[0], pair[1], passportDataList, passportIndex);
				}
				isNewPassport = false;
			}
			
			line = bufr.readLine(); 
		}
		
		bufr.close();
		
		return passportDataList;
	}
	
	private void initializeNewPassport(List<PassportData> passportDataList, boolean isNewPassport) {
		if(isNewPassport) {
			PassportData pd = new PassportData();
			passportDataList.add(pd);
		}
	}
	
	private void setPassportField(String fieldName, String fieldValue, List<PassportData> passportDataList, int passportCount) {
		switch(fieldName) {
		case "byr":
			passportDataList.get(passportCount).setBirthYear(fieldValue);
			break;
		case "iyr":
			passportDataList.get(passportCount).setIssueYear(fieldValue);
			break;
		case "eyr":
			passportDataList.get(passportCount).setExpirationYear(fieldValue);
			break;
		case "hgt":
			passportDataList.get(passportCount).setHeight(fieldValue);
			break;
		case "hcl":
			passportDataList.get(passportCount).setHairColor(fieldValue);
			break;
		case "ecl":
			passportDataList.get(passportCount).setEyeColor(fieldValue);
			break;
		case "pid":
			passportDataList.get(passportCount).setPassportId(fieldValue);
			break;
		case "cid":
			passportDataList.get(passportCount).setCountryId(fieldValue);
			break;
		}
	}
	
}
