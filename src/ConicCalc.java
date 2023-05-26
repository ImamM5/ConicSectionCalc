public class ConicCalc {
    private String equation;
    private double A;
    private double B;
    private double C;
    private double D;

    public ConicCalc(String eq){
        this.equation = eq.replaceAll("\s+","");
        String[] splitTerms = equation.split("[+-]");

        for (String t : splitTerms) {
            if (t.contains("x^2")) {
                this.A = extractValues(t);
            }
            else if (t.contains("y^2")) {
                this.B = extractValues(t);
            }
            else if (t.contains("xy")) {
                this.C = extractValues(t);
            } else if (t.contains("x")){
                this.D = extractValues(t);
            }
        }
        determineEquation();
    }
    public String determineEquation(){
        if (A != 0 && B == 0 && C == 0) {
            return "The equation represents a parabola.";
        }
        else if (D != 0 && A!=0) {
            return "The equation represents a hyperbola.";
        }
        else if (A != B && A != 0){
            return "The equation represents an ellipse.";
        }
        else if (A == B && D == 0) {
            return "The equation represents a circle.";
        } else {
            return "The equation represents a line.";
        }
    }
    private double extractValues(String term){
        String start = term.substring(0,1);
        if (start.equals("-"))
            return -Double.parseDouble(term.substring(1));
        else if (start.equals("+"))
            return Double.parseDouble(term.substring(1));
        else if (start.equals("x") || start.equals("y"))
            return 1;
        else {
            return Double.parseDouble(start);
        }
    }
}