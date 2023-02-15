package JP;


public class CarDTO {
	   private int No;
	   private String Brand;
	   private String Model;
	   private String Price;
	   private String Type;
	   private String Bcapacity;
	   private String Power;
	   private String Mileage;
	   private String Maxdistance;
	   

CarDTO(int No,String Brand,String Model,String Price,String Type,String Bcapacity,String Power,String Mileage,String Maxdistance){this.No=No;this.Brand=Brand;this.Model=Model;this.Price=Price;this.Type=Type;this.Bcapacity=Bcapacity;this.Power=Power;this.Mileage=Mileage;this.Maxdistance=Maxdistance;}

public int getNo(){return No;}

public void setNo(int no){No=no;}

public String getBrand(){return Brand;}

public void setBrand(String brand){Brand=brand;}

public String getModel(){return Model;}

public void setModel(String model){Model=model;}

public String getPrice(){return Price;}

public void setPrice(String price){Price=price;}

public String getType(){return Type;}

public void setType(String type){Type=type;}

public String getBcapacity(){return Bcapacity;}

public void setBcapacity(String bcapacity){Bcapacity=bcapacity;}

public String getPower(){return Power;}

public void setPower(String power){Power=power;}

public String getMileage(){return Mileage;}

public void setMileage(String mileage){Mileage=mileage;}

public String getMaxdistance(){return Maxdistance;}

public void setMaxdistance(String maxdistance){Maxdistance=maxdistance;}

}