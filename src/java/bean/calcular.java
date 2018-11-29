
package bean;

import java.io.Serializable;
import javax.inject.Named;
import javax.faces.view.ViewScoped;

/**
 *
 * @author valeria
 */
@Named(value = "fibonacciBean")
@ViewScoped
public class calcular implements Serializable {

    int limite;
    String resultado;
    String escolher;

    public String getEscolher() {
        return escolher;
    }

    public void setEscolher(String escolher) {
        this.escolher = escolher;
    }

    public int getLimite() {
        return limite;
    }

    public void setLimite(int limite) {
        this.limite = limite;
    }

    public String getResultado() {
        return resultado;
    }

    public void setResultado(String resultado) {
        this.resultado = resultado;
    }

    public String calcularFibonacci(int num) {

        if (num == 1 || num == 2) {
            return "1";
        }

        int num1 = 0;
        int num2 = 1;
        int aux = 0;
        String resSerie = "0 1";

        for (int i = 0; i < this.limite; i++) {

            aux = num1 + num2;
            num1 = num2;
            num2 = aux;
            resSerie = resSerie + " , " + num1;

        }

        return resSerie;

    }
    
    public static long calcularFatorial(int num) {
        if (num <= 1) {
            return 1;
        } else {
            return num * calcularFatorial(num - 1);
        }
    }

    public void mostrarCalculo() {
        if (this.limite <= 0) {
            this.resultado = "0";
        } else {
            this.resultado = calcularFibonacci(this.limite);
        }
        if ("fibonacci".equals(this.escolher)) {
            if (this.limite <= 0) {
                this.resultado = "0";
            } else {
                this.resultado = calcularFibonacci(this.limite);
            }
        } else if ("factorial".equals(this.escolher)) {
            long res = calcularFatorial(this.limite);
            this.resultado = Long.toString(res);
        } else {
            System.out.println(this.escolher);
        }

    }

    

}

