package com.jsfcourse.calc;
import javax.inject.Inject;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

@Named
@RequestScoped
//@SessionScoped
public class creditCalc {
	private Double x;
	private Integer y;
	private Integer z;
	private Double wynik;
	
	@Inject
	FacesContext ctx;

	public Double getX() {
		return x;
	}

	public void setX(Double x) {
		this.x = x;
	}

	public Integer getY() {
		return y;
	}

	public void setY(Integer y) {
		this.y = y;
	}

	public Integer getZ() {
		return z;
	}

	public void setZ(Integer z) {
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
			double x = this.x;
			Integer y = this.y;
			Integer z = this.z;
			wynik = (x*(z*0.01+1))/(y*12);

			ctx.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Operacja wykonana pomyślnie", null));
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