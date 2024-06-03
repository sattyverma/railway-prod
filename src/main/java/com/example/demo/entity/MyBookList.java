package com.example.demo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="MyBooks")
public class MyBookList {
	
	@Id
	private int id;
	private String name;
	private String author;
	private String Rating;
	private String link;
	
	
	
}
