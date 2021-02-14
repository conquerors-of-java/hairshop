package we.conquerors.hairshop.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class AppConfig {

    @Bean
    public PasswordEncoder passwordEncoder(){
        // bcrypt 알고리즘 사용해서 비밀번호 해슁
        return PasswordEncoderFactories.createDelegatingPasswordEncoder();
    }
}
