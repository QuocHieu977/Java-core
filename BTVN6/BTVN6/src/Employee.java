public class Employee extends Person{
    private double exp;
    private String placeWork;

    public Employee() {

    }

    public Employee(int id, String name, int age, double exp, String placeWork) {
        super(id, name, age);
        this.exp = exp;
        this.placeWork = placeWork;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + getId() + "," +
                "name=" + getName() + "," +
                "age=" + getAge() + "," +
                "experience=" + exp + "," +
                "placeWork=" + placeWork +
                '}';
    }
}
