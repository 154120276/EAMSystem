package cn.zcj.domain;

public class BanJi {
    private int Sno;
    private String classname;
    private int teacherid;
    private String teachername;

    public int getSno() {
        return Sno;
    }

    public void setSno(int sno) {
        Sno = sno;
    }

    public String getClassname() {
        return classname;
    }

    public void setClassname(String classname) {
        this.classname = classname;
    }

    public int getTeacherid() {
        return teacherid;
    }

    public void setTeacherid(int teacherid) {
        this.teacherid = teacherid;
    }

    public String getTeachername() {
        return teachername;
    }

    public void setTeachername(String teachername) {
        this.teachername = teachername;
    }

    @Override
    public String toString() {
        return "Class{" +
                "Sno=" + Sno +
                ", classname='" + classname + '\'' +
                ", teacherid=" + teacherid +
                ", teachername=" + teachername +
                '}';
    }
}
