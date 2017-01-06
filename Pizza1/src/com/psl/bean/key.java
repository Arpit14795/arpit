package com.psl.bean;

public enum key {
VegPizza(1), NonvegPizza(2);

int val;
key(int val){
this.val=val;	
}
public int getVal() {
	return val;
}
public void setVal(int val) {
	this.val = val;
}


}
