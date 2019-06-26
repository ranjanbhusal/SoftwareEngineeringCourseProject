package com.mumSched.model;
	
	import java.util.List;

	import javax.persistence.CascadeType;
	import javax.persistence.Entity;
	import javax.persistence.FetchType;
	import javax.persistence.GeneratedValue;
	import javax.persistence.GenerationType;
	import javax.persistence.Id;
	import javax.persistence.JoinTable;
	import javax.persistence.ManyToMany;

import org.springframework.hateoas.ResourceSupport;


	@Entity
	public class Entry{
		@Id
		@GeneratedValue(strategy=GenerationType.AUTO)
		private long id;
		
		private String entryMonth;
		private int entryYear;
		private int entryMonthValue;
		private int order_id;

		@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
		@JoinTable(name = "entry_blocks")
		private List<Block> blocks;
		
		public long getId() {
			return id;
		}

		public void setId(long id) {
			this.id = id;
		}

		public List<Block> getBlocks() {
			return blocks;
		}

		public void setBlocks(List<Block> blocks) {
			this.blocks = blocks;
		}
		
		public String getEntryMonth() {
			return entryMonth;
		}
		
		public void setEntryMonth(String entryMonth) {
			this.entryMonth = entryMonth;
		}
		
		public int getEntryMonthValue() {
			return entryMonthValue;
		}

		public void setEntryMonthValue(int entryMonthValue) {
			this.entryMonthValue = entryMonthValue;
		}

		public int getEntryYear() {
			return entryYear;
		}

		public void setEntryYear(int entryYear) {
			this.entryYear = entryYear;
		}

		public int getOrder() {
			return order_id;
		}

		public void setOrder(int order) {
			this.order_id = order;
		}

		@Override
		public String toString() {
			return "Entry [entryMonth=" + entryMonth + ", entryYear=" + entryYear + ", entryMonthValue="
					+ entryMonthValue + ", order_id=" + order_id + "]";
		}
		
		
	}



