public class ConicCalc
{
    private String equation;
    private boolean isCircle;


    public ConicCalc(String str)
    {
        equation = str;
    }

    public boolean doMath(String equation)
    {
        if (equation.matches("^\\(x[+-]\\d+\\)\\^2\\s*[+|-]\\s*\\(y[+-]\\d+\\)\\^2\\s*=\\s*\\d+$") || equation.matches("^x\\^2\\s*[+|-]\\s*\\d*x\\s*[+|-]s*\\d*\\s*[+|-]\\s*y\\^2\\s*[+|-]\\s*\\d*y\\s*[+|-]s*\\d*\\s*=\\s\\d*$")) //circle  form
        {
            isCircle = true;
            return true;

        }
        else
        {
            return false;
        }
    }
/*
    public String circle(String a, String b, String c)
    {



    }

 */
}
