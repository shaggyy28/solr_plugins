package com.sagar.tokenizer;

import java.util.Map;

import org.apache.lucene.analysis.Tokenizer;
import org.apache.lucene.analysis.util.TokenizerFactory;
import org.apache.lucene.util.AttributeFactory;

import com.sagar.tokenizer.DotTokenizer;

public class DotTokenizerFactory extends TokenizerFactory {

	public DotTokenizerFactory(Map<String, String> args) {
		super(args);
	}

	@Override
	public Tokenizer create(AttributeFactory factory) {

		return new DotTokenizer();
	}

}
