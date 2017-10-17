package be.pxl.lambdaexpressions.demo1;

import java.util.function.Predicate;

public class LambdaApp {

	public static void main(String[] args) {
		Person dali = new Person("Salvator", "Dali");
		
		PersonNameFormatter myFormatter = new PersonNameFormatter() {
			@Override
			public String formatName(Person person) {
				return person.getLastName().toUpperCase();
			}
		};
		
		// inkomende parameter -> inhoud methode
		PersonNameFormatter justAnotherFormatter = persoon -> persoon.getFirstName().toUpperCase();
		
		printPersonName(justAnotherFormatter, dali);
		printPersonName(person -> person.getFirstName(), dali);
		printPersonName(Person::getFirstName, dali);
		printSometimes(p -> p.getFirstName().length() > 5,
							Person::getFirstName,
							dali);
	}
	
	private static void printPersonName(PersonNameFormatter pnf, Person person){
		System.out.println(pnf.formatName(person));
	}
	
	private static void printSometimes(Predicate<Person> myTest, PersonNameFormatter pnf, Person person){
		if (myTest.test(person)){
			System.out.println(pnf.formatName(person));
		} else {
			System.out.println("MIS");
		}
	}
}
