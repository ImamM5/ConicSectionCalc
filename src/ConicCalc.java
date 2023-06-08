public class ConicCalc {
    private String equation;
    private double A;
    private double B;
    private double C;
    private double D;
    private double E;
    private double H;
    private double K;


    public ConicCalc(String eq){
        this.equation = eq.replaceAll("\\s+","");
        if (!eq.contains("("))
        {
            String[] splitTerms = equation.split("(?=[-+])");
            for (String t : splitTerms) {
                if (t.contains("x^2")) {
                    this.A = extractValues(t);
                } else if (t.contains("y^2")) {
                    this.B = extractValues(t);
                } else if (t.contains("xy")) {
                    this.C = extractValues(t);
                } else if (t.contains("x")) {
                    this.D = extractValues(t);
                } else {
                    this.E = extractValues(t);
                }
        }

            }
    }

    public String findCSection()
    {
        if (equation.contains(")")) {
           return determineEquationFactored();
        }
        else return determineEquation();

    }
    public String determineEquation(){
        if (A == B && D == 0) {
            return "circle.";
        }
        if (A != 0 && B == 0 && C == 0) {
            return "parabola\n" + parabolaZeroes();
        }
        else if (A!=0 && B < 0) {
            return "hyperbola.";
        }
        else if (A != B && A != 0){
            return "ellipse.";
        }
        else if (A == B && D == 0) {
            return "circle.";
        } else {
            return "line.";
        }
    }

    //new added method
    public String determineEquationFactored()
    {
        String str = "";
        int firstPL = equation.indexOf("(");
        int secondPL = equation.indexOf("(", firstPL+1);
        int firstPR = equation.indexOf(")");
        int secondPr = equation.indexOf(")", firstPR+1);
        String checkSigns = equation.substring(equation.indexOf("^"), secondPL);
        String lastNum = equation.substring(equation.indexOf("=")+1);


        if (checkSigns.contains("-") && equation.contains("/") && lastNum.equals("1"))
        {
            String myStr = equation.substring(0, equation.indexOf(")"));
            myStr = myStr.replace("(", "");
            myStr = myStr.replace("x", "");
            H = extractValues(myStr);
            String newStr = equation.substring(equation.indexOf("y"), secondPr);
            newStr = newStr.replace("(", "");
            newStr = newStr.replace("y", "");
            newStr = newStr.replace(")","");
            newStr = newStr.replace("^2", "");
            K = extractValues(newStr);
            str= "hyperbolaF";
        }
        else if (checkSigns.contains("+") && equation.contains("/") && lastNum.equals("1")){
            String myStr = equation.substring(0, equation.indexOf(")"));
            myStr = myStr.replace("(", "");
            myStr = myStr.replace("x", "");
            H = extractValues(myStr);
            String newStr = equation.substring(equation.indexOf("y"), secondPr);
            newStr = newStr.replace("(", "");
            newStr = newStr.replace("y", "");
            newStr = newStr.replace(")","");
            newStr = newStr.replace("^2", "");
            K = extractValues(newStr);
            str= "ellipseF";
        } else {
            String myStr = equation.substring(0, equation.indexOf(")"));
            myStr = myStr.replace("(", "");
            myStr = myStr.replace("x", "");
            H = extractValues(myStr);
            String newStr = equation.substring(equation.indexOf("y"), equation.indexOf("="));
            newStr = newStr.replace("(", "");
            newStr = newStr.replace("y", "");
            newStr = newStr.replace(")","");
            newStr = newStr.replace("^2", "");
            K = extractValues(newStr);
            return "circleF";
        }
        return str;
    }
    private double extractValues(String term) {
        double val = 0.0;
        String start = term.substring(0, 1);
        if (start.equals("-") || start.equals("+")) {
            if (term.charAt(1) == 'x' || term.charAt(1) == 'y') {
                val = 1;
            } else {
                term = term.replace("x", "");
                term = term.replace("y", "");
                term = term.replace("y^2", "");
                term = term.replace("x^2", "");
                val = Double.parseDouble(term.substring(1));
            }
            if (start.equals("-")) {
                val *= -1;
            }
        } else if (start.equals("x") || start.equals("y")) {
            val = 1 ;
        } else {
            term = term.replace("+", "");
            term = term.replace("-", "");
            val = Double.parseDouble(term);
        }
        return val;
    }

    private String parabolaZeroes(){
        double vertex = -D/(2*A);
        double discriminant = Math.pow(D, 2) - (4 * A * E);
        String zeroesString = "No real zeroes";
        if (discriminant > 0) {

            double zero1 = (-D + Math.sqrt(discriminant)) / (2 * A);
            double zero2 = (-D - Math.sqrt(discriminant)) / (2 * A);
            zeroesString = String.format("Zeroes are: %.2f, %.2f", -zero1, -zero2);
        } else if (discriminant == 0) {

            double zero = -D / (2 * A);
            zeroesString = String.format("Zero: %.2f", -zero);
        }
        String ver = String.format("\nVertex: %.2f", vertex);
        return zeroesString + ver ;
    }

    public String ellipseCalc()
    {
        int firstPL = equation.indexOf("(");
        int secondPL = equation.indexOf("(", firstPL+1);

        String str;
        String firstHalf = equation.substring(equation.indexOf("x"), secondPL);
        double aSq = Double.parseDouble(firstHalf.substring(firstHalf.indexOf("/")+1, firstHalf.length()-1));
        double a = Math.sqrt(aSq);
        String secondHalf = equation.substring(equation.indexOf("y"), equation.indexOf("="));
        double bSq =  Double.parseDouble(secondHalf.substring(secondHalf.indexOf("/")+1, secondHalf.length()));

        double b = Math.sqrt(bSq);
        double c = Math.sqrt(aSq - bSq);

        double eccen = c/b;


        double verX1;
        double verY1;
        double verX2;
        double verY2;
        double coVerX1;
        double coVerY1;
        double coVerX2;
        double coVerY2;
        double focusX1;
        double focusY1;
        double focusX2;
        double focusY2;
        double maAxis;
        double miAxis;


        if (bSq > aSq)
        {
            verX1 = -H;
            verY1 = (-K)-b;
            verX2 = -H;
            verY2 = (-K)+b;

            coVerX1 = (-H)-a;
            coVerY1 = (-K);
            coVerX2 = (-H)+a;
            coVerY2 = -K;

            focusX1 = -H;
            focusY1 = (-K)-c;
            focusX2 = -H;
            focusY2 = (-K)+c;
            maAxis = 2*b;
            miAxis = 2*a;

        }
        else{
            verX1 = (-H)-a;
            verY1 = -K;
            verX2 = (-H)+a;
            verY2 = -K;

            coVerX1 = -H;
            coVerY1 = (-K)-b;
            coVerX2 = (-H);
            coVerY2 = (-K)+b;

            focusX1 = (-H)-c;
            focusY1 = -K;
            focusX2 = (-H)+c;
            focusY2 = -K;
            maAxis = 2*a;
            miAxis = 2*b;

        }
        // Round the values to 2 decimal places
        verX1 = Math.round(verX1 * 100) / 100.0;
        verY1 = Math.round(verY1 * 100) / 100.0;
        verX2 = Math.round(verX2 * 100) / 100.0;
        verY2 = Math.round(verY2 * 100) / 100.0;
        coVerX1 = Math.round(coVerX1 * 100) / 100.0;
        coVerY1 = Math.round(coVerY1 * 100) / 100.0;
        coVerX2 = Math.round(coVerX2 * 100) / 100.0;
        coVerY2 = Math.round(coVerY2 * 100) / 100.0;
        focusX1 = Math.round(focusX1 * 100) / 100.0;
        focusY1 = Math.round(focusY1 * 100) / 100.0;
        focusX2 = Math.round(focusX2 * 100) / 100.0;
        focusY2 = Math.round(focusY2 * 100) / 100.0;
        maAxis = Math.round(maAxis * 100) / 100.0;
        miAxis = Math.round(miAxis * 100) / 100.0;
        eccen = Math.round(eccen * 100) / 100.0;


        str = "Ellipse" + "\n\nCenter: ("+ -H +","+ -K +")\n\nVertices: ("+ verX1 +", "+ verY1+ ")  ("+verX2+", "+verY2 +")\n\nCo-vertices: ("+ coVerX1 +", "+ coVerY1+ ")  ("+coVerX2+", "+coVerY2 +")\n\nFoci: ("+ focusX1 +", "+ focusY1+ ")  ("+focusX2+", "+focusY2 +")\n\nMajor axis: "+ maAxis + "\n\nMinor axis: "+ miAxis + "\n\nEccentricity: "+ eccen;

        return str;
    }
    public String circleCalc()
    {
        String radius = equation.substring(equation.indexOf("=") + 1);
        Double rad = extractValues(radius);
        rad = Math.sqrt(rad);
        return "Circle " + "\n\nCenter: ("+ -H +","+ -K +")\n\nRadius: " + rad +"\n\nDiameter: " + rad*2 + "\n\nCircumfrence: " + rad*2+"π\n\nArea: " + Math.pow(rad,2) +"π";

    }

    public String hyperbolaCalc()
    {
        int firstPL = equation.indexOf("(");
        int secondPL = equation.indexOf("(", firstPL+1);

        String str;
        String firstHalf = equation.substring(equation.indexOf("x"), secondPL);
        double aSq = Double.parseDouble(firstHalf.substring(firstHalf.indexOf("/")+1, firstHalf.length()-1));
        double a = Math.sqrt(aSq);
        String secondHalf = equation.substring(equation.indexOf("y"), equation.indexOf("="));
        double bSq =  Double.parseDouble(secondHalf.substring(secondHalf.indexOf("/")+1, secondHalf.length()));

        double b = Math.sqrt(bSq);
        double c = Math.sqrt(aSq+bSq);

        double eccen = Math.sqrt(1+(bSq/aSq));

        double verX1 = (-H)-a;
        double verY1 = -K;
        double verX2 = (-H)+a;
        double verY2 = -K;

        double coVerX1 = -H;
        double coVerY1 = (-K)-b;
        double coVerX2 = (-H);
        double coVerY2 = (-K)+b;

        double focusX1 = (-H)-c;
        double focusY1 = -K;
        double focusX2 = (-H)+c;
        double focusY2 = -K;
        double maAxis = 2*a;
        double miAxis = 2*b;

        // Round the values to 2 decimal places
        verX1 = Math.round(verX1 * 100) / 100.0;
        verY1 = Math.round(verY1 * 100) / 100.0;
        verX2 = Math.round(verX2 * 100) / 100.0;
        verY2 = Math.round(verY2 * 100) / 100.0;
        coVerX1 = Math.round(coVerX1 * 100) / 100.0;
        coVerY1 = Math.round(coVerY1 * 100) / 100.0;
        coVerX2 = Math.round(coVerX2 * 100) / 100.0;
        coVerY2 = Math.round(coVerY2 * 100) / 100.0;
        focusX1 = Math.round(focusX1 * 100) / 100.0;
        focusY1 = Math.round(focusY1 * 100) / 100.0;
        focusX2 = Math.round(focusX2 * 100) / 100.0;
        focusY2 = Math.round(focusY2 * 100) / 100.0;
        maAxis = Math.round(maAxis * 100) / 100.0;
        miAxis = Math.round(miAxis * 100) / 100.0;
        eccen = Math.round(eccen * 100) / 100.0;

        str = "Hyperbola" + "\n\nCenter: ("+ -H +","+ -K +")\n\nVertices: ("+ verX1 +", "+ verY1+ ")  ("+verX2+", "+verY2 +")\n\nCo-vertices: ("+ coVerX1 +", "+ coVerY1+ ")  ("+coVerX2+", "+coVerY2 +")\n\nFoci: ("+ focusX1 +", "+ focusY1+ ")  ("+focusX2+", "+focusY2 +")\n\nMajor axis: "+ maAxis + "\n\nMinor axis: "+ miAxis + "\n\nEccentricity: "+ eccen;

        return str;
    }
}