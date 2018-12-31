package util;

import entity.result.CourseScoreSet;
import org.springframework.stereotype.Component;

import java.text.DecimalFormat;
import java.util.List;

@Component
public class GPACalculator {

    public String convertScoreToGrade(Double score){
        if (score >= 94.0){
            return "A+";
        } else if (score >= 88.0){
            return "A";
        } else if (score >= 82.0){
            return "A-";
        } else if (score >= 78.0){
            return "B+";
        }  else if (score >= 74.0){
            return "B";
        } else if (score >= 70.0){
            return "B-";
        } else if (score >= 67.0){
            return "C+";
        } else if (score >= 63.0){
            return "C";
        } else if (score >= 60.0){
            return "C-";
        } else if (score >= 56.0){
            return "D+";
        }else if (score >= 50.0){
            return "D";
        } else if (score >= 0){
            return "F";
        } else {
            return "N";
        }
    }

    private Double convertGradeToPoint(String grade){
        try {
            switch (grade) {
                case "A+":
                case "A":
                    return 4.0;
                case "A-":
                    return 3.7;
                case "B+":
                    return 3.3;
                case "B":
                    return 3.0;
                case "B-":
                    return 2.7;
                case "C+":
                    return 2.4;
                case "C":
                    return 2.0;
                case "C-":
                    return 1.7;
                case "D+":
                    return 1.3;
                case "D":
                    return 1.0;
                case "N":
                    return -1.0;
            }
        } catch (NullPointerException e){
            e.printStackTrace();
            return null;
        }
        return null;
    }

    public String calculateGPA(List<CourseScoreSet> sets){
        double sumCredit = 0.0, sumPoints = 0.0;
        DecimalFormat format = new DecimalFormat("0.00");
        for (CourseScoreSet c:
                sets) {
            if (c.getGrade() != null || convertGradeToPoint(c.getGrade()) != null){
                sumCredit += c.getCredit();
                sumPoints += convertGradeToPoint(c.getGrade()) * c.getCredit();
            }

        }
        return format.format(sumPoints / sumCredit);
    }
}
