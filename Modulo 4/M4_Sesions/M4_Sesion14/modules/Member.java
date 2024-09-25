package M4_Sesion14.modules;

public class Member {
    private String name;
    private int age;
    private String positionInClub;

    public Member(String name, int age, String positionInClub) {
        this.name = name;
        this.age = age;
        this.positionInClub = positionInClub;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getPositionInClub() {
        return positionInClub;
    }

    public void setPositionInClub(String positionInClub) {
        this.positionInClub = positionInClub;
    }

    @Override
    public String toString() {
        return "Member [" +
                "name= '" + name + '\'' +
                ", age= " + age +
                ", positionInClub= '" + positionInClub + '\'' +
                "]";
    }
}
