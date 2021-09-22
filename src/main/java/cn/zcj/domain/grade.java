package cn.zcj.domain;

public class grade {
    private int id;
    private int cno;
    private int sid;
    private String name;
    private String grade;
    private String updateby;

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCno() {
        return cno;
    }

    public void setCno(int cno) {
        this.cno = cno;
    }

    public int getSid() {
        return sid;
    }

    public void setSid(int sid) {
        this.sid = sid;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public String getUpdateby() {
        return updateby;
    }

    public void setUpdateby(String updateby) {
        this.updateby = updateby;
    }

    @Override
    public String toString() {
        return "grade{" +
                "id=" + id +
                ", cno=" + cno +
                ", sid=" + sid +
                ", name='" + name + '\'' +
                ", grade='" + grade + '\'' +
                ", updateby='" + updateby + '\'' +
                '}';
    }
}
