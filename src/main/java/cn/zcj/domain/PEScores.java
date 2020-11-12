package cn.zcj.domain;

public class PEScores {
    private int id;
    private double hight;
    private double weight;
    private double shortrun;
    private double shortrunscore;
    private int jump;
    private double jumpscore;
    private int pull_up;
    private double pull_upscore;
    private int Lungcapacity;
    private double Lungcapacityscore;
    private int longrun;
    private double longrunscore;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getHight() {
        return hight;
    }

    public void setHight(double hight) {
        this.hight = hight;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public double getShortrun() {
        return shortrun;
    }

    public void setShortrun(double shortrun) {
        this.shortrun = shortrun;
    }

    public double getShortrunscore() {
        return shortrunscore;
    }

    public void setShortrunscore(double shortrunscore) {
        this.shortrunscore = shortrunscore;
    }

    public int getJump() {
        return jump;
    }

    public void setJump(int jump) {
        this.jump = jump;
    }

    public double getJumpscore() {
        return jumpscore;
    }

    public void setJumpscore(double jumpscore) {
        this.jumpscore = jumpscore;
    }

    public int getPull_up() {
        return pull_up;
    }

    public void setPull_up(int pull_up) {
        this.pull_up = pull_up;
    }

    public double getPull_upscore() {
        return pull_upscore;
    }

    public void setPull_upscore(double pull_upscore) {
        this.pull_upscore = pull_upscore;
    }

    public int getLungcapacity() {
        return Lungcapacity;
    }

    public void setLungcapacity(int lungcapacity) {
        Lungcapacity = lungcapacity;
    }

    public double getLungcapacityscore() {
        return Lungcapacityscore;
    }

    public void setLungcapacityscore(double lungcapacityscore) {
        Lungcapacityscore = lungcapacityscore;
    }

    public int getLongrun() {
        return longrun;
    }

    public void setLongrun(int longrun) {
        this.longrun = longrun;
    }

    public double getLongrunscore() {
        return longrunscore;
    }

    public void setLongrunscore(double longrunscore) {
        this.longrunscore = longrunscore;
    }

    @Override
    public String toString() {
        return "PEScores{" +
                "id=" + id +
                ", hight=" + hight +
                ", weight=" + weight +
                ", shortrun=" + shortrun +
                ", shortrunscore=" + shortrunscore +
                ", jump=" + jump +
                ", jumpscore=" + jumpscore +
                ", pull_up=" + pull_up +
                ", pull_upscore=" + pull_upscore +
                ", Lungcapacity=" + Lungcapacity +
                ", Lungcapacityscore=" + Lungcapacityscore +
                ", longrun=" + longrun +
                ", longrunscore=" + longrunscore +
                '}';
    }
}
