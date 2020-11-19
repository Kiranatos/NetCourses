package net.kiranatos.stepik.java_basic.third_week.ex7;

import java.util.function.DoubleUnaryOperator;

public class CalcIntegral {

//метод левых прямоугольников

    public static void main(String[] args) {
        /*
        double h = 1e-8; //0,000 000 01        
        double s = 0;
        double s2 = 0;

        for (int i = 0; i < 1e8; i++) {
            s += h;            
        }

        s2 = h * 1e8;
        System.out.println(s);  // 1.000 000 002 2898672
        System.out.println(s2); // 1.0
        
        */
        
        
        System.out.println(integrate(x -> 1, 0, 10));//10.0
        
        System.out.println( integrate(
                new  DoubleUnaryOperator() {
                    @Override
                    public double applyAsDouble(double operand) {
                        return 1;
                    } }, 
                0, 10));//10.0
        
        System.out.println(integrate(x -> x + 2, 0, 10));//70.0
        System.out.println(integrate( x -> Math.sin(x) / x , 1, 5));//0.603848
    }
    
    public static double integrate(DoubleUnaryOperator f, double a, double b) {
        int i;
        double result = 0, h;
        int k = 1_000_000_00;

        h = (b - a) / k; //Шаг сетки
        for(i = 0; i < k; i++)        {
            result += f.applyAsDouble(a + h * (i + 0.5)); //Вычисляем в средней точке и добавляем в сумму
        }
        
        result *= h;
        
        return result;
    }
}

/*
class A implements DoubleUnaryOperator {

    @Override
    public double applyAsDouble(double operand) {
        
    }
}*/