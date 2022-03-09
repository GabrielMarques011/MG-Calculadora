package com.matheus.gabriel.calculadoradosalarioliquido;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    // CRIANDO AS VARIAVEIS
    private EditText editSalarioBruto,editDependentes;
    private double salarioLiquido,inss, porcentagemDesconto,valorValeTransporte ,valorValeRefeicao,valorIrrf,baseIrrf;
    private Button btCalcular;
    int valorPlanoSaude,valorValeAlimentacao;

    //private Spinner duvidaPlano,duvidaTransporte,duvidaAlimentacao,duvidaRefeicao;
    private Spinner editPlanoSaude,editValeTransporte,editValeAlimentacao,editValeRefeicao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // ESTANCIANDO AS VARIAVEIS
        editSalarioBruto = (EditText) findViewById(R.id.salario_bruto);
        editDependentes = (EditText) findViewById(R.id.dependentes);
        editPlanoSaude = (Spinner) findViewById(R.id.plano);
        editValeTransporte = (Spinner) findViewById(R.id.vale_trans);
        editValeAlimentacao = (Spinner) findViewById(R.id.vale_alim);
        editValeRefeicao = (Spinner) findViewById(R.id.vale_refe);
        btCalcular = (Button) findViewById(R.id.btn_calcular);

        //duvidaPlano.findViewById(R.id.vlPlano);
        //duvidaTransporte.findViewById(R.id.vale_trans);
        //duvidaAlimentacao.findViewById(R.id.vale_alim);
        //duvidaRefeicao.findViewById(R.id.vale_refe);


        btCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (editSalarioBruto.getText().toString().isEmpty()) {
                    Toast.makeText(getBaseContext(), "Informe o Salário", Toast.LENGTH_SHORT).show();
                } else if (editDependentes.getText().toString().isEmpty()) {
                    Toast.makeText(getBaseContext(), "Informe o numero de Dependentes", Toast.LENGTH_SHORT).show();
                }else if (editPlanoSaude.getSelectedItemPosition() == 0) {
                    Toast.makeText(getBaseContext(), "Informe o seu Plano de Saúde", Toast.LENGTH_SHORT).show();
                }else if (editValeTransporte.getSelectedItemPosition() == 0) {
                    //mensagem de erro, caso não selecione o valor
                    Toast.makeText(getBaseContext(), "Informe o se você tem vale Transporte", Toast.LENGTH_SHORT).show();
                }else if (editValeRefeicao.getSelectedItemPosition() == 0) {
                    Toast.makeText(getBaseContext(), "Informe o se você tem vale Refeição", Toast.LENGTH_SHORT).show();
                }else if (editValeAlimentacao.getSelectedItemPosition() == 0) {
                    Toast.makeText(getBaseContext(), "Informe o se você tem vale Alimentação", Toast.LENGTH_SHORT).show();
                }
                else {

                    double salarioBruto = Double.parseDouble(editSalarioBruto.getText().toString());
                    double dependentes = Double.parseDouble(editDependentes.getText().toString());

                    if (editPlanoSaude.getSelectedItemPosition() == 1) {
                        if (salarioBruto <= 3000) {
                            valorPlanoSaude = (60);
                        } else {
                            valorPlanoSaude = (80);
                        }
                    } else if (editPlanoSaude.getSelectedItemPosition() == 2) {
                        if (salarioBruto <= 3000) {
                            valorPlanoSaude = (80);
                        } else {
                            valorPlanoSaude = (110);
                        }
                    } else if (editPlanoSaude.getSelectedItemPosition() == 3) {
                        if (salarioBruto <= 3000) {
                            valorPlanoSaude = (95);
                        } else {
                            valorPlanoSaude = (135);
                        }
                    } else {
                        if (salarioBruto <= 3000) {
                            valorPlanoSaude = (130);
                        } else {
                            valorPlanoSaude = (180);
                        }
                    }


                    //Estrutura para determinar o valor do vale transporte
                    if (editValeTransporte.getSelectedItemPosition() == 1) {
                        valorValeTransporte = salarioBruto * 0.06;
                    } else {
                        valorValeTransporte = 0;
                    }


                    //Estrutura para saber o valor do vale refeição
                    if (editValeRefeicao.getSelectedItemPosition() == 1) {
                        if (salarioBruto <= 3000) {
                            valorValeRefeicao = 2.6 * 22;
                        } else if (salarioBruto <= 5000) {
                            valorValeRefeicao = 3.65 * 22;
                        } else {
                            valorValeRefeicao = 6.5 * 22;
                        }
                    } else if (editValeRefeicao.getSelectedItemPosition() == 2) {
                        valorValeRefeicao = 0;
                    }


                    //Estrutura para saber se tem o vale Alimentação
                    if (editValeAlimentacao.getSelectedItemPosition() == 1) {
                        if (salarioBruto <= 3000) {
                            valorValeAlimentacao = 15;
                        } else if (salarioBruto < 5000) {
                            valorValeAlimentacao = 25;
                        } else {
                            valorValeAlimentacao = 35;
                        }
                    } else {
                        valorValeAlimentacao = 0;
                    }


                    //Estrutura para saber o valor do INSS
                    if (salarioBruto <= 1212) {
                        inss = salarioBruto * 0.075;
                    } else if (salarioBruto < 2427.35) {
                        inss = (salarioBruto * 0.09) - 18.18;
                    } else if (salarioBruto < 3641.03) {
                        inss = (salarioBruto * 0.12) - 91;
                    } else if (salarioBruto < 7087.22) {
                        inss = (salarioBruto * 0.14) - 163.82;
                    } else {
                        inss = 828.39;
                    }


                    //Equa��o para determinar a base de c�lculo do IRRF
                    baseIrrf = salarioBruto - inss - (189.59 * dependentes);
                    //Estrutura para saber o valor do IRRF
                    if (baseIrrf < 1903.98) {
                        valorIrrf = 0;
                    } else if (baseIrrf < 2826.65) {
                        valorIrrf = (baseIrrf * 0.075) - 142.8;
                    } else if (baseIrrf < 3751.05) {
                        valorIrrf = (baseIrrf * 0.15) - 354.8;
                    } else if (baseIrrf < 4664.68) {
                        valorIrrf = (baseIrrf * 0.225) - 636.13;
                    } else {
                        valorIrrf = (baseIrrf * 0.275) - 869.36;
                    }


                    //Equa��o para saber o valor do s�lario l�quido
                    salarioLiquido = salarioBruto - inss - valorValeTransporte - valorValeRefeicao - valorValeAlimentacao - valorIrrf - valorPlanoSaude;
                    //Equa��o para saber a porcentagem de desconto sobre o s�lario bruto
                    porcentagemDesconto = 1 - salarioLiquido / salarioBruto;
                    porcentagemDesconto = porcentagemDesconto * 100;


                    Intent intent = new Intent(MainActivity.this, PageResultado.class);
                    intent.putExtra("salarioBruto", salarioBruto);
                    intent.putExtra("valorPlano", valorPlanoSaude);
                    intent.putExtra("valorValeAlimentacao", valorValeAlimentacao);
                    intent.putExtra("valorValeRefeicao", valorValeRefeicao);
                    intent.putExtra("valorValeTransporte", valorValeTransporte);
                    intent.putExtra("inss", inss);
                    intent.putExtra("valorIrrf", valorIrrf);
                    intent.putExtra("porcentagemDesconto", porcentagemDesconto);
                    intent.putExtra("salarioLiquido", salarioLiquido);


                    Log.i("T:", "----------------------------------------");
                    Log.i("T:", "Primeira Pagina");
                    Log.i("T:", "----------------------------------------");
                    Log.i("T:", "Salario Bruto:" + salarioBruto);
                    Log.i("T:", "valor Plano Saude:" + valorPlanoSaude);
                    Log.i("T:", "valorValeRefeicao:" + valorValeRefeicao);
                    Log.i("T:", "valorValeAlimentacao:" + valorValeAlimentacao);
                    Log.i("T:", "valorValeTransporte:" + valorValeTransporte);
                    Log.i("T:", "valorIrrf:" + valorIrrf);
                    Log.i("T:", "porcentagemDesconto:" + porcentagemDesconto);
                    Log.i("T:", "Salario Liquido:" + salarioLiquido);

                    startActivity(intent);
                    finish();

                }

            }

        });

    }


}