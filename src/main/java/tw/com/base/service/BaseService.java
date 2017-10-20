package tw.com.base.service;

import java.util.List;
import java.util.Map;

/**
 * Service interface
 *
 * @author Rex
 */
public interface BaseService<T> {
    /**
     * 新增
     *
     * @param entity 新增物件
     * @return id
     */
    String insert(T entity);

    /**
     * 刪除
     *
     * @param id 物件ID
     * @return result
     */
    boolean delete(String id);

    /**
     * 更新
     *
     * @param entity 更新物件
     * @return result
     */
    boolean update(T entity);

    /**
     * 依ID搜尋
     *
     * @param id 物件ID
     * @return JSON
     */
    T findById(String id, String userId);

    /**
     * 依ID搜尋
     *
     * @param ids 物件ID
     * @return JSON
     */
    List<T> findByIds(String[] ids, String userId);

    /**
     * 查詢全部
     *
     * @return JSON
     */
    List<T> findAll(String userId);

    /**
     * 依條件查詢
     *
     * @param condition 條件
     * @return JSON
     */
    List<T> findByCondition(Map<String, Object> condition);

}
