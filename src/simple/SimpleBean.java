package simple;


import java.io.Serializable;

public class SimpleBean implements Serializable {
	private String name = "";
	private String message = "";

	public void setName(String name){
		this.name = name;
	}
    public String getName(){
		return name;
	}
    public String getMessage(){
		return message;
	}
    public void calc(){
		int i = name.length();
		this.message = "あなたの名前は、"+i+"文字です。";
	}
}