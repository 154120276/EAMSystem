package cn.zcj.domain;



public class announcement {

    private int id;
    private int cid;
    private int tid;
    private String teachername;
    private String Content;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCid() {
        return cid;
    }

    public void setCid(int cid) {
        this.cid = cid;
    }

    public int getTid() {
        return tid;
    }

    public String getTeachername() {
        return teachername;
    }

    public void setTeachername(String teachername) {
        this.teachername = teachername;
    }

    public void setTid(int tid) {
        this.tid = tid;
    }

    public String getContent() {
        return Content;
    }

    public void setContent(String content) {
        Content = content;
    }

    @Override
    public String toString() {
        return "announcement{" +
                "id=" + id +
                ", cid=" + cid +
                ", tid=" + tid +
                ", teachername='" + teachername + '\'' +
                ", Content='" + Content + '\'' +
                '}';
    }
}
