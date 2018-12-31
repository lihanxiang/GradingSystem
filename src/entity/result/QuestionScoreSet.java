package entity.result;

public class QuestionScoreSet {
    private int qid;
    private String title;
    private Double weight;
    private Double score;

    public QuestionScoreSet(int qid, String title, Double weight, Double score) {
        this.qid = qid;
        this.title = title;
        this.weight = weight;
        this.score = score;
    }

    public int getQid() {
        return qid;
    }

    public void setQid(int qid) {
        this.qid = qid;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Double getWeight() {
        return weight;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }

    public Double getScore() {
        return score;
    }

    public void setScore(Double score) {
        this.score = score;
    }
}
