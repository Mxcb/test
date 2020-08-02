package com.vo;

public class ViewObject {
    private Integer sid;
    private String sname;
    private String semail;
    private Integer sage;

    private String cid;
    private String cname;

    public ViewObject(Integer sid, String sname, String semail, Integer sage, String cid, String cname) {
        this.sid = sid;
        this.sname = sname;
        this.semail = semail;
        this.sage = sage;
        this.cid = cid;
        this.cname = cname;
    }

    public ViewObject() {
    }

    @Override
    public String toString() {
        return "ViewObject{" +
                "sid=" + sid +
                ", sname='" + sname + '\'' +
                ", semail='" + semail + '\'' +
                ", sage=" + sage +
                ", cid='" + cid + '\'' +
                ", cname='" + cname + '\'' +
                '}';
    }

    public Integer getSid() {
        return sid;
    }

    public void setSid(Integer sid) {
        this.sid = sid;
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public String getSemail() {
        return semail;
    }

    public void setSemail(String semail) {
        this.semail = semail;
    }

    public Integer getSage() {
        return sage;
    }

    public void setSage(Integer sage) {
        this.sage = sage;
    }

    public String getCid() {
        return cid;
    }

    public void setCid(String cid) {
        this.cid = cid;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }
}
