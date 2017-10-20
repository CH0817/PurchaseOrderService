package tw.com.base.mapper;

import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * @author Rex
 */
public interface BaseTableMapper<T> {

    int insert(T record);

    int delete(String id);

    int update(T record);

    T findById(@Param("id") String id, @Param("userId") String userId);

    List<T> findByIds(@Param("ids") String[] ids, @Param("userId") String userId);

    List<T> findAll(String userId);

    List<T> findByCondition(Map<String, Object> condition);

}
