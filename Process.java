public class Process {
    private String name;
    private int id;

    public Process(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return name + "(ID:" + id + ")";
    }
}