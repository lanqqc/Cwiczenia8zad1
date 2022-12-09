interface Salary {
    void salaryToPay(int hours);
    void salaryForOvertime();
    int yearsOfExperience();
}
class Person implements Salary
{
    public int salary = 1000;
    public String surname;
    public String name;
    public String street;
    public int index;
    public String city;
    public int age;
    public int hours;

    public void Initialization(String surname, String name, String street, int index, String city, int age, int hours) {
        this.surname = surname;
        this.name = name;
        this.street = street;
        this.index = index;
        this.city = city;
        this.age = age;
        this.hours = hours;
    }

    public void Print() {
        System.out.println("\nSurname: " + this.surname +
                "\nName:" + this.name +
                "\nStreet:" + this.street +
                "\nIndex:" + this.index +
                "\nCity:" + this.city +
                "\nAge:" + this.age +
                "\nHours:" + this.hours);
    }

    @Override
    public void salaryToPay(int hours) {
        salaryForOvertime();
        salary += hours * 10;
    }

    @Override
    public void salaryForOvertime() {
        salary = yearsOfExperience();
        if (hours>=120) {
            salary += (hours-120) * 5;
        }
    }

    @Override
    public int yearsOfExperience() {
        if (age>=25) {
            System.out.println("You have default salary + bonus: 1000$ + 500$");
            return 1500;
        } else {
            System.out.println("You have default salary: 1000$");
            return 1000;
        }
    }
}
class Staff extends Person
{
    public String study;
    public String post;

    public void Initialization1(String surname, String name, String street, int index, String city, int age, int hours, String study, String post) {
        this.Initialization(surname, name, street, index, city, age, hours);
        this.study = study;
        this.post = post;
    }

    public void Print1() {
        this.Print();
        System.out.println("Study: " + this.study +
                "\nPost: " + this.post);
    }
}


public class zadanie1
{
    public static void main(String[] args) {
        System.out.println("Hello World");

        Staff pasha = new Staff();
        pasha.Initialization1("Nasennik", "Pasha", "Flex", 2281337, "Big", 21 , 90 ,"School #157", "CS:GO professional");
        pasha.Print1();

        pasha.salaryToPay(pasha.hours);
        System.out.println("Your final salary: $" + pasha.salary);
    }
}