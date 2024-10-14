
public abstract class Employee implements Comparable <Employee> {
    protected int salary;
    protected int pto;
    public static int workers;

    public Employee(int salary, int pto) {
        this.salary = salary;
        this.pto = pto;
        workers++;
    }

    public void vacation(int days){
	    pto = pto - days;
	}

    public int compareTo(Employee a) {
        if (this.salary == a.salary) {
            return 0;
        }
        else if (this.salary > a.salary) {
            return 1;
        }
        else {
            return -1;
        }
    }
}
