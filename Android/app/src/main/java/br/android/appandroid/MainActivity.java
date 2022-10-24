package br.android.appandroid;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    //atributos para os dados persistentes do app
    //constantes
    private static String GASOLINA = "GASOLINA";
    private static String ETANOL = "ETANOL";

    //atributos gerais
    private static double gasolina;
    private static double etanol;

    //atributos referência para as views
    private EditText gasolinaEditText;
    private EditText etanolEditText;
    private TextView resultadoTextView;
    private Button btnCalcular;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //convertendo os componentes
        //classe R é do sistema, usada como receptora dos componentes
        gasolinaEditText = (EditText) findViewById(R.id.gasolinaTxt);
        etanolEditText = (EditText) findViewById(R.id.etanolTxt);
        btnCalcular = (Button) findViewById(R.id.btnCalcular);
        resultadoTextView = (TextView) findViewById(R.id.resultadoTextView);

        //ao clicar
        btnCalcular.setOnClickListener(ouvinteCalculaBtn);

        //verificando último estado do app
        if(savedInstanceState != null){
            gasolina = savedInstanceState.getDouble(GASOLINA); //ai que entra a constante
            etanol = savedInstanceState.getDouble(ETANOL);

            //formatando decimais
            gasolinaEditText.setText(String.format("0.1f", gasolina));
            etanolEditText.setText(String.format("0.1f", etanol));

            calcula();
        }
    }

    //método calcula
    private void calcula(){
        gasolina = Double.parseDouble(gasolinaEditText.getText().toString());
        etanol = Double.parseDouble(etanolEditText.getText().toString());
        resultadoTextView.setText(Calculadora.calcula(gasolina, etanol));
    }

    //vinculando ao evento de click do btn
    private View.OnClickListener ouvinteCalculaBtn = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            calcula();
        }
    };

    //método para salvar informações quando o app for suspenso
    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putDouble(GASOLINA, gasolina);
        outState.putDouble(ETANOL, etanol);
    }
}