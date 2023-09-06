class NBody {
	public static double readRadius(String filePath) {
		In in = new In(filePath);
		int t = in.readInt();
		return in.readDouble();
	}	
	public static Planet[] readPlanets(String filePath) {
		In in = new In(filePath);
		int cnt = in.readInt();
		Planet []p = new Planet[cnt];
		double radius = in.readDouble();
		for(int i = 0; i < cnt; i++) {
			double a = in.readDouble();
			double b = in.readDouble();
			double c = in.readDouble();
			double d = in.readDouble();
			double e = in.readDouble();
			String f = in.readString();
			p[i] = new Planet(a,b,c,d,e,f);
		}
		return p;
	}

	public static void main(String[] args) {
		double T = Double.parseDouble(args[0]);
		double dt = Double.parseDouble(args[1]);
		String filename = args[2];
		Planet[] p = readPlanets(filename);
		double radius = readRadius(filename);
		StdDraw.setScale(-1 * radius,radius);
		StdDraw.enableDoubleBuffering();
		StdDraw.show();


		StdDraw.picture(0,0,"images/starfield.jpg");
		for(Planet t : p) t.draw();
		StdDraw.show();

		int n = p.length;

		for(double t = 0; t < T; t += dt) {
			double[] xForces = new double[n];
			double[] yForces = new double[n];
			for(int i = 0; i < n; i++) xForces[i] = p[i].calcNetForceExertedByX(p);
			for(int i = 0; i < n; i++) p[i] = p[i].update(dt,xForces[i],yForces[i]);

			StdDraw.picture(0,0,"images/starfield.jpg");
			for(Planet a : p) a.draw();
			StdDraw.show();
			StdDraw.pause(10);
		}

		StdOut.printf("%d\n", p.length);
		StdOut.printf("%.2e\n", radius);
		for (int i = 0; i < p.length; i++) {
		    StdOut.printf("%11.4e %11.4e %11.4e %11.4e %11.4e %12s\n",p[i].xxPos, p[i].yyPos, p[i].xxVel,p[i].yyVel, p[i].mass, p[i].imgFileName);   
		}
	}
	
} 