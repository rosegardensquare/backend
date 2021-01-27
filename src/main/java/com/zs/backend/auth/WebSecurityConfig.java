package com.zs.backend.auth;

import com.zs.backend.security.handler.AuthenticationFailureHandlerImpl;
import com.zs.backend.security.handler.AuthenticationSuccessHandlerImpl;
import com.zs.backend.sys.auth.UserDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import org.springframework.context.annotation.Bean;

import org.springframework.security.web.authentication.logout.HttpStatusReturningLogoutSuccessHandler;


@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    //自定义的认证逻辑
    @Autowired
    private UserDetailsServiceImpl userDetailsService;

    //修改密码的加密方式
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        //替换默认的登录认证
        auth.userDetailsService(userDetailsService)
                //替换默认的密码认证方式
                .passwordEncoder(passwordEncoder);
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        super.configure(web);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        //post 请求可以通过
        http.csrf().disable()
                .authorizeRequests()
                // 开放的 URL
                .antMatchers("/login").permitAll()
                // 开放所有接口
                //.antMatchers("/*/**").permitAll()
                // 其他所有请求需要身份认证
                .anyRequest().authenticated()
                //这里配置的loginProcessingUrl为页面中对应表单的 action ，该请求为 post，并设置可匿名访问
                .and().formLogin().loginProcessingUrl("/login").permitAll()
                //这里指定的是表单中name="username"的参数作为登录用户名，name="password"的参数作为登录密码
                .usernameParameter("name").passwordParameter("password")
                //登录成功后的返回结果
                .successHandler(new AuthenticationSuccessHandlerImpl())
                .failureHandler(new AuthenticationFailureHandlerImpl("name"))
        ;
        // 退出登录处理器
        http.logout().logoutSuccessHandler(new HttpStatusReturningLogoutSuccessHandler());

    }

}