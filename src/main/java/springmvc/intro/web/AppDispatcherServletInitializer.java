package springmvc.intro.web;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;
import springmvc.intro.config.AppConfig;
import springmvc.intro.config.MvcConfig;

public class AppDispatcherServletInitializer
    extends AbstractAnnotationConfigDispatcherServletInitializer {

  @Override
  protected Class<?>[] getRootConfigClasses() {
    return new Class[]{AppConfig.class};
  }

  @Override
  protected Class<?>[] getServletConfigClasses() {
    return new Class[]{MvcConfig.class};
  }

  @Override
  protected String[] getServletMappings() {
    return new String[]{"/"};
  }
}
