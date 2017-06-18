package spring.min.project.language;

import java.util.Locale;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.i18n.CookieLocaleResolver;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;

@Configuration
@EnableWebMvc
public class MvcConfiguration extends WebMvcConfigurerAdapter{
	
	//1
		@Bean
		public LocaleResolver localResolver(){
			CookieLocaleResolver resolver=new CookieLocaleResolver();
			resolver.setDefaultLocale(new Locale("kh"));
			resolver.setCookieName("Spring_Local");
			resolver.setCookieMaxAge(4800);
			return resolver;
		}
		
	//2
		@Bean
		public LocaleChangeInterceptor localChangeInterceptor(){
			LocaleChangeInterceptor lci=new LocaleChangeInterceptor();
				lci.setParamName("lang");
			return lci;
		}

	//3
		@Override
		public void addInterceptors(InterceptorRegistry registry) {
			registry.addInterceptor(localChangeInterceptor());
		}	
	//4
			@Bean
		public MessageSource messageSource(){
			ReloadableResourceBundleMessageSource messageSource=new ReloadableResourceBundleMessageSource();
			messageSource.setBasename("classpath:/i18n/messages/message");
			messageSource.setCacheSeconds(0);
			messageSource.setUseCodeAsDefaultMessage(true);
			messageSource.setDefaultEncoding("UTF-8");
			return messageSource;
			
		}
}
