package mapper;

import entity.Summary;
import org.apache.ibatis.annotations.Param;

public interface SummaryMapper {

    int writeSummary(Summary summary);
    Summary getSummaryOfStudent(@Param("aid") int aid, @Param("uid") int uid);
    Double getScoreOfAnswer(@Param("qid") int qid, @Param("uid") int uid);
    Double getScoreOfAssignment(@Param("aid") int aid, @Param("uid") int uid);
    Double getTotalScoreOfCourse(@Param("code") String code, @Param("uid") int uid);
}
