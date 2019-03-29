package filters;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import others.Attributes;
import others.Links;
import others.User;

@WebFilter({ Links.changePremium,  Links.userlist, Links.userlist + ".jsp" })
public class AdminFilter implements Filter {

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest httpRequest = (HttpServletRequest) request;
		HttpServletResponse httpResponse = (HttpServletResponse) response;
		HttpSession session = httpRequest.getSession();
		if (session.getAttribute(Attributes.currentUser) == null) {
			httpResponse.sendRedirect("/");
			return;
		}
		User user = (User) session.getAttribute(Attributes.currentUser);
		if (!user.isAdmin()) {
			httpResponse.sendRedirect(Links.profile);
			return;
		}

		chain.doFilter(request, response);
	}

	@Override
	public void destroy() {
	}

}
