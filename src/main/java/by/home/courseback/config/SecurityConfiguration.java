package by.home.courseback.config;

import by.home.courseback.security.AuthoritiesConstants;
import by.home.courseback.security.jwt.JWTConfigurer;
import by.home.courseback.security.jwt.TokenProvider;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@EnableWebSecurity
@Configuration
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    private final TokenProvider tokenProvider;

    public SecurityConfiguration(TokenProvider tokenProvider) {
        this.tokenProvider = tokenProvider;
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    public void configure(WebSecurity web) {
        web.ignoring()
                .antMatchers(HttpMethod.OPTIONS, "/**")
                .antMatchers("/app/**/*.{js,html}")
                .antMatchers("/i18n/**")
                .antMatchers("/content/**")
                .antMatchers("/swagger-ui/index.html")
                .antMatchers("/test/**")
                .antMatchers("/comment");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf()
                .disable()
                .httpBasic()
                .and()
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .headers()
                .frameOptions().sameOrigin()
                .and()
                .authorizeRequests()
                .antMatchers("/api/authenticate").permitAll()
                .antMatchers("/api/register").permitAll()
                .antMatchers("/api/activate").permitAll()
                .antMatchers("/api/composition").permitAll()
                .antMatchers("/api/composition/**").permitAll()
                .antMatchers("/api/chapter").permitAll()
                .antMatchers("/api/chapter/**").permitAll()
                .antMatchers("/api/genre").permitAll()
                .antMatchers("/api/tag").permitAll()
                .antMatchers("/api/rating/**").permitAll()
                .antMatchers("/gs-guide-websocket/**").permitAll()
                .antMatchers("/api/users/user/**").authenticated()
                .antMatchers("/api/users/**").hasAuthority(AuthoritiesConstants.ADMIN)
                .antMatchers("/**").authenticated()
                .and()
                .apply(new JWTConfigurer(tokenProvider));
    }
}
