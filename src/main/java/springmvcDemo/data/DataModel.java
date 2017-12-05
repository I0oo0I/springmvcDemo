package springmvcDemo.data;

import org.apache.commons.lang.builder.EqualsBuilder;

public class DataModel {

	private String id;
	
	private String name;
	
	private String age;
	
	private String money;
	
	private String date;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public DataModel(String id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	public DataModel() {
		super();
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public String getMoney() {
		return money;
	}

	public void setMoney(String money) {
		this.money = money;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}
	
	
	@Override
	public boolean equals(Object obj) {
		return EqualsBuilder.reflectionEquals(this, obj, new String[] {"age", "money"});
	}
	
}
