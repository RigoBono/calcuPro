package pro.astrid.calcupro;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.StringTokenizer;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {


    /**
     * Variables para la calculadora que se encuentra en el activity_main layout
     * Consta de 17 botones y un text view
     */
    Button delete,mas,mul,menos,igual,div,uno,dos,tres,cuatro,cinco,seis,siete,ocho,nueve,cero,punto;
    TextView result;
    String acumulador="";


    /**
     *
     * @param savedInstanceState
     * Relacionar las variables con sus respectivos Ids del layout
     * Al igual que declarar el listener con el contexto para atrapar el evento de cada elemento utilizado en el layout
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        result=(TextView)findViewById(R.id.result);
        delete=(Button)findViewById(R.id.delete);
        mas=(Button)findViewById(R.id.mas);
        mul=(Button)findViewById(R.id.multi);
        menos=(Button)findViewById(R.id.menos);
        igual=(Button)findViewById(R.id.igual);
        div=(Button)findViewById(R.id.div);
        uno=(Button)findViewById(R.id.uno);
        dos=(Button)findViewById(R.id.dos);
        tres=(Button)findViewById(R.id.tres);
        cuatro=(Button)findViewById(R.id.cuatro);
        cinco=(Button)findViewById(R.id.cinco);
        seis=(Button)findViewById(R.id.seis);
        siete=(Button)findViewById(R.id.siete);
        ocho=(Button)findViewById(R.id.ocho);
        nueve=(Button)findViewById(R.id.nueve);
        cero=(Button)findViewById(R.id.cero);
        punto=(Button)findViewById(R.id.punto);

        punto.setOnClickListener(this);
        delete.setOnClickListener(this);
        mas.setOnClickListener(this);
        mul.setOnClickListener(this);
        menos.setOnClickListener(this);
        igual.setOnClickListener(this);
        div.setOnClickListener(this);
        uno.setOnClickListener(this);
        dos.setOnClickListener(this);
        tres.setOnClickListener(this);
        cuatro.setOnClickListener(this);
        cinco.setOnClickListener(this);
        seis.setOnClickListener(this);
        siete.setOnClickListener(this);
        ocho.setOnClickListener(this);
        nueve.setOnClickListener(this);
        cero.setOnClickListener(this);

    }

    /**
     *
     * @param view
     * Metodo que recibe el view de cada elemento presionado por su respectivo Id
     * y actualiza el valor del String acumulador
     */
    @Override
    public void onClick(View view) {
     switch (view.getId()){
         case R.id.cero:
             acumulador+="0";
             break;
         case R.id.uno:
             acumulador+="1";
             break;
         case R.id.dos:
             acumulador+="2";
             break;
         case R.id.tres:
             acumulador+="3";
             break;
         case R.id.cuatro:
             acumulador+="4";
             break;
         case R.id.cinco:
             acumulador+="5";
             break;
         case R.id.seis:
             acumulador+="6";
             break;
         case R.id.siete:
             acumulador+="7";
             break;
         case R.id.ocho:
             acumulador+="8";
             break;
         case R.id.nueve:
             acumulador+="9";
             break;
         case R.id.mas:
             acumulador+="+";
             break;
         case R.id.menos:
             acumulador+="-";
             break;
         case R.id.multi:
             acumulador+="*";
             break;
         case R.id.div:
             acumulador+="/";
             break;
         case R.id.igual:
             acumulador=Double.toString(operacion());
             break;
         case R.id.delete:
             acumulador="0";
             break;
         case R.id.punto:
             acumulador+=".";
             break;
     }
     result.setText(acumulador);
    }

    /**
     * Metodo que realiza la operaciones guardadas en el String acumulador según el orden en el que se encuentran los signos de las
     * operaciones
     * @return
     */
    public  double operacion(){
        double resultado=0;

        if(acumulador.contains("+")){
            StringTokenizer tkn=new StringTokenizer(acumulador,"+");
            while(tkn.hasMoreTokens()){
                double elemento=revisaMultis(tkn.nextToken());
                System.out.println(elemento);
                resultado+=elemento;
            }

        }
        return resultado;
    }




    public double revisaMultis(String acumuladorResumido){
        System.out.println("A multiplicar "+acumuladorResumido);
        if(acumuladorResumido.contains("*")){
            double resultado=1;
            StringTokenizer tkn=new StringTokenizer(acumuladorResumido,"*");
            while(tkn.hasMoreTokens()){
                double elemento=Double.parseDouble(tkn.nextToken());
                resultado*=elemento;
            }
            return resultado;

        }else{
            return Double.parseDouble(acumuladorResumido);
        }



    }

}
