package sample;

public abstract class Product implements Item{
  int id;
  String type;
  String manufacturer;
  String name;
  Product(String name, String manufacturer, String type) {
    this.name = name;
    this.manufacturer = manufacturer;
    this.type = type;
  }
  public int getID() {
    return id;
  }

  public String getType() {
    return type;
  }

  public void setID(int id) {
    this.id = id;
  }

  public void setType(String type) {
    this.type = type;
  }


  public String getManufacturer() {
    return manufacturer;
  }


  public void setManufacturer(String manufacturer) {
    this.manufacturer = manufacturer;
  }


  public String getName() {
    return name;
  }


  public void setName(String name) {
    this.name = name;
  }

  @Override
  public String toString() {
    return ("Name: " + name + " \nManufacturer: " + manufacturer + " \nType: " + type);
  }


}
