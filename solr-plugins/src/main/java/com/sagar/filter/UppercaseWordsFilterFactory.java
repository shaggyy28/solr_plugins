	package com.sagar.filter;

import java.util.Map;

import org.apache.lucene.analysis.TokenStream;
import org.apache.lucene.analysis.util.TokenFilterFactory;

public class UppercaseWordsFilterFactory extends TokenFilterFactory{

	public UppercaseWordsFilterFactory(Map<String, String> args) {
		super(args);
	}

	@Override
	public TokenStream create(TokenStream input) {
		return new UppercaseWordsFilter(input);
	}

}
