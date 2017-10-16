package be.pxl.lambdaexpressions.opdracht1;

import java.util.ArrayList;

public class NumberSelector {
	private NumberMachine machine;
	
	public NumberSelector(NumberMachine machine){
		this.machine = machine;
	}
	
	public String showEvenNumbers(){	
		NumberFilter filter = new NumberFilter(){
			public boolean check(int number) {
				if(number%2 == 0){
					return true;
				} else
					return false;
				}		
		};		
		return machine.processNumbers(filter);
	}
	
	public String showNumbersAbove(int number){
		NumberFilter filter = s -> {
			if (number < s){
				return true;
			} else {
				return false;
			}
		};
		return machine.processNumbers(filter);
	}
	
	public String printHexNumbers(){
		String result = "";
		ArrayList<Integer> numbers = machine.getNumbers();
		
		for(int i=0;i<numbers.size();i++) {
				result += convertNumbers(numbers.get(i));
				if(!(i == numbers.size()-1)){
					result += "-";
				}
			}
		return result;
	}
	
	public String convertNumbers(int number){
		Converter hexString = s -> Integer.toHexString(number);
		return hexString.toString();
		//return Integer.toHexString(number);
	}
}
