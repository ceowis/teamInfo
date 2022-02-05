package ui;

import org.apache.commons.lang.StringUtils;

public class UiUtils {
	public static boolean  isSmallLength(String name, String fieldName, int length){
		if(name == null){
			return true;
		}

		if(length < name.length()){
			System.out.println(fieldName+ "는 "+ length + "문자 이하로 입력해주십시오");
			return false;
		}
		return true;
	}

	public static boolean isNumeric(String str, String fieldName){
		//수치?
		if(!StringUtils.isNumeric(str)){
			System.out.printf(fieldName + "는 숫자로 입력해 주십시오");
			return false;
		}
		return true;
	}
}
