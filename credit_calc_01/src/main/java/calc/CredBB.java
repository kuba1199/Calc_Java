package calc;

import javax.inject.Inject;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

@Named
@RequestScoped
//@SessionScoped
public class CredBB {
	private String cash;
	private String time;
	private String percent;
	private double result;

	@Inject
	FacesContext ctx;
	
	public String getCash() {
		return cash;
	}

	public void setCash(String cash) {
		this.cash = cash;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public String getPercent() {
		return percent;
	}

	public void setPercent(String percent) {
		this.percent = percent;
	}

	public Double getResult() {
		return result;
	}

	public void setResult(Double result) {
		this.result = result;
	}


	public void countRate() {
		if(cash == "" || time == "" || percent == "") {
			ctx.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Proszê wprowadziæ brakuj¹ce dane", null));
		}
		else {
			double cash = Double.parseDouble(this.cash);
			double time = Double.parseDouble(this.percent);
			double percent = Double.parseDouble(this.percent);
			
			double percent_count = percent / 100;
			double time_count = time * 12;
			System.out.print(percent_count);
			double q = 1 + (percent_count / 12);
			result = Math.round(cash * Math.pow(q, time_count) * (q - 1) / (Math.pow(q, time_count) - 1));
		}
	}


}
