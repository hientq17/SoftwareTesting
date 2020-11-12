package main;

public class Triangle {

    private int a, b, c;

    public Triangle() {
    }

    public Triangle(int a, int b, int c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public String getName() {
        return getName(a, b, c);
    }

//    public String getName(float a, float b, float c) {
//        if (a + b > c && b + c > a && c + a > b) {
//            if (a == b && b == c) return "Equilateral triangle";
//            else if (a * a == b * b + c * c || b * b == a * a + c * c || c * c == a * a + b * b)
//                if(a == b || b == c || c == a)
//                    return "Right Isosceles triangle";
//                else
//                    return "Right triangle";
//            else if (a == b || b == c || a == c) {
//                    return "Isosceles triangle";
//            }else if (a == b & b == c)
//                return "Equilateral triangle";
//            else
//                return "Scalene triangle";
//        } else
//            return "Not a triangle";
//    }

    public String getName(float a, float b, float c) {
        if (a + b > c && b + c > a && c + a > b) {
            if (a == b && b == c) return "Equilateral triangle";
            else if (round(a*a) == round(b*b+c*c) || round(b*b)
                    == round(a*a+c*c) || round(c*c) == round(a*a+b*b))
                if(a == b || b == c || c == a)
                    return "Right Isosceles triangle";
                else
                    return "Right triangle";
            else if (a == b || b == c || a == c) {
                return "Isosceles triangle";
            }else if (a == b & b == c)
                return "Equilateral triangle";
            else
                return "Scalene triangle";
        } else
            return "Not a triangle";
    }

    public double round(float x){
        return Math.round(x*1000)/1000;
    }
}
