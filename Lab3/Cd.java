abstract public class Cd {
        protected String performers;
        protected String label;
        protected int selections;
        protected double playtime;
    
    Cd()
    {
        performers = "";
        label = "";
        selections = 0;
        playtime = 0.0;
    }
    Cd(String performers, String label, int selections, double playtime)
    {
        this.performers = performers;
        this.label = label;
        this.selections = selections;
        this.playtime = playtime;
    }
    abstract void Report();

}
