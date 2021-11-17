package com.jsfcourse.calc;
import javax.inject.Inject;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

@Named
@RequestScoped


public class creditCalc {
	private String x;
	private String y;
	private String z;
	private Double wynik;

	@Inject
	FacesContext ctx;

	public String getX() {
		return x;
	}

	public void setX(String x) {
		this.x = x;
	}

	public String getY() {
		return y;
	}

	public void setY(String y) {
		this.y = y;
	}

	public String getZ() {
		return z;
	}

	public void setZ(String z) {
		this.z = z;
	}

	public Double getWynik() {
		return wynik;
	}

	public void setWynik(Double wynik) {
		this.wynik = wynik;
	}

	public boolean doTheMath() {
		try {
			double x = Double.parseDouble(this.x);
			double y = Double.parseDouble(this.y);
			double z = Double.parseDouble(this.z);

			wynik = (x/(y*12))*(z/100+1);

			ctx.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Operacja wykonana poprawnie", null));
			return true;
		} catch (Exception e) {
			ctx.addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "Błędne parametry", null));
			return false;
		}
	}
	public String calc() {
		if (doTheMath()) {
			return "showresult";
		}
		return null;
	}

}