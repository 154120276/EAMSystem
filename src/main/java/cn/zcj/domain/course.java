package cn.zcj.domain;

public class course {
    private int id;
    private int Cno;
    private String name;
    private int dayofweek;
    private String timeofday;
    private String place;
    private String teacher;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCno() {
        return Cno;
    }

    public void setCno(int cno) {
        Cno = cno;
    }

    public int getDayofweek() {
        return dayofweek;
    }

    public void setDayofweek(int dayofweek) {
        this.dayofweek = dayofweek;
    }

    public String getTimeofday() {
        return timeofday;
    }

    public void setTimeofday(String timeofday) {
        this.timeofday = timeofday;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public String getTeacher() {
        return teacher;
    }

    public void setTeacher(String teacher) {
        this.teacher = teacher;
    }

    @Override
    public String toString() {
        return "course{" +
                "id=" + id +
                ", Cno=" + Cno +
                ", name='" + name + '\'' +
                ", dayofweek=" + dayofweek +
                ", timeofday='" + timeofday + '\'' +
                ", place='" + place + '\'' +
                ", teacher='" + teacher + '\'' +
                '}';
    }
}
