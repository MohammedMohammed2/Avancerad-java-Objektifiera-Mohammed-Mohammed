public class People implements Comparable<People>{
    private String name;

    public People(String name) {
        this.name = name;
    }

    public String getName(){
        return name;
    }

    public String toString(){
        return"name="+ name;
    }

    @Override
    public int compareTo(People o) {
        return name.compareTo(o.getName());
    }

}
