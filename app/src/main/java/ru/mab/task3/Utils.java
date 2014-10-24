package ru.mab.task3;

/**
 * Created by mab on 24.10.2014.
 */
public class Utils {
    static double x0=2;
    static double y0=1;
    static double a1 = 2;
    static double a2 = 1;
    static double b1 = 2;
    static double b2 = 3;
    static double t1 = -10;
    static double t2 = 10;
    static int n = 100;

    public static double[][] solve(){
        double h = (t2-t1)/n;
        double[] X = new double[n];
        double[] Y = new double[n];
        double[][] result = new double[2][n];
        X[0] = x0;
        Y[0] = y0;
        for(int i=1;i<n;i++){
            X[i] = X[i-1] + h*fx(X[i-1], Y[i-1]);
            Y[i] = Y[i-1] + h*fy(X[i - 1], Y[i - 1]);
            result[0][i] = X[i];
            result[1][i] = Y[i];
        }
        return result;

    }

    public static double fx(double x, double y){
        return a1*x +b1*y;
    }
    public static double fy(double x, double y){
        return a2*x +b2*y;
    }
}
