package entity.result;

public class AnswerSet {
    private int anid;
    private int qid;
    private int uid;
    private String title;
    private String username;
    private String answer;
    private int tag;
    private double grade;

    public AnswerSet(int anid, int qid, int uid, String title, String username, String answer) {
        this.anid = anid;
        this.qid = qid;
        this.uid = uid;
        this.title = title;
        this.username = username;
        this.answer = answer;
    }

    public int getAnid() {
        return anid;
    }

    public void setAnid(int anid) {
        this.anid = anid;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }
}
