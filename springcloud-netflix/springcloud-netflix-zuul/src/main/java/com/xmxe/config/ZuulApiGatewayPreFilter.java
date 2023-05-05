package com.xmxe.config;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

/**
 * 实现一个前置过滤器：拦截请求，必须带参数name过来，不然抛出提示信息等等
 */
@Component
@Slf4j
public class ZuulApiGatewayPreFilter extends ZuulFilter {

    @Override
    public String filterType() {
        return "pre";//pre:路由之前 routing:路由之时 post:路由之后 error:发送错误调用
    }

    @Override
    public int filterOrder() {//过滤的顺序 数字越大，优先级越低
        return 0;
    }

    @Override
    public boolean shouldFilter() {//这里可以写逻辑判断，是否执行该过滤器，此处为true，说明需要过滤
        return true;
    }

    @Override
    public Object run() {//过滤器的具体逻辑。可用很复杂，包括查sql，nosql去判断该请求到底有没有权限访问
        RequestContext ctx = RequestContext.getCurrentContext();
        HttpServletRequest request = ctx.getRequest();
        log.info(String.format("method->%s,url->%s", request.getMethod(), request.getRequestURL().toString()));
        Object accessToken = request.getParameter("name");
        if(accessToken == null) {
            log.warn("token is empty");
            ctx.setSendZuulResponse(false);//不对该请求进行路由 true为对该请求进行路由
            ctx.setResponseStatusCode(401);
            try {
                //ctx.setResponseBody("{\"result\":\"username is not correct!\"}");// 返回错误内容
                ctx.getResponse().getWriter().write("token is empty");
            }catch (Exception e){}

            return null;
        }
        log.info("ok");
        return null;
    }
}
