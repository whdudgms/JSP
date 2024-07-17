package D0716.vo;

public class MemberVO {
    private String id;
    private String name;
    private String pw;


    @Override
    public String toString() {
        return "MemberVO{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", pw='" + pw + '\'' +
                '}';
    }

    public MemberVO() {
    }

    public MemberVO(String id, String name, String pw) {
        this.id = id;
        this.name = name;
        this.pw = pw;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPw() {
        return pw;
    }

    public void setPw(String pw) {
        this.pw = pw;
    }
}
