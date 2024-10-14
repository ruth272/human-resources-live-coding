/*
INSTRUCTIONS: 
1. Create a class Employee with good OOP
2. Implement the Comparable interface to allow employees to be sorted by salary
3. Extend the Employee class into a Manager class and an Intern class. See the comments next to the fields below for which class should have which fields. 
4. Complete the toString method to match the output in the unit tests.
5. Implement good OOP practices as discussed in class (as best as you can while passing the unit tests)
6. Keep track of the number of employees without relying on a separate method
7. Compile against and pass all the tests (your solution no longer needs to work with the code below); you will only earn points for tests passed.


*/

public class HumanResources {

	int [] pto; //all employees get paid time off
	int[] salary; //all employees get paid
    int[] bonuses; //only managers will get bonuses
    char[] grades; //only interns will get a grade
	String[] types; //each employee will either be a manager or an intern

	public void raise(){
		for(int i = 0; i < types.length; i++){
			if (types[i].equals("manager"))
				salary[i] = salary[i] * 10;
			if (types[i].equals("intern"))
				salary[i] = salary[i] * 2;
		}
	}

	public void vacation(int days){
		for(int i = 0; i < types.length; i++){
			pto[i] = pto[i] - days;
		}
	}

	public String roster(){
		String result = "Here are all the employees in the company: ";
		for(int i = 0; i < types.length; i++)
			result += types[i] + "\n";
		result += "There are " + types.length + " items total.\n";
		return result;
	}

}