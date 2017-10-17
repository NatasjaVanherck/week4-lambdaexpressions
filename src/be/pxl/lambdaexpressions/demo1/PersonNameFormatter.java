package be.pxl.lambdaexpressions.demo1;

@FunctionalInterface
public interface PersonNameFormatter {
	String formatName(Person person);
}
