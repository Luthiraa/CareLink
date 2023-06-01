import java.time.*;

public class myHealth extends Person {
    private String location;
    public final boolean married = false;
    GPSLocation gps = new GPSLocation();

    public myHealth(String name, int age, String gender) {
        super(name, age, gender);
        this.location = gps.getUserLocationData();
    }

    @Override
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
    private static String name;
    private static int age;
    private static String gender;
    private static final int defaultAge = 18;
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

    public Date getDate() {
        return date;
    }

    // public String toString() {
    // if (date instanceof Date)
    // (Date date).getDate();
    // }

    @Override
    public String getLocation() {
        throw new UnsupportedOperationException("Unimplemented method 'getLocation'");
    }
}