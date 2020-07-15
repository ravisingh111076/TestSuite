package com.ide2e.example.practice;

class Person implements Comparable {

	@Override
	public String toString() {
		return "Person [age=" + age + ", name=" + name + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + age;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Person other = (Person) obj;
		if (age != other.age)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

	public Person(int age, String name) {
		this.age = age;
		this.name = name;
	}
	
	Integer age;
	String name;
	
	@Override
	public int compareTo(Object o) {
		if(o==null) {
			return -1;
		}
		if(!(o instanceof Person)) {
			return -1;
		} else {
			return (((Person)o).getAge() > this.getAge()) ? 1 : -1;
		}
	}

	public final Integer getAge() {
		return age;
	}

	public final String getName() {
		return name;
	}

	}
