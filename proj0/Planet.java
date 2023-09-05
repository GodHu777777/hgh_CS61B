public class Planet {
	public double xxPos;
	public double yyPos;
	public double xxVel;
	public double yyVel;
	public double mass;
	public String imgFileName;
	static final double ConstG = 6.67e-11;
	public Planet(double xP, double yP, double xV,double yV, double m, String img) {
		xxPos = xP;
		yyPos = yP;
		xxVel = xV;
		yyVel = yV;
		mass = m;
		imgFileName = img;
	}
	public Planet(Planet p) {
		this.xxPos = p.xxPos;
		this.yyPos = p.yyPos;
		this.xxVel = p.xxVel;
		this.yyVel = p.yyVel;
		this.mass = p.mass;
		this.imgFileName = p.imgFileName;
	}
	public double calcDistance(Planet p) {
		double dx = this.xxPos - p.xxPos;
		double dy = this.yyPos - p.yyPos;
		return Math.sqrt(dx * dx + dy * dy);
	}
	public double calcForceExertedBy(Planet p) {
		return ConstG * this.mass * p.mass / (this.calcDistance(p) * this.calcDistance(p) );
	}
	public double calcForceExertedByX(Planet p) {
		double dx = p.xxPos - this.xxPos;
		return this.calcForceExertedBy(p) * ( dx / this.calcDistance(p) );
	}
	public double calcForceExertedByY(Planet p) {
		double dy = p.yyPos - this.yyPos;
		return this.calcForceExertedBy(p) * ( dy / this.calcDistance(p) );
	}
	public double calcNetForceExertedByX(Planet[] p) {
		double res = 0;
		for(Planet t : p) {
			res += this.calcForceExertedByX(t);
		}
		return res;
	}
	public double calcNetForceExertedByY(Planet[] p) {
		double res = 0;
		for(Planet t : p) {
			res += this.calcForceExertedByY(t);
		}
		return res;
	}
	public Planet update(double dt,double Fx,double Fy) {
		double ax = Fx / this.mass;
		double ay = Fy / this.mass;
		this.xxVel += ax * dt;
		this.yyVel += ay * dt;
		this.xxPos += this.xxVel * dt;
		this.yyPos += this.yyVel * dt;
		return this;
	}
}