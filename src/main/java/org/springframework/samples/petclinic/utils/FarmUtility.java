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
		Options choice = Options.valueOf(args[0]);
		Options choice1 = Options.valueOf(args[1]);
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
