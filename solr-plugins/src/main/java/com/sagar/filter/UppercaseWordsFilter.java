package com.sagar.filter;

import org.apache.lucene.analysis.CharacterUtils;
import org.apache.lucene.analysis.TokenFilter;
import org.apache.lucene.analysis.TokenStream;
import org.apache.lucene.analysis.tokenattributes.CharTermAttribute;

import java.io.IOException;

public class UppercaseWordsFilter extends TokenFilter {
	
	protected UppercaseWordsFilter(TokenStream input) {
		super(input);
	}


	private final CharTermAttribute termAtt = addAttribute(CharTermAttribute.class);
	

	@Override
	public boolean incrementToken() throws IOException {
		if(input.incrementToken()) {
			char[] buffer = termAtt.buffer();
			CharacterUtils.toUpperCase(buffer, 0, buffer.length);
			return true;
		}
		return false;
	}
}
