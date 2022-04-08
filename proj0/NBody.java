public class NBody {
    public static double readRadius(String args) {
        In in = new In(args);
        int numOfPlanets = in.readInt();
        double R = in.readDouble();
        return R;
    }

    public static Planet[] readPlanets(String fileName) {
        In in  = new In(fileName);
        int numOfPlanets = in.readInt();
        double R = in.readDouble();
        int count = 0;
        Planet[] pArray = new Planet[numOfPlanets];
        while (count < numOfPlanets) {
            double xxpos = in.readDouble();
            double yypos = in.readDouble();
            double xxVel = in.readDouble();
            double yyVel = in.readDouble();
            double mass = in.readDouble();
            String path = in.readString();
            pArray[count] = new Planet(xxpos, yypos, xxVel, yyVel, mass, path);
            count++;
        }
        return pArray;
    }

    public static void main(String args[]) {
        int waitingTime = 20;

        Double T = Double.parseDouble(args[0]);
        Double dt = Double.parseDouble(args[1]);
        String fileName = args[2];
        Double R = readRadius(fileName);
        Planet[] planets = readPlanets(fileName);
        int numOfPlanets = planets.length;

        String universe = "images/starfield.jpg";
        StdDraw.setScale(-R, R);
        StdDraw.clear();

        StdDraw.picture(0, 0, universe);
        for(Planet x: planets) {
            x.draw();
        }

        StdDraw.show();
        StdDraw.pause(waitingTime);

        Double[] xForces = new Double[numOfPlanets];
        Double[] yForces = new Double[numOfPlanets];
        Double time = 0.0;

        while (time < T) {
            for (int i = 0; i < numOfPlanets; i++) {
                xForces[i] = planets[i].calcNetForceExertedByX(planets);
                yForces[i] = planets[i].calcNetForceExertedByY(planets);
            }

            for (int i = 0; i < numOfPlanets; i++) {
                planets[i].update(dt, xForces[i], yForces[i]);
            }

            StdDraw.picture(0, 0, universe);
            for(Planet x: planets) {
                x.draw();
            }
            StdDraw.show();
            StdDraw.pause(waitingTime);
            time += dt;
        }

        StdOut.printf("%d\n", planets.length);
        StdOut.printf("%.2e\n", R);
        for (int i = 0; i < planets.length; i++) {
            StdOut.printf("%11.4e %11.4e %11.4e %11.4e %11.4e %12s\n",
                    planets[i].xxPos, planets[i].yyPos, planets[i].xxVel, planets[i].yyVel, planets[i].mass, planets[i].imgFileName);
        }

    }
}
