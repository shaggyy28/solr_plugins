package com.sagar.tokenizer;

import org.apache.lucene.analysis.util.CharTokenizer;

public class DotTokenizer extends CharTokenizer{

	@Override
	protected boolean isTokenChar(int c) {
		return c != '.';
	}

}
