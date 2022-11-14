package org.healthplus.user.infrastructure.security.jwt.util;

public class Person {

  private String name;
  private int age;

  public Person() {
  }

  public Person(String name, int age) {
    this.name = name;
    this.age = age;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public int getAge() {
    return age;
  }

  public void setAge(int age) {
    this.age = age;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof Person)) {
      return false;
    }

    Person person = (Person) o;

    if (getAge() != person.getAge()) {
      return false;
    }
    return getName() != null ? getName().equals(person.getName()) : person.getName() == null;
  }

  @Override
  public int hashCode() {
    int result = getName() != null ? getName().hashCode() : 0;
    result = 31 * result + getAge();
    return result;
  }
}
