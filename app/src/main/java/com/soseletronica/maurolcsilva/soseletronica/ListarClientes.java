package com.soseletronica.maurolcsilva.soseletronica;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

import meuadapter.ClienteAdapter;
import modelo.Cliente;

public class ListarClientes extends Activity {
    private ListView listadeclientes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listar_clientes);
        listadeclientes = (ListView) findViewById(R.id.listClientesCadastrados);
        listadeclientes.setAdapter(retornarClienteAdapter());
    }

    public ArrayAdapter<String> retornaConteudodaLista(){
        //Criacao das variáveis que irão guardar os dados vindos do banco de dados
        String nome, email, telefone;
        //Adapter que será utilizado para carregar os dados no ListView
        ArrayAdapter<String> itensdalista;
        //Lista dos dados dos clientes
        ArrayList<String> itens = new ArrayList<String>();

        //Abertura do Banco de Dados
        SQLiteDatabase dbReparo = openOrCreateDatabase("bdreparoemcasa.db", Context.MODE_PRIVATE,null);

        //Montagem do SQL para SELECT
        String sql_select = "select * from clientes";
        //Execução da Consulta
        Cursor res = dbReparo.rawQuery(sql_select,null);
        while (res.moveToNext()){
            //1 - coluna Nome
            nome = res.getString(1);
            //2 - coluna Email
            email = res.getString(2);
            //3 - coluna Telefone
            telefone = res.getString(3);
            //Carrega os dados na Lista
            itens.add(nome + "-" + email + "-" + telefone);
        }
        //Cria o ArrayAdapter que irá mostrar os dados na ListView
        itensdalista = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,itens);
        return itensdalista;
    }
    public ClienteAdapter retornarClienteAdapter(){
        //Criacao das variáveis que irão guardar os dados vindos do banco de dados
        String nome, email, telefone;
        int idcliente;
        //Adapter que será utilizado para carregar os dados no ListView
        ClienteAdapter clienteadapter;
        //Lista dos dados dos clientes
        ArrayList<Cliente> itensclientes = new ArrayList<Cliente>();

        //Abertura do Banco de Dados
        SQLiteDatabase dbReparo = openOrCreateDatabase("bdreparoemcasa.db", Context.MODE_PRIVATE,null);

        //Montagem do SQL para SELECT
        String sql_select = "select * from clientes";
        //Execução da Consulta
        Cursor res = dbReparo.rawQuery(sql_select,null);
        while (res.moveToNext()){
            //0 - coluna de ID
            idcliente = res.getInt(0);
            //1 - coluna Nome
            nome = res.getString(1);
            //2 - coluna Email
            email = res.getString(2);
            //3 - coluna Telefone
            telefone = res.getString(3);

            Cliente c = new Cliente();
            c.setNome(nome);
            c.setEmail(email);
            c.setTelefone(telefone);
            c.setIdclientes(idcliente);
            //Carrega os dados na Lista
            itensclientes.add(c);
        }
        //Cria o ArrayAdapter que irá mostrar os dados na ListView
        clienteadapter = new ClienteAdapter(this, itensclientes);
        //itensdalista = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,itens);
        return clienteadapter;

    }
}
