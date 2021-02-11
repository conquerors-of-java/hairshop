package we.conquerors.hairshop.dao;

import org.apache.ibatis.annotations.Mapper;
import we.conquerors.hairshop.domain.UserDTO;

@Mapper
public interface UserDAO {
    Integer selectUser() throws Exception;

    void registerUser(UserDTO userDTO) throws Exception;
}
