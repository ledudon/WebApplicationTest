package calculation;
import java.io.Serializable;

public class PlusBean implements Serializable {
	private String expression = "";
	private String result = "";
	
	public void setExpression(String x, String y) {
		this.expression = x + " + " + y;
	}
	
	public String getExpression() {
		return expression;
	}
	
	public String getResult() {
		return result;
	}
	
    public void calc(){
    	// "+"は正規表現に使われる文字なので\\を付ける
    	String[] nums = expression.split(" \\+ ");
    	int sum = Integer.parseInt(nums[0]) + Integer.parseInt(nums[1]);
    	this.result = Integer.toString(sum);
	}
}