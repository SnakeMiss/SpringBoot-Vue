package priv.lsx.mapper;

import org.springframework.stereotype.Repository;
import priv.lsx.entity.Persons;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

/**
 * <p>
 * Mapper 接口
 * </p>
 *
 * @author lsx
 * @since 2021-03-06
 */
@Repository
public interface PersonMapper extends BaseMapper<Persons> {
}
