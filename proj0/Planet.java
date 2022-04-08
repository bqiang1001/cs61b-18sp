public class Planet {
    double xxPos, yyPos, xxVel, yyVel, mass;
    String imgFileName;
    static final double G = 6.67e-11;
    public Planet(double xP, double yP, double xV, double yV, double m, String img) {
        xxPos = xP;
        yyPos = yP;
        xxVel = xV;
        yyVel = yV;
        mass = m;
        imgFileName = img;
    }
    public Planet(Planet p) {
        xxPos = p.xxPos;
        yyPos = p.yyPos;
        xxVel = p.xxVel;
        yyVel = p.yyVel;
        mass =  p.mass;
        imgFileName = p.imgFileName;
    }

    public double calcDistance(Planet p) {
        double dx = xxPos - p.xxPos;
        double dy = yyPos - p.yyPos;
        return Math.sqrt(dx * dx + dy * dy);
    }

    public double calcForceExertedBy(Planet p) {
        double d = calcDistance(p);
        return G * mass * p.mass / d / d;
    }

    public double calcForceExertedByX(Planet p) {
        double F = calcForceExertedBy(p);
        double distance = calcDistance(p);
        return F * (p.xxPos - xxPos) / distance;
    }

    public double calcForceExertedByY(Planet p) {
        double F = calcForceExertedBy(p);
        double distance = calcDistance(p);
        return F * (p.yyPos - yyPos) / distance;
    }

    public double calcNetForceExertedByX(Planet[] arr) {
        double netForceX = 0;
        for (int i = 0; i < arr.length; i++) {
            if (this.equals(arr[i])) {
                continue;
            }
            netForceX += calcForceExertedByX(arr[i]);
        }
        return netForceX;

    }
    public double calcNetForceExertedByY (Planet[] arr) {
        double netForceY = 0;
        for (int i = 0; i < arr.length; i++) {
            if (this.equals(arr[i])) {
                continue;
            }
            netForceY += calcForceExertedByY(arr[i]);
        }
        return netForceY;

    }

    public void update(double dt, double Fx, double Fy) {
        double ax = Fx / mass, ay = Fy / mass;
        xxVel += dt * ax;
        yyVel += dt * ay;
        xxPos += xxVel * dt;
        yyPos += yyVel * dt;
    }

    public void draw() {
        StdDraw.picture(this.xxPos, this.yyPos, "images/" + this.imgFileName);
    }

}
