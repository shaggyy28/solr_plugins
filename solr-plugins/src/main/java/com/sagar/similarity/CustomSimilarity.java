package com.sagar.similarity;

import org.apache.lucene.search.similarities.TFIDFSimilarity;
import org.apache.lucene.util.BytesRef;

public class CustomSimilarity extends TFIDFSimilarity{

	@Override
	public float tf(float freq) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public float idf(long docFreq, long docCount) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public float lengthNorm(int length) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public float sloppyFreq(int distance) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public float scorePayload(int doc, int start, int end, BytesRef payload) {
		// TODO Auto-generated method stub
		return 0;
	}

}
