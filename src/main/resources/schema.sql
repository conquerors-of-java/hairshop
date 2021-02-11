CREATE TABLE `tb_user` (
    `user_no` int(11) NOT NULL AUTO_INCREMENT COMMENT '사용자NO',
    `user_id` varchar(50) NOT NULL COMMENT '사용자ID',
    `user_name` varchar(50) NOT NULL COMMENT '사용자이름',
    `user_pwd` varchar(255) NOT NULL COMMENT '사용자비밀번호',
    `phone` varchar(15) NOT NULL COMMENT '휴대폰',
    `rcv_sms_yn` char(1) DEFAULT 'N' COMMENT 'SMS수신여부',
    `tel` varchar(15) DEFAULT NULL COMMENT '전화번호',
    `email` varchar(255) DEFAULT NULL COMMENT '이메일',
    `rcv_email_yn` char(1) DEFAULT 'N' COMMENT '이메일수신여부',
    `tmp_pwd_yn` char(1) DEFAULT 'N' COMMENT '임시비밀번호여부',
    `withdraw_yn` char(1) DEFAULT 'N' COMMENT '탈퇴여부',
    `withdraw_dtm` varchar(14) DEFAULT NULL COMMENT '탈퇴일시',
    `reg_dtm` varchar(14) NOT NULL COMMENT '등록일시',
    `reg_user_id` varchar(50) NOT NULL COMMENT '등록자ID',
    `upd_dtm` varchar(50) DEFAULT NULL COMMENT '수정일시',
    `upd_user_id` varchar(50) DEFAULT NULL COMMENT '수정자ID',
    PRIMARY KEY (`user_no`)
);
-- ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
