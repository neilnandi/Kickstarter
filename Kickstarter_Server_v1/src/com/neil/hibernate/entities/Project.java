package com.neil.hibernate.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="kickstarter_data")
public class Project {

	@Id
	@Column(name="s.no")
	@GeneratedValue
	int sno;


	@Column(name="amt.pledged")
	int amtPledged;
	
	@Column(name="blurb")
	String blurb;
	
	@Column(name="by")
	String by;
	
	@Column(name="country")
	String country;
	
	@Column(name="currency")
	String currency;
	
	@Column(name="endtime")
	String endTime;
	
	@Column(name="location")
	String location;
	
	@Column(name="percentage.funded")
	int percentageFunded;
	
	@Column(name="num.backers")
	int numBackers;
	
	@Column(name="state")
	String state;
	
	@Column(name="title")
	String title;
	
	@Column(name="type")
	String type;
	
	@Column(name="url")
	String url;
	
	
	
	
	
	
	
	
}
