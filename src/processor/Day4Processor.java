package src.processor;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import src.vo.Constants;
import src.vo.PassportData;
import src.vo.PassportEyeColor;

public class Day4Processor {
	
	public static final String FILE_NAME = "src/resources/InputDay4";
	public static final String HAIR_COLOR_REGEX = "#{1}[0123456789abcdef]{6}";
	public static final String PASSPORT_ID_REGEX = "[\\d]{9}";

	public void processPart1() throws IOException {
		System.out.println("Part 1 Started");
		List<PassportData> passportDataList = this.parsePassportData();
		int validPassportCount = 0;
		
		for(PassportData passport : passportDataList) {
			if(this.isPassportValidPart1(passport)) {
				validPassportCount++;
			}
		}
		
		System.out.println("Valid passport count: " + validPassportCount);
		System.out.println("Part 1 Ended");
	}
	
	public void processPart2() throws IOException {
		System.out.println("Part 2 Started");
		List<PassportData> passportDataList = this.parsePassportData();
		int validPassportCount = 0;
		
		for(PassportData passport : passportDataList) {
			if(this.isPassportValidPart2(passport)) {
				validPassportCount++;
			}
		}
		
		System.out.println("Valid passport count: " + validPassportCount);
		System.out.println("Part 2 Ended");
	}
	
	private boolean isPassportValidPart2(PassportData passport) {
		if(!this.isPassportValidPart1(passport)) {
			return false;
		}
		
		return (this.isYearValid(passport.getBirthYear(), 1920, 2002) &&
				this.isYearValid(passport.getIssueYear(), 2010, 2020) &&
				this.isYearValid(passport.getExpirationYear(), 2020, 2030) &&
				this.isHeightValid(passport.getHeight()) &&
				this.isHairColorValid(passport.getHairColor()) &&
				this.isEyeColorValid(passport.getEyeColor()) &&
				this.isPassportIdValid(passport.getPassportId()));
	}
	
	private boolean isYearValid(String passportYearString, int earliestYear, int latestYear) {
		int passportYear;
		try {
			passportYear = Integer.parseInt(passportYearString);
		} catch(NumberFormatException e) {
			return false;
		}
		
		return ((passportYear >= earliestYear) && (passportYear <= latestYear));
	}
	
	private boolean isHeightValid(String heightWithUnits) {
		int height;
		
		if(heightWithUnits.contains("cm")) {
			try {
				height = this.parseHeightValue(heightWithUnits, "cm");
				return this.isHeightValid(height, 150, 193);
			} catch (NumberFormatException e) {
				return false;
			}
		} else if(heightWithUnits.contains("in")) {
			try {
				height = this.parseHeightValue(heightWithUnits, "in");
				return this.isHeightValid(height, 59, 76);
			} catch (NumberFormatException e) {
				return false;
			}
		}
		
		return false;
	}
	
	private boolean isHairColorValid(String hairColor) {
		return (hairColor.matches(HAIR_COLOR_REGEX));
	}
	
	private boolean isEyeColorValid(String eyeColor) {
		return (PassportEyeColor.getValidEyeColors().contains(eyeColor));
	}
	
	private boolean isPassportIdValid(String passportId) {
		return (passportId.matches(PASSPORT_ID_REGEX));
	}
	
	private boolean isHeightValid(int passportHeight, int minHeight, int maxHeight) {
		return ((passportHeight >= minHeight) && (passportHeight <= maxHeight));
	}
	
	private int parseHeightValue(String heightWithUnits, String unit) {
		String heightString = heightWithUnits.substring(0, heightWithUnits.indexOf(unit));
		return Integer.parseInt(heightString);
	}
	
	private boolean isPassportValidPart1(PassportData passport) {
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
