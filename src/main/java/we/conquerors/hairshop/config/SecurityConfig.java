package we.conquerors.hairshop.config;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.autoconfigure.security.servlet.PathRequest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.rememberme.JdbcTokenRepositoryImpl;
import org.springframework.security.web.authentication.rememberme.PersistentTokenRepository;

import javax.sql.DataSource;

@Configuration
@EnableWebSecurity // 내가 시큐리티 설정을 직접 하겠다.
@RequiredArgsConstructor
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    // WebSecurityConfigurerAdapter 상속받으면 손쉽게 시큐리티 필터 설정 가능

    // private final UserService userService;
    private final DataSource dataSource;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .mvcMatchers("/", "/login", "/sign-up", "/check-email-token", "/email-login", "/check-email-login", "/login-link").permitAll() // 여기 해당되는 것들은 무조건 허용, get, post등등
                .mvcMatchers(HttpMethod.GET, "/profile/*").permitAll() // get 요청만 허용
                .anyRequest().authenticated();  // 그 나머지는 로그인 해야만 쓸 수 있다.

        http.formLogin()
                .loginPage("/login")
                .permitAll();

        http.logout()
                .logoutSuccessUrl("/"); // 로그아웃 성공시 이동할 url

        // 가장 안전한 형태의 쿠키 사용법
//        http.rememberMe()
//                .userDetailsService(userService)
//                .tokenRepository(tokenRepository()); // db에서 토큰값을 읽어오거나 저장하는 인터페이스의 객체, 구현체를 주입해줘야 함.
    }

//    @Bean
//    public PersistentTokenRepository tokenRepository() {
//        JdbcTokenRepositoryImpl jdbcTokenRepository = new JdbcTokenRepositoryImpl();
//        jdbcTokenRepository.setDataSource(dataSource);
//        return jdbcTokenRepository;
//    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        // 정적 리소스에 대해 시큐리티 적용 안함.
        web.ignoring()
                .mvcMatchers("/node_modules/**")
                .requestMatchers(PathRequest.toStaticResources().atCommonLocations());
    }
}
