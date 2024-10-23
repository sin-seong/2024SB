package com.sin.sb1010.config;

import com.sin.sb1010.spring.MemberDao;
import com.sin.sb1010.spring.MemberPrinter;
import com.sin.sb1010.spring.MemberSummaryPrinter;
import com.sin.sb1010.spring.VersionPrinter;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;


@Configuration
@ComponentScan(basePackages = {"com.sin.sb1010.spring","com.sin.sb1010.spring2"},
excludeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION,
classes = {NoProduct.class, ManualBean.class}))
//public class AppCtxWithExclude{
//	@Bean
//	public MemberDao memberDao(){
//		return new MemberDao();
//	}
//}
public class AppCtx {

	@Bean
	@Qualifier("printer")
	public MemberPrinter memberPrinter1() {
		return new MemberPrinter();
	}
	
	@Bean
	@Qualifier("summaryPrinter")
	public MemberSummaryPrinter memberPrinter2() {
		return new MemberSummaryPrinter();
	}
	
	@Bean
	public VersionPrinter versionPrinter() {
		VersionPrinter versionPrinter = new VersionPrinter();
		versionPrinter.setMajorVersion(5);
		versionPrinter.setMinorVersion(0);
		return versionPrinter;
	}
}
