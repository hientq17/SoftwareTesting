public class CheckTriangle {

    public CheckTriangle() {
    }

    public boolean isTriangle(int a, int b, int c){
        if(a>=b+c) return false;
        if(b>=a+c) return false;
        return c < a + b;
    }
    public boolean isIsosceles(int a, int b, int c){
        if(a==b) return true;
        if(b==c) return true;
        return a == c;
    }
    public boolean isRight(int a, int b, int c){
        if(Math.pow(a,2)==Math.pow(b,2)+Math.pow(c,2)) return true;
        if(Math.pow(b,2)==Math.pow(a,2)+Math.pow(c,2)) return true;
        return Math.pow(c, 2) == Math.pow(b, 2) + Math.pow(a, 2);
    }
    public boolean isEquilateral(int a, int b, int c){
        return a==b && b==c;
    }

    public String checkAll(int a, int b, int c){
        if((a<1 || a>100) || (b<1 || b>100)  || (c<1 || c>100)){
            return "Input again";
        }
        if(isTriangle(a,b,c)){
            if(isEquilateral(a,b,c)){
                return "Equilateral triangle";
            } else if(isIsosceles(a,b,c)){
                if(isRight(a,b,c)){
                    return "Right isosceles triangle";
                } else{
                    return "Isosceles triangle";
                }
            } else if(isRight(a,b,c)){
                return "Right triangle";
            } else {
                return "Triangle";
            }
        }
        return "Not triangle";
    }
}
