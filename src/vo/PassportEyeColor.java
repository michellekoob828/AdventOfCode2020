package src.vo;

import java.util.Arrays;
import java.util.List;

public enum PassportEyeColor {

	AMB("amb"),
	BLU("blu"),
	BRN("brn"),
	GRY("gry"),
	GRN("grn"),
	HZL("hzl"),
	OTH("oth");
	
	private String eyeColorCode;
	
	private PassportEyeColor(String eyeColorCode) {
		this.eyeColorCode = eyeColorCode;
	}
	
	public static List<String> getValidEyeColors() {
		return validEyeColors;
	}
	
	protected static final List<String> validEyeColors = Arrays.asList(
			AMB.getEyeColorCode(),
			BLU.getEyeColorCode(),
			BRN.getEyeColorCode(),
			GRY.getEyeColorCode(),
			GRN.getEyeColorCode(),
			HZL.getEyeColorCode(),
			OTH.getEyeColorCode());

	public String getEyeColorCode() {
		return eyeColorCode;
	}

	public void setEyeColorCode(String eyeColorCode) {
		this.eyeColorCode = eyeColorCode;
	}

}
