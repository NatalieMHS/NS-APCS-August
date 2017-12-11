package fracCalc;

public class Fraction {
	private int numer;
	private int denom;
	private int whole;
	private String sign;
	
	public Fraction(String expr) {
    	String[] splitExpr = expr.split(" ");
        String firstFrac = splitExpr[0];
        String operator = splitExpr[1];
        this.sign = operator;
        String secFrac = splitExpr[2];
        
        String[] splitFrac1 = parseFrac(firstFrac); 
        String[] splitFrac2 = parseFrac(secFrac);
        
		
	}
	
   	private String[] parseFrac(String fraction) {
    	String whole = "0";
    	String denom = "1";
    	String numer = "0";
    	if (fraction.contains("_")) {
    		String[] splitFrac = fraction.split("_");
    		whole = splitFrac[0];
    		fraction = splitFrac[1];
    	}
    	if (fraction.contains("/")) {
    		String[] splitFrac2 = fraction.split("/");
    		numer = splitFrac2[0];
    		denom = splitFrac2[1];
    	}
    	if (!(fraction.contains("_")) && !(fraction.contains("/"))) {
    		whole = fraction;
    	}
    	String[] parsedFrac = {whole, numer, denom};
    	return parsedFrac;
    	
    }
   	
   	public String toString(Fraction frac) {
   		return "whole: " + this.whole + " numer: " + this.numer + " denom: " + this.denom;
   	}
	
	
}
