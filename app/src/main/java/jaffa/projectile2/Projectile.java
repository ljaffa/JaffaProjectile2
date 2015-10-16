package jaffa.projectile2;

public class Projectile {

	private double angle;
	private double velocity;
	private double time;
	private double radians;
	
	public Projectile(double angle, double velocity, double time){
		this.angle = angle;
		this.velocity = velocity;
		this.time = time;
		this.radians = Math.toRadians(this.angle);
	}
	
	public double getAngle(){
		return angle;
	}
	public double getVelocity(){
		return velocity;
	}
	public double getTime(){
		return time;
	}

	public void setTime(double t){
		this.time = t;	
	}
	
	public double getX(){
		double x = Math.sin(radians) * this.velocity * this.time;
		return x;
	}
	public double getY(){
		double y = Math.cos(radians) * this.velocity * this.time - (.5 * 9.8 * time * time);
		return y;
	}


}
