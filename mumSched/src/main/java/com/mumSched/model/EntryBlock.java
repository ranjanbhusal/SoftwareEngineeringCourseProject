package com.mumSched.model;

public class EntryBlock {
	
	private Entry entry;
	
	private Block block1;
	private Block block2;
	private Block block3;
	private Block block4;
	public Entry getEntry() {
		return entry;
	}
	public void setEntry(Entry entry) {
		this.entry = entry;
	}
	public Block getBlock1() {
		return block1;
	}
	public void setBlock1(Block block1) {
		this.block1 = block1;
	}
	public Block getBlock2() {
		return block2;
	}
	public void setBlock2(Block block2) {
		this.block2 = block2;
	}
	public Block getBlock3() {
		return block3;
	}
	public void setBlock3(Block block3) {
		this.block3 = block3;
	}
	public Block getBlock4() {
		return block4;
	}
	public void setBlock4(Block block4) {
		this.block4 = block4;
	}
	@Override
	public String toString() {
		return "EntryBlock [entry=" + entry + ", block1=" + block1 + ", block2=" + block2 + ", block3=" + block3
				+ ", block4=" + block4 + "]";
	}
	
	
	

}
