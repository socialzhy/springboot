//package com.zhy.demo.config;
//
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.http.SessionCreationPolicy;
//import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
//import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
//import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;
//import org.springframework.security.oauth2.provider.token.RemoteTokenServices;
//import org.springframework.security.oauth2.provider.token.ResourceServerTokenServices;
//
//@Configuration
//@EnableResourceServer
//public class ResourceServerConfig extends ResourceServerConfigurerAdapter {
//    public static final String RESOURCE_ID = "user";
//
//    @Override public void configure(ResourceServerSecurityConfigurer resources) {
//        resources
//                .resourceId(RESOURCE_ID)    //资源id
//                .tokenServices(tokenService())  //验证令牌服务
//                .stateless(true);
//    }
//    @Override
//    public void configure(HttpSecurity http) throws Exception {
//        http
//                .authorizeRequests()
//                .antMatchers("/login*").permitAll()
//                .antMatchers("/**")
//                .access("#oauth2.hasScope('all')")  //校验令牌的scope
//                .and().csrf().disable() .sessionManagement()// 配置csrf
//                .sessionCreationPolicy(SessionCreationPolicy.STATELESS) //不使用session
//                .and()
//                .formLogin();
//    }
//
//    public ResourceServerTokenServices tokenService() {
//        //使用远程服务请求授权服务器校验token,必须指定校验token 的url、client_id，client_secret
//        RemoteTokenServices service=new RemoteTokenServices();
//        service.setCheckTokenEndpointUrl("http://localhost:8888/oauth/check_token");
//        service.setClientId("client"); service.setClientSecret("secret");
//        return service;
//    }
//}
