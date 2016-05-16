package com.angularstruts.document;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.apache.lucene.document.Field;
import org.lucene.exception.UnsupportedTypeValueException;
import org.lucene.field.FieldDefinition;
import org.lucene.indexer.Indexable;

public class Document implements Indexable{
	
	private static final Logger LOGGER = Logger.getLogger(Document.class);
	
	private Integer id ;
	private String title;
	private String path;


	public Document(Integer id, String title, String path) {
		this.id = id ;
		this.title = title ;
		this.path = path ;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
	
	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}
	
	@Override
	public List<FieldDefinition> getFields() {
		List<FieldDefinition> fields = new ArrayList<>();
		FieldDefinition def;
		try {
			def = new FieldDefinition("id", id,Field.Store.YES);
			fields.add(def);
		} catch (UnsupportedTypeValueException e) {
			LOGGER.error(e);
		}
		try {
			def = new FieldDefinition("title", title, Field.Store.YES);
			fields.add(def);
		} catch (UnsupportedTypeValueException e) {
			LOGGER.error(e);
		}
		try {
			def = new FieldDefinition("content", new File(path), Field.Store.YES);
			fields.add(def);
		} catch (UnsupportedTypeValueException e) {
			LOGGER.error(e);
		}
		return fields;
	}


}
