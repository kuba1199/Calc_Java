package calc;

import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import java.lang.Math;

@Named
@RequestScoped
//@SessionScoped
public class CredBB {
	private double cash;
	private int time;
	private double percent;
	private double result;

	@Inject
	FacesContext ctx;
	
	public double getCash() {
		return cash;
	}

	public void setCash(double cash) {
		this.cash = cash;
	}

	public int getTime() {
		return time;
	}

	public void setTime(int time) {
		this.time = time;
	}

	public double getPercent() {
		return percent;
	}

	public void setPercent(double percent) {
		this.percent = percent;
	}

	public Double getResult() {
		return result;
	}

	public void setResult(Double result) {
		this.result = result;
	}


	public void countRate() {

			double percent_count = percent / 100;
			double time_count = time * 12;
			System.out.print(percent_count);
			double q = 1 + (percent_count / 12);
			result = Math.round(cash * Math.pow(q, time_count) * (q - 1) / (Math.pow(q, time_count) - 1));
			
		}
	}



