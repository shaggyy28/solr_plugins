package com.sagar.lucene;

import static org.junit.Assert.assertEquals;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.document.Field;
import org.apache.lucene.document.TextField;
import org.apache.lucene.index.DirectoryReader;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.index.IndexWriterConfig;
import org.apache.lucene.queryparser.classic.ParseException;
import org.apache.lucene.queryparser.classic.QueryParser;
import org.apache.lucene.search.IndexSearcher;
import org.apache.lucene.search.Query;
import org.apache.lucene.search.ScoreDoc;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.FSDirectory;
import org.apache.lucene.util.IOUtils;


public class IndexLucene {
	
	public static void main(String[] args) throws IOException, ParseException {
		Analyzer analyzer = new StandardAnalyzer();

		//Storage
	    Path indexPath = Files.createTempDirectory("tempIndex");
	    Directory directory = FSDirectory.open(indexPath);
	    //writter
	    IndexWriterConfig config = new IndexWriterConfig(analyzer);
	    IndexWriter iwriter = new IndexWriter(directory, config);
	    //documents indexed
	    List<String> listString = new ArrayList<>();
	    listString.add("This is the text to be indexed.");
	    listString.add("Fox climbs the tree.");
	    for (String string : listString) {
	    	Document doc = new Document();
	    	doc.add(new Field("fieldname", string, TextField.TYPE_STORED));
		    iwriter.addDocument(doc);
		}
	    iwriter.close();
	    
	    //documents searched
	    // Now search the index:
	    DirectoryReader ireader = DirectoryReader.open(directory);
	    IndexSearcher isearcher = new IndexSearcher(ireader);
	    // Parse a simple query that searches for "text":
	    QueryParser parser = new QueryParser("fieldname", analyzer);
	    Query query = parser.parse("tree");
	    ScoreDoc[] hits = isearcher.search(query, 10).scoreDocs;
	    System.out.println(hits.length);
	    // Iterate through the results:
	    for (int i = 0; i < hits.length; i++) {
	      Document hitDoc = isearcher.doc(hits[i].doc);
	      System.out.println(hitDoc.get("fieldname"));
	    }
	    ireader.close();
	    directory.close();
//	    IOUtils.rm(indexPath);

	}

}
