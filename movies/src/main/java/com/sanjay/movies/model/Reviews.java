package com.sanjay.movies.model;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "reviews")
public class Reviews {
	@Id
	private ObjectId id;
	private String body;
	public Reviews() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Reviews(ObjectId id, String body) {
		super();
		this.id = id;
		this.body = body;
	}
	public Reviews(String body) {
		super();
		this.body = body;
	}
	public ObjectId getId() {
		return id;
	}
	public void setId(ObjectId id) {
		this.id = id;
	}
	public String getBody() {
		return body;
	}
	public void setBody(String body) {
		this.body = body;
	}

}
