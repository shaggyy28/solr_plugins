package com.sagar.analyzer;

import java.io.Reader;

import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.core.UpperCaseFilter;

import com.sagar.tokenizer.DotTokenizer;

public class UpperDotAnalyzer extends Analyzer {

	@SuppressWarnings("resource")
	@Override
	public TokenStreamComponents createComponents(String fieldName) {
		DotTokenizer dt = new DotTokenizer();
		UpperCaseFilter upperCaseFilter = new UpperCaseFilter(dt);
		return new TokenStreamComponents(dt, upperCaseFilter) {
			@Override
		      protected void setReader(final Reader reader) {
		        // So that if maxTokenLength was changed, the change takes
		        // effect next time tokenStream is called:
		        super.setReader(reader);
		      }
		};
	}

}
