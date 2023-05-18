public class myHealth {
    private String name;
    private int age;
    private String gender;
    private String location;
    GPSLocation gps = new GPSLocation();

    public myHealth(String name, int age, String gender) {
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.location = gps.getUserLocationData();
    }

    public String getName() {
        return name;
    }

    public int age() {
        return age;
    }

    public String gender() {
        return gender;
    }

    public String getLocation() {
        return location;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setLocation () {
        this.location = gps.getUserLocationData();
    }
    

}