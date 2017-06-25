package modelo;

/**
 * Created by maurolcsilva on 22/06/2017.
 */

public class Cliente {
    private int idclientes;
    private String nome;
    private String email;
    private String telefone;

    public void setIdclientes(int idclientes) {
        this.idclientes = idclientes;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public int getIdclientes() {
        return idclientes;
    }

    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }

    public String getTelefone() {
        return telefone;
    }
}
