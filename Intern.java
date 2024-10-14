public class Intern extends Employee{
    private char grades;

    public Intern(int salary, int pto, char grades){
        super(salary, pto);
        this.grades = grades;
    }

    public String toString() {
        return salary + " " + pto + " " + grades;
    }
    
    public int getSalary() {
        return salary;
    }

    public int getPTO(){
        return pto;
    }

    public void raise(){
        salary = salary * 2;
    }
}
