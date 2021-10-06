package cn.zcj.domain;

/**
 * @author changjiang
 * @date 2016/10/31
 */

public class examination {
    private int id;
    private int sid;
    private String gradename;
    private int score;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getSid() {
        return sid;
    }

    public void setSid(int sid) {
        this.sid = sid;
    }

    public String getGradename() {
        return gradename;
    }

    public void setGradename(String gradename) {
        this.gradename = gradename;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    @Override
    public String toString() {
        return "examination{" +
                "id=" + id +
                ", sid=" + sid +
                ", gradename='" + gradename + '\'' +
                ", score=" + score +
                '}';
    }
}
