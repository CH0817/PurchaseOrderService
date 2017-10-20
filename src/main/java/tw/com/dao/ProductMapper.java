package tw.com.dao;

import org.apache.ibatis.annotations.Param;
import tw.com.base.mapper.BaseTableMapper;
import tw.com.dao.model.Product;

import java.util.List;

public interface ProductMapper extends BaseTableMapper<Product> {
    List<Product> findBySupplier(@Param("supplierIds") String[] supplierIds);
}