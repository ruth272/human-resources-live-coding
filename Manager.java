public class Manager extends Employee {
    private int bonuses;

    public Manager(int salary, int pto, int bonuses){
        super(salary, pto);
        this.bonuses = bonuses;
    }

    public String toString() {
        return salary + " " + pto + " " + bonuses;
    }

    public int getSalary() {
        return salary;
    }

    public int getPTO(){
        return pto;
    }

    public void raise(){
        salary = salary * 10;
    }
}
