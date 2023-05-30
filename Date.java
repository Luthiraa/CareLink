import java.time.Month;

class Date {
    private Month month;
    private int day;
    private int year;

    public Date(Month month, int day, int year) {
        this.month = month;
        this.day = day;
        this.year = year;

    }

    public Month getMonth() {
        return month;
    }

    public int getDay() {
        return day;
    }

    public int getYear() {
        return year;
    }

    public String toString() {
        return day + "/" + month + "/" + year;
    }

}