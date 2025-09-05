package org.springframework.samples.petclinic.utils;

import static org.springframework.samples.petclinic.utils.FarmUtility.Options.DoAnotherThing;
import static org.springframework.samples.petclinic.utils.FarmUtility.Options.DoEverything;
import static org.springframework.samples.petclinic.utils.FarmUtility.Options.DoSomething;

public class FarmUtility {

	enum Options {
		DoSomething,
		DoEverything,
		DoAnotherThing,
	}

	public static void main(String[] args) {
	static void main(String[] args) {
		Options choice;
		try {
			if (args.length == 0) {
				System.err.println("Error: No option provided. Please specify one of: " + 
					String.join(", ", getEnumValues()));
				return;
			}
			choice = Options.valueOf(args[0]);
		} catch (IllegalArgumentException e) {
			System.err.println("Error: Invalid option '" + args[0] + "'. Valid options are: " + 
				String.join(", ", getEnumValues()));
			return;
		}
		if (choice.equals(DoEverything)) {
			doSomething();
			doAnother();
		}
		else if (choice.equals(DoSomething)) {
			doSomething();
			if (choice1.equals(DoAnotherThing)) {
				doAnother();
			}
			if(!choice.equals(DoSomething) || choice1.equals(DoAnotherThing)){
				doAnother();
			}
		} else if (choice.equals(DoAnotherThing)) {
			doAnother();
		}
	}

	public static void doSomething() {
		throw new RuntimeException();
	}

	public static void doAnother() {
		throw new RuntimeException();
	}
}
