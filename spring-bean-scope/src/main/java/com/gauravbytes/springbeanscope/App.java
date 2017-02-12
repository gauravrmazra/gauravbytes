package com.gauravbytes.springbeanscope;

import java.util.logging.Logger;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.gauravbytes.springbeanscope.config.ScopeConfig;

/**
 * 
 * @author Gaurav Rai Mazra <a href="http://www.gauravbytes.com">Catch me</a>
 */
public class App {
	private static final Logger logger = Logger.getLogger(App.class.getName());
	public static void main(String[] args) {
		try (ConfigurableApplicationContext context = new AnnotationConfigApplicationContext(ScopeConfig.class);) {
			Dictionary singletonDictionary = context.getBean("singletonDictionary", Dictionary.class);
			logger.info("Singleton Scope example starts");
			singletonDictionary.addWord("Give");
			singletonDictionary.addWord("Take");
			int totalWords = singletonDictionary.totalWords();
			logger.info("Need to have two words. Total words are : " + totalWords);
			logger.info(singletonDictionary.toString());
			singletonDictionary = context.getBean("singletonDictionary", Dictionary.class);
			logger.info("Need to have two words. Total words are : " + totalWords);
			logger.info(singletonDictionary.toString());
			logger.info("Singleton Scope example ends");
			
			Dictionary prototypeDictionary = context.getBean("prototypeDictionary", Dictionary.class);
			logger.info("Prototype scope example starts");
			prototypeDictionary.addWord("Give 2");
			prototypeDictionary.addWord("Take 2");
			logger.info("Need to have two words. Total words are: " + prototypeDictionary.totalWords());
			logger.info(prototypeDictionary.toString());
			prototypeDictionary = context.getBean("prototypeDictionary", Dictionary.class);
			logger.info("zero word count. Total words are: " + prototypeDictionary.totalWords());
			logger.info(prototypeDictionary.toString());
		}
	}
}
