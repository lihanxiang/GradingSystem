package entity.result;

public class CourseScoreSet {
    private String code;
    private String name;
    private int credit;
    private String grade;

    public CourseScoreSet(String code, String name, int credit, String grade) {
        this.code = code;
        this.name = name;
        this.credit = credit;
        this.grade = grade;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCredit() {
        return credit;
    }

    public void setCredit(int credit) {
        this.credit = credit;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }
}
