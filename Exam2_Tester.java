import org.junit.Test;
import static org.junit.Assert.assertEquals;

import java.io.*;
import java.util.*;

/*

You can compile and run your code with the following commands (make sure the unit testing jar is in your current directory)

javac -classpath ".:junit-platform-console-standalone-1.7.0-M1.jar" *.java
java -classpath ".:junit-platform-console-standalone-1.7.0-M1.jar" org.junit.runner.JUnitCore Exam2_Tester

*/

public class Exam2_Tester {

  @Test
  public void test1() {
    Manager boss = new Manager(80000, 12, 3000); // salary, pto, and bonus
    assertEquals("80000 12 3000", boss.toString());
  }
  
  @Test
  public void test2() {
    Intern intern = new Intern(5000, 1, 'A'); // salary, pto, letter grade
    assertEquals("5000 1 A", intern.toString());
  }

  @Test
  public void test3() {
    Employee.workers = 7;
    Manager boss = new Manager(80000, 12, 3000); 
    Intern intern = new Intern(5000, 1, 'A'); 
    assertEquals(9, Employee.workers);
  }

  @Test
  public void test4() {
    Manager boss = new Manager(11, 2, 3);
    boss.raise(); //void return type
    assertEquals(110, boss.getSalary());
  }

  @Test
  public void test5() {
    Intern intern = new Intern(5, 6, 'B');
    intern.raise(); //void return type
    assertEquals(10, intern.getSalary());
  }

  @Test
  public void test6() {
    Manager boss = new Manager(1, 2, 3);
    boss.vacation(3); //void return type
    assertEquals(-1, boss.getPTO());

    Intern intern = new Intern(5, 6, 'A');
    intern.vacation(7); //void return type
    assertEquals(-1, intern.getPTO());
  }

  @Test
  public void test8() {
    Manager boss = new Manager(1, 2, 3);
    Intern intern = new Intern(5, 6, 'B');
    assertEquals(1, intern.compareTo(boss)); //compares based on salaries
    assertEquals(-1, boss.compareTo(intern));
    assertEquals(0, boss.compareTo(boss));

    ArrayList<Employee> list = new ArrayList<Employee>();
    list.add(boss);
    list.add(intern);
    Collections.sort(list); // sorts based on salaries
  }

  @Test
  public void test9() {
    ArrayList<Employee> office = new ArrayList<Employee>();
    office.add(new Manager(1, 2, 3));
    office.add(new Intern(5, 6, 'A'));
    String printout = Arrays.toString(office.toArray());
    assertEquals("[1 2 3, 5 6 A]", printout);
    for(int i = 0; i < office.size(); i++){
      Employee item = office.get(i);
      item.vacation(3);
    }
  }

  @Test
  public void test10() {
    assertEquals(true, checkInFile("Employee.java", "public abstract class Employee"));
    assertEquals(true, checkInFile("Employee.java", "protected") || checkInFile("Employee.java", "private"));
  }

/*
    HELPER METHODS FROM LAB 2 TESTER
*/

  private boolean checkInFile(String filename, String phrase){
    try {
      File file = new File("./" + filename);
      Scanner scanner = new Scanner(file);
      while (scanner.hasNextLine()){
        String line = scanner.nextLine();
        line = line.replaceAll("\\s+","") ;
        phrase = phrase.replaceAll("\\s+","") ;
        if (line.contains(phrase))
          return true;
      }
    } catch(Exception e){
      e.printStackTrace();
    }
    return false;
  }

}
