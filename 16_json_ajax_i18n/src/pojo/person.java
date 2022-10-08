package pojo;

public class person {
    private Integer id;
    private String name;

    public person(Integer id, String name) {
        this.id = id;
        this.name = name;
    }
    public person(){}

    @Override
    public String toString() {
        return "person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
