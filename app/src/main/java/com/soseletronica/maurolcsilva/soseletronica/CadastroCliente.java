package com.soseletronica.maurolcsilva.soseletronica;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class CadastroCliente extends Activity implements View.OnClickListener {
    //Campos da nossa Tela
    private EditText txtnome, txtemail,txttelefone;
    private Button btnSalvar,btnListar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro_cliente);
        //Criação dos objetos no espaço do Java
        txtnome = (EditText) findViewById(R.id.txtNomeCliente);
        txtemail = (EditText) findViewById(R.id.txtEmailCliente);
        txttelefone = (EditText) findViewById(R.id.txtTelefoneCliente);
        btnSalvar = (Button) findViewById(R.id.btnSalvarCliente);
        btnListar = (Button) findViewById(R.id.btnListarCliente);
        //Registro dos Botões para o evento de Clique
        btnSalvar.setOnClickListener(this);
        btnListar.setOnClickListener(this);
    }

    public void salvarDados(){
        //Criacao das variáveis que irão guardar os dados da tela
        String nome, email, telefone;

        //Captura dos dados da Tela
        nome = txtnome.getText().toString();
        email = txtemail.getText().toString();
        telefone = txttelefone.getText().toString();

        //Abertura do Banco de Dados
        SQLiteDatabase dbReparo = openOrCreateDatabase("bdreparoemcasa.db", Context.MODE_PRIVATE,null);

        //Montagem do SQL para inserção
        String sql_insert = "insert into clientes (nome,email,telefone) values (?,?,?)";
        Object dados[] = new Object[]{nome,email,telefone};
        //Execução da Inserção
        dbReparo.execSQL(sql_insert,dados);
        //Retorno ao usuário
        Toast.makeText(this,"Dados salvos com sucesso!!!",Toast.LENGTH_SHORT).show();
    }

    public void listarDados(){
        //Criação da Intent que irá apresentar os dados ao usuário
        Intent it = new Intent(this, ListarClientes.class);
        startActivity(it);
    }

    public void limparCampos(){
        //Limpa os campos de texto
        txtnome.setText("");
        txtemail.setText("");
        txttelefone.setText("");
        //Joga o foco no campo de nome
        txtnome.requestFocus();
    }
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btnSalvarCliente:
                salvarDados();
                limparCampos();
                break;
            case R.id.btnListarCliente:
                listarDados();
                break;
        }
    }
}
