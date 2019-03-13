package com.demo.quote.auth.sercurity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.access.intercept.FilterSecurityInterceptor;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    private MyFilterSecurityInterceptor myFilterSecurityInterceptor;

    @Autowired
    private MyAuthenticationSuccessHandler  myAuthenticationSuccessHandler;

    @Autowired
    private MyLogoutSuccessHandler myLogoutSuccessHandler;

    @Bean
    UserDetailsService myUserDetailsService(){
        return new MyUserDetailsService();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .anyRequest().authenticated() //任何请求,登录后可以访问
//                .and()
//                .formLogin() // 定义当需要用户登录时候，转到的登录页面。
//                .loginPage("/login")// 设置登录页面
//                .loginProcessingUrl("/j_spring_security_check") // 自定义的登录接口
//                .successHandler(myAuthenticationSuccessHandler)
//                .failureUrl("/login?error")
//                .permitAll() //登录页面用户任意访问
                .and()
                .headers().frameOptions().disable()
                .and()
                .logout().permitAll()
                .logoutUrl("/quote/logout")
                .logoutSuccessHandler(myLogoutSuccessHandler);
//                .logoutSuccessUrl("/login")
//                .and()
//                .sessionManagement().invalidSessionUrl("/login"); //注销行为任意访问

        http.addFilterBefore(myFilterSecurityInterceptor, FilterSecurityInterceptor.class).csrf().disable();// 关闭csrf防护
        http.addFilter(new JWTLoginFilter(authenticationManager()));
        http.addFilter(new JWTAuthenticationFilter(authenticationManager()));

    }

    @Override
    public void configure(WebSecurity web) throws Exception {
//        web.ignoring().antMatchers("/js/**", "/css/**", "/images/**", "/**/favicon.ico");
        web.ignoring().antMatchers("/**/*.js", "/lang/*.json", "/**/*.css", "/**/*.js", "/**/*.map", "/**/*.html", "/**/*.png");
        //防止拦截css,js，image文件
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(myUserDetailsService());
        //登录验证，绑定自定义的UserDetailServiceHolder
    }

}
