package be.pxl.lambdaexpressions.opdracht1;

public class NumberSelector {
	private NumberMachine machine;
	
	public NumberSelector(NumberMachine machine){
		this.machine = machine;
	}
	
	public String showEvenNumbers(){	
		NumberFilter filter = new NumberFilter(){
			public boolean check(int number) {
				return (number%2 == 0);	
		    }
		};
		return machine.processNumbers(filter);
	}
	
	public String showNumbersAbove(int number){
		NumberFilter filter = s -> (number < s);
		return machine.processNumbers(filter);
	}
	
	public String printHexNumbers(){
		//Integer => String(Integer)
		return machine.convertNumbers(n -> Integer.toHexString(n));
	}
}
