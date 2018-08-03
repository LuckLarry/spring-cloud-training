package springcloudgateway.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;

import javax.servlet.http.HttpServletRequest;

/**
 *
 * 定义拦截连接上的accesstoken，如果没有就拦截
 */

public class AccessFilter extends ZuulFilter {

    /**
     * 过滤器类型 决定过滤器的那个生命周期执行 这里使用pre
     * @return
     */
    @Override
    public String filterType() {
        return "pre";
    }

    /**
     * 如果有多个过滤器的时候，该方法决定优先使用那个过滤器
     * @return
     */
    @Override
    public int filterOrder() {
        return 0;
    }

    /**
     * 可以在这里决定哪些链接使用过滤器，判断该过滤器是否需要被执行
     * @return
     */
    @Override
    public boolean shouldFilter() {
        return false;
    }

    /**
     * 过滤器的具体逻辑 RequestContext.getCurrentContext(); 获取上下文
     * @return
     * @throws ZuulException
     */
    @Override
    public Object run() throws ZuulException {
        RequestContext ctx = RequestContext.getCurrentContext();
        HttpServletRequest request = ctx.getRequest();
        System.out.println("send {} request to {}"+ request.getMethod()+ request.getRequestURL().toString());
        Object accessToken = request.getParameter("accessToken");
        if(accessToken == null){
            ctx.setSendZuulResponse(false);
            ctx.setResponseStatusCode(401);
            return null;
        }
        return null;
    }
}
