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
	
} 
