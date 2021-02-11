package we.conquerors.hairshop.domain;

import lombok.Data;

@Data
public class UserDTO extends BaseDTO {
    private long userNo;
    private String userId;
    private String userName;
    private String userPwd;
    private String phone;
    private String rcvSmsYn;
    private String tel;
    private String email;
    private String rcvEmailYn;
    private String tmpPwdYn;
    private String withdrawYn;
    private String withdrawDtm;
}
