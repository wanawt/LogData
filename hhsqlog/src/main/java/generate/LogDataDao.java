package generate;

import generate.LogData;

public interface LogDataDao {
    int insert(LogData record);

    int insertSelective(LogData record);
}