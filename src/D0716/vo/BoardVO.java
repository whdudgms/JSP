package D0716.vo;


import java.sql.Date;

/**
 * NO      NOT NULL NUMBER
 * TITLE            VARCHAR2(50)
 * WRITER           VARCHAR2(20)
 * PWD              VARCHAR2(20)
 * CONTENT          VARCHAR2(50)
 * REGATE           DATE
 * HIT              NUMBER
 */
public class BoardVO {
    private int no;
    private String title;
    private String writer;
    private String pwd;
    private String content;
    private Date regdate;
    private int hit;
    private String fname;
    private int fsize;

    public BoardVO(int no, String title, String writer, String pwd, String content, Date regdate, int hit, String fname, int fsize) {
        this.no = no;
        this.title = title;
        this.writer = writer;
        this.pwd = pwd;
        this.content = content;
        this.regdate = regdate;
        this.hit = hit;
        this.fname = fname;
        this.fsize = fsize;
    }

    public BoardVO() {
    }

    public BoardVO(int no, String title, String writer, String pwd, String content, Date regdate, int hit, String fname) {
        this.no = no;
        this.title = title;
        this.writer = writer;
        this.pwd = pwd;
        this.content = content;
        this.regdate = regdate;
        this.hit = hit;
        this.fname = fname;
    }

    @Override
    public String toString() {
        return "BoardVO{" +
                "no=" + no +
                ", title='" + title + '\'' +
                ", writer='" + writer + '\'' +
                ", pwd='" + pwd + '\'' +
                ", content='" + content + '\'' +
                ", regdate=" + regdate +
                ", hit=" + hit +
                ", fname='" + fname + '\'' +
                ", fsize=" + fsize +
                '}';
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getWriter() {
        return writer;
    }

    public void setWriter(String writer) {
        this.writer = writer;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getRegdate() {
        return regdate;
    }

    public void setRegdate(Date regdate) {
        this.regdate = regdate;
    }

    public int getHit() {
        return hit;
    }

    public void setHit(int hit) {
        this.hit = hit;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public int getFsize() {
        return fsize;
    }

    public void setFsize(int fsize) {
        this.fsize = fsize;
    }
}
