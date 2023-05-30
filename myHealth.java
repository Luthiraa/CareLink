//import necessary libraries
import java.time.*;

public class myHealth extends HealthInformation {
    private String location;
    public final boolean married = false;
    GPSLocation gps = new GPSLocation();

    public myHealth(String name, int age, String gender) {
        super();
        this.location = gps.getUserLocationData();
    }

    public String getLocation() {
        return location;
    }

    public void setLocation() {
        this.location = gps.getUserLocationData();
    }
}

class Person extends HealthInformation {
    LocalDate today = LocalDate.now();
    private int year = today.getYear();
    private Month month = today.getMonth();
    private int day = today.getDayOfMonth();
    private String name;
    private int age;
    private String gender;
    private final int defaultAge = 18;
    public Date date = new Date(month, day, year);

    public Person(String name, int age, String gender) {
        super();
        this.name = name;
        this.age = age;
        this.gender = gender;
    }

    public Person(String name, int age) {
        super();
        this.name = name;
        this.age = age;
        this.gender = null;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getGender() {
        return gender;
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

    public String getLocation() {
        return null;
    }

    public Date getDate() {
        return date;
    }
}
