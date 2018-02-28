/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sa;

import static java.lang.Math.exp;
import java.util.Random;
import static sa.SA.i;

/**
 *
 * @author Muliains
 */
public class SA {

    static Random r = new Random();
    static double x1,x2,a,b,y,z;
    static double hasil;
    static double hasilMin;
    static int i=1000000;
    static double Temperature=10000;
    static double Alpha=0.9999999999;
   
public static double rumus(double x1,double x2){
    double hasil;
        hasil =( (4-(2.1*x1*x1)+(x1*x1*x1*x1/3))*x1*x1+x1*x2+(-4+4*x2*x2)*x2*x2);
    return hasil;
}
    
    public static void main(String[] args) {
            x1 = r.nextDouble()*(10 - (-10)) + (-10);
            x2 = r.nextDouble()*(10 - (-10)) + (-10);
            a=x1;
            b=x2;
            hasilMin = rumus(x1,x2);
        
        while  (Temperature>1*Math.pow(10, -100) && (i>0)) {
            x1 = r.nextDouble()*(10 - (-10)) + (-10);
            x2 = r.nextDouble()*(10 - (-10)) + (-10);
            hasil = rumus(x1,x2);            
            if (hasil<hasilMin) {
                a=x1;
                b=x2;
                hasilMin=hasil;
            }else{
                y = r.nextDouble();
                z = (float) (exp(hasilMin-hasil)/Temperature);
                if(y<z){
                    a=x1;
                    b=x2;
                    hasilMin=hasil;
                }
            }
            Temperature= Temperature *Alpha;
            i--;
        }
            System.out.println("x1 : "+ a);
            System.out.println("x2 : "+ b);
            System.out.println("hasil : "+hasilMin);
            
            //System.out.println(rumus(2,2));
            
    }
    
}
