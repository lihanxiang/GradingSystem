package entity.result;

public class AssignmentScoreSet {
    private int aid;
    private String code;
    private String name;
    private Double score;

    public AssignmentScoreSet(int aid, String code, String name, Double score) {
        this.aid = aid;
        this.code = code;
        this.name = name;
        this.score = score;
    }

    public int getAid() {
        return aid;
    }

    public void setAid(int aid) {
        this.aid = aid;
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

    public Double getScore() {
        return score;
    }

    public void setScore(Double score) {
        this.score = score;
    }
}
