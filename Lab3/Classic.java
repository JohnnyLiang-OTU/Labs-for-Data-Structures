public class Classic extends Cd{
    private String primaryWork;

    Classic()
    {
        super();
        String primaryWork = "Unknown";
    }

    Classic(String primaryWork, String performers, String label, int selections, double playtime)
    {
        super(performers, label, selections, playtime);
        this.primaryWork = primaryWork;
        if(primaryWork == null)
        {
            this.primaryWork = "Unknown";
        }
    }
    void Report()
    {
        System.out.println("Performers: " + performers);
        System.out.println("Label: " + label);
        System.out.println("Selection: " + selections);
        System.out.println("PlayTime: " + playtime);
        System.out.println("Primary Work: " + this.primaryWork);
    }
}
