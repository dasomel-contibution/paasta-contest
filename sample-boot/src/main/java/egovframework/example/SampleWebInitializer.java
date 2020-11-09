//package egovframework.example;
//
//import javax.servlet.FilterRegistration;
//import javax.servlet.ServletContext;
//import javax.servlet.ServletException;
//
//import org.springframework.web.WebApplicationInitializer;
//import org.springframework.web.context.ContextLoaderListener;
//import org.springframework.web.context.support.XmlWebApplicationContext;
//import org.springframework.web.filter.CharacterEncodingFilter;
//
//import egovframework.rte.ptl.mvc.filter.HTMLTagFilter;
//
//public class SampleWebInitializer implements WebApplicationInitializer {
//
//	@Override
//	public void onStartup(ServletContext servletContext) throws ServletException {
////		XmlWebApplicationContext rootContext = XmlWebApplicationContext();
////		servletContext.addListener(new ContextLoaderListener(rootContext));
//
////		ServletRegistration.Dynamic dispatcher = servletContext.addServlet("dispatcher", new DispatcherServlet());
////		dispatcher.setLoadOnStartup(1);
////		dispatcher.setInitParameter("contextConfigLocation", "/WEB-INF/config/egovframework/springmvc/dispatcher-servlet.xml");
////		dispatcher.addMapping("*.do");
//
//		this.addIncodingFilter(servletContext);
//	}
//
////	private XmlWebApplicationContext xmlWebApplicationContext() {
////		XmlWebApplicationContext context = new XmlWebApplicationContext();
////		context.setConfigLocation("classpath://egovframework/spring/context-*.xml");
////		return context;
////	}
//
//	private void addIncodingFilter(ServletContext servletContext) {
//		FilterRegistration.Dynamic encodingFilter = servletContext.addFilter("encodingFilter", CharacterEncodingFilter.class);
//		encodingFilter.setInitParameter("encodig", "UTF-8");
//		encodingFilter.addMappingForUrlPatterns(null, false, "*.do");
//
//		FilterRegistration.Dynamic htmlTagFilter = servletContext.addFilter("HTML_TAG_FILTER", HTMLTagFilter.class);
//		htmlTagFilter.addMappingForUrlPatterns(null, false, "*.do");
//	}
//
//}
