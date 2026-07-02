class TeamMember{
    protected String name;

    public TeamMember(String name)
    {
        this.name = name;
    }
}

class Employee extends TeamMember {
    public Employee(String name)
    {
        super(name);
    }

    public void calculateBonus()
    {
        System.out.println("Calculating employee bonus.");
    }
}

class Contractor extends TeamMember{
    public Contractor(String name)
    {
        super(name);
    }
    public void submitInvoice(){
        System.out.println("Submitting contractor invoice.");
    }
}
public class Main{
    public static void main(String[] args)
    {
        TeamMember member = new TeamMember("Ubaid");
        System.out.println("Member name: " + member.name);
        System.out.println();

        Employee emp = new Employee("Kadir");
        System.out.println("Employee name: " + emp.name);
        emp.calculateBonus();
        System.out.println();

        Contractor cnt = new Contractor("Joshim");
        System.out.println("Contractor name: " + cnt.name);
        cnt.submitInvoice();
        System.out.println();

    }
}
