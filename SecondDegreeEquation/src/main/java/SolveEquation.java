public class SolveEquation {
    public String firstDegreeEquation(double b, double c) {
        if (b == 0) {
            if (c == 0) {
                return "countless solutions";
            } else {
                return "no solution";
            }
        } else {
            double x = -c/b;
            return String.valueOf((double)Math.round(x*10000)/10000);
        }
    }

    public String secondDegreeEquation(double a, double b, double c) {
        double delta = Math.pow(b, 2) - 4 * a * c;
        if (delta > 0) {
            double x1 = (-b + Math.sqrt(delta)) / (2 * a);
            double x2 = (-b - Math.sqrt(delta)) / (2 * a);
            if(x1<x2) return String.valueOf((double)Math.round(x1*10000)/10000+";"+(double)Math.round(x2*10000)/10000);
            else return String.valueOf((double)Math.round(x2*10000)/10000+";"+(double)Math.round(x1*10000)/10000);
        }
        else if (delta == 0) {
            double x = (-b / (2 * a));
            return String.valueOf((double)Math.round(x*10000)/10000);
        } else {
            return "no solution";
        }
    }

    public String solveEquation(double a, double b, double c){
        if (a == 0) {
            return firstDegreeEquation(b, c);
        } else {
            return secondDegreeEquation(a, b, c);
        }
    }


}
