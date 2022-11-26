public class Logs
{
    String username;
    String task;
    int year;

    Logs(String username, String task, int year)
    {
        this.username = username;
        this.task = task;
        this.year = year;
    }

    public String toString()
    {
        return "Name: " + username + " | Task: " + task + " | Year: " + year;
    }
}