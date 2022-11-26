public class People
{
    String name;
    int age;
    String status;

    People(String name, int age, String status) // Parameterized Constructor
    {
        this.name = name;
        this.age = age;
        this.status = status;
    }

    public String toString()
    {
        return name + ", " + age + ", " + status;

    }
}