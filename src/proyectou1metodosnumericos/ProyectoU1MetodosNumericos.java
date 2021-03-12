package proyectou1metodosnumericos;
import java.util.Scanner;
public class ProyectoU1MetodosNumericos {

    public static void main(String[] args) {
       Scanner teclado = new Scanner(System.in);
       int opc;
       boolean salir=false;
        
        do{
        System.out.println("Selecciona que deseas hacer:");
        System.out.println("1.Eulet a la x");
        System.out.println("2.Eulet a la -x");
        System.out.println("3.Varianza");
        System.out.println("4.Resolver una ecuacion cuadratica con 3 metodos diferentes");
        System.out.println("5.Salir");
        opc=teclado.nextInt();
        switch(opc){
            case 1:
                System.out.println("calculo de e^x usando su formula igualitaria e^x=∑(n) x^j/j!");
                System.out.println("");
                System.out.println("introduzca X");
                int x = teclado.nextInt();
                System.out.println("introduzca j");
                int j = teclado.nextInt();
                double suma = 0;
                for (int i = 0; i < j+1; i++) {
                    suma = suma + Math.pow(x, i) / (factorial(i));
                }
                System.out.println("");
                System.out.println("resultado: " + suma); 
            break;
            case 2:
                System.out.println("calculo de e^-x usando su formula igualitaria e^-x=1/∑(n) (x^j/j!)");
                System.out.println("");
                System.out.println("introduzca X");
                int y = teclado.nextInt();
                System.out.println("introduzca j");
                int k = teclado.nextInt();
                double suma2 = 0;

                for (int i = 0; i < k + 1; i++) {
                    suma2 = suma2 + 1 / (Math.pow(y, i) / (factorial(i)));
                }
                System.out.println("");
                System.out.println("resultado: " + suma2);
            break;
            case 3:
                double numerosaleatorios[];
                double summedia = 0, varianza, media,sumavar=0;
                System.out.println("programa para sacar la varianza con su formula varianza=((x-x̅)^2+(x2-x̅)^2+...+(xn-x̅)^2)/n" );
                System.out.println("cuantos numeros quiere agregar?");
                int elementos = teclado.nextInt();
                //int no;
                numerosaleatorios = new double[elementos];
                for (int i = 0; i < elementos; i++) {
                    numerosaleatorios[i] =Math.random();                   //(no=tec.nextInt());
                }
                for (int i = 0; i < elementos; i++) {
                    summedia += numerosaleatorios[i];
                }
                media = summedia / elementos;           
                for (int i = 0; i < elementos; i++) {               
                   sumavar+=Math.pow(numerosaleatorios[i]-media, 2);
                }
                varianza=sumavar/elementos;       
                System.out.println("la varianza es: "+varianza); 
            break;
            case 4:
                double a,b,c,igual;
                System.out.println("Ingresa el valor de a(x^2)");
                a=teclado.nextDouble();
                System.out.println("Ingresa el valor de b(x)");
                b=teclado.nextDouble();
                System.out.println("Ingresa el valor de c(termino independiente)");
                c=teclado.nextDouble();
                System.out.println("Todo esto es igual a:");
                igual=teclado.nextDouble();
                c=c-igual;
                System.out.println("Resolucion por formula general:");
                FormulaGeneral(a,b,c);
                System.out.println("Resolucion por el metodo de Po-Shen Loh");
                PoShenLoh(a,b,c);
                System.out.println("Resolucion por el metodo de Formula General a la Inversa");
                FormulaGeneralInversa(a,b,c);
            break;
            case 5:
                salir=true;
                System.out.println("Gracias por usar el programa :)");
            break;
            default:
                System.out.println("Opcion incorrecta, ingrese otra porfavor");
            break;
        }
        }while(salir!=true);
            
        
     
    }
    
    public static boolean discriminante(double a,double b,double c){
        double discriminante;
        discriminante=(Math.pow(b,2))-(4*(a)*(c));
        if(discriminante<0){
            return true;
        }
        else{
            return false;
        }
    }
    
    public static void FormulaGeneral(double a,double b,double c){
        double ac,x1,x2;
        ac=(Math.pow(b,2))-(4*(a)*(c));
        if(discriminante(a,b,c)==true){
            System.out.println("El problema no tiene solucion");
        }
        else{
            x1=(-(b)+Math.sqrt(ac))/(2*(a));
            x2=(-(b)-Math.sqrt(ac))/(2*(a));
            System.out.println("x1="+x1);
            System.out.println("x2="+x2);
        }
    }
    public static void PoShenLoh(double a,double b,double c){
        if(discriminante(a,b,c)==true){
            System.out.println("El problema no tiene solucion");
        }
        else{
            double b1=b/a;
            double c1=c/a;
            double p=-(b1)/2;
            double u=Math.sqrt((c1-(Math.pow(p, 2)))*-1);
            double x1=p+u;
            double x2=p-u;
            System.out.println("x1="+x1);
            System.out.println("x2="+x2);  
        }
        
    }
    public static int factorial (int numero) {
        double factorial;
        if (numero==0)
        return 1;
        else
        return numero * factorial(numero-1);
    }
    
    public static void FormulaGeneralInversa(double a,double b,double c){
        if(discriminante(a,b,c)==true){
            System.out.println("El problema no tiene solucion");
        }
        else{
            double x1=(-2*c)/(b+(Math.sqrt(Math.pow(b,2)-(4*a*c))));
            double x2=(-2*c)/(b-(Math.sqrt(Math.pow(b,2)-(4*a*c))));
            System.out.println("x1="+x1);
            System.out.println("x2="+x2);    
        }
    }
    
}
