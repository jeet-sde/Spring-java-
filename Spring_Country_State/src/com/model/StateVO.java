package com.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


	
	@Entity
	@Table(name="State")
	public class StateVO {
		@Id
		@Column(name="Id")
		@GeneratedValue(strategy=GenerationType.AUTO)
		private int id;
		
		@Column(name="statename")
		private String statename;
		
		@ManyToOne
		private CountryVO countryVO;

		public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}

		public String getStatename() {
			return statename;
		}

		public void setStatename(String statename) {
			this.statename = statename;
		}

		public CountryVO getCountryVO() {
			return countryVO;
		}

		public void setCountryVO(CountryVO countryVO) {
			this.countryVO = countryVO;
		}

	}
