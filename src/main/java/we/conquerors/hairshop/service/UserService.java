package we.conquerors.hairshop.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import we.conquerors.hairshop.dao.UserDAO;
import we.conquerors.hairshop.domain.UserDTO;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserDAO userDAO;

    public Integer selectUser() throws Exception{
        return userDAO.selectUser();
    }

    @Transactional
    public void registerUser() {
        try {
            UserDTO userDTO = new UserDTO();
            userDTO.setUserId("jwkoo");
            userDTO.setUserName("jw");
            userDTO.setUserPwd("123123");
            userDTO.setPhone("00000000");
            userDTO.setRegUserId("system");
            userDTO.setRegDtm(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMddHHmmss")));
            userDAO.registerUser(userDTO);

//            UserDTO userDTO2 = new UserDTO();
//            userDTO2.setUserId("jwkoo2");
//            userDTO2.setUserName("jw2");
//            userDTO2.setUserPwd("1231232");
//            userDTO2.setPhone("00000000222222333333333");
//            userDTO2.setRegUserId("system");
//            userDTO2.setRegDtm(LocalDateTime.now().toString());

//            userDAO.registerUser(userDTO2);
        } catch (Exception e) {
            System.err.println(e.getMessage());
            throw new RuntimeException("insert fail"); // 스프링에 예외를 던져준다.
        }
    }
}
