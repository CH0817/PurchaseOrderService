package tw.com.base.mapper;

/**
 * @author Rex
 */
public interface BaseMappingTableMapper<T> {
    int insert(T record);

    int update(T record);
}
