package com.matheus.gabriel.calculadoradosalarioliquido;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.EditText;
import android.widget.Spinner;


public class PageResultado extends AppCompatActivity {

    private double salarioBruto;
    private double valorPlanoSaude;
    private double valorValeAlimentacao;
    private double valorValeRefeicao;
    private double valorValeTransporte;
    private double valorIrrf;
    private double porcentagemDesconto;
    private double salarioLiquido;
    private double valorInss;

    private EditText editSalarioBruto;
    private EditText editValorPlano;
    private EditText editValeRefeicao;
    private EditText editValeAlimentacao;
    private EditText editValeTransporte;
    private EditText editValorIrrf;
    private EditText editPorcentagemDesc;
    private EditText editSalarioLiquido;
    private EditText editValorInss;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.resultado_activity);


        salarioBruto = getIntent().getDoubleExtra("salarioBruto",0);
        valorPlanoSaude = getIntent().getIntExtra("valorPlano",0);
        valorValeRefeicao = getIntent().getDoubleExtra("valorValeRefeicao",0);
        valorValeAlimentacao = getIntent().getIntExtra("valorValeAlimentacao",0);
        valorValeTransporte = getIntent().getDoubleExtra("valorValeTransporte",0);
        valorInss = getIntent().getDoubleExtra("inss",0);
        valorIrrf = getIntent().getDoubleExtra("valorIrrf",0);
        porcentagemDesconto = getIntent().getDoubleExtra("porcentagemDesconto",0);
        salarioLiquido = getIntent().getDoubleExtra("salarioLiquido",0);

        Log.i("T:","----------------------------------------");
        Log.i("T:","Segunda Pagina");
        Log.i("T:","----------------------------------------");
        Log.i("T:","Salario Bruto"+salarioBruto);
        Log.i("T:","valor Plano Saude:" + valorPlanoSaude);
        Log.i("T:","valorValeRefeicao:" + valorValeRefeicao);
        Log.i("T:","valorValeAlimentacao:" + valorValeAlimentacao);
        Log.i("T:","valorValeTransporte:" + valorValeTransporte);
        Log.i("T:","valorIRRF"+valorIrrf);
        Log.i("T:","porcentagemDesconto:" + porcentagemDesconto);
        Log.i("T:","Salario Liquido:" + salarioLiquido);

        editSalarioBruto = (EditText) findViewById(R.id.vlSalarioBruto);
        editSalarioBruto.setText("Salario Bruto"+ String.format(" R$ %.2f ",salarioBruto));
        editSalarioBruto.setEnabled(false);

        editValorPlano = (EditText) findViewById(R.id.vlPlanoSaude);
        editValorPlano.setText("Desconto Plano de Saúde"+ String.format(" R$ %.2f ",valorPlanoSaude));
        editValorPlano.setEnabled(false);

        editValeRefeicao = (EditText) findViewById(R.id.vlValeRefeicao);
        editValeRefeicao.setText("Desconto Vale Refeição"+ String.format(" R$ %.2f ",valorValeRefeicao));
        editValeRefeicao.setEnabled(false);

        editValeAlimentacao = (EditText) findViewById(R.id.vlValeAlimentacao);
        editValeAlimentacao.setText("Desconto Vale Alimentação"+ String.format(" R$ %.2f ",valorValeAlimentacao));
        editValeAlimentacao.setEnabled(false);

        editValeTransporte = (EditText) findViewById(R.id.vlValeTransporte);
        editValeTransporte.setText("Desconto Vale Transporte"+ String.format(" R$ %.2f ",valorValeTransporte));
        editValeTransporte.setEnabled(false);

        editValorInss = (EditText) findViewById(R.id.vlInss);
        editValorInss.setText("Valor INSS"+ String.format(" R$ %.2f ",valorInss));
        editValorInss.setEnabled(false);

        editValorIrrf = (EditText) findViewById(R.id.vlIrrf);
        editValorIrrf.setText("Desconto do IRRF"+ String.format(" R$ %.2f ",valorIrrf));
        editValorIrrf.setEnabled(false);

        editPorcentagemDesc = (EditText) findViewById(R.id.vlporcentagemDesconto);
        editPorcentagemDesc.setText("Porcentagem de Desconto"+String.format(" %.2f",porcentagemDesconto)+"%");
        editPorcentagemDesc.setEnabled(false);

        editSalarioLiquido = (EditText) findViewById(R.id.vlSalarioLiq);
        editSalarioLiquido.setText("Salario Liquido"+String.format(" R$ %.2f ",salarioLiquido));
        editSalarioLiquido.setEnabled(false);



    }
}
