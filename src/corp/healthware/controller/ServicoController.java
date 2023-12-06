/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package corp.healthware.controller;

import corp.healthware.model.dao.DAOexception;
import corp.healthware.model.entity.Servico;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author dilce
 */
public class ServicoController {
    public int insert(String nome_s, double preco, int resp) throws DAOexception, SQLException {
        if(nome_s != null && preco != -1 && resp != -1) {
            Servico servico = new Servico(nome_s, preco, resp);
            return servico.cadastrarServico(servico);
        }
        return 0;
    }

    public int update(String nome_s, double preco, int resp) throws DAOexception, SQLException {
        if(nome_s != null && preco != -1 && resp != -1) {
            Servico servico = new Servico(nome_s, preco, resp);
            return servico.updateServico(servico);
        }
        return 0;
    }

    public int delete(int cod_s) throws DAOexception, SQLException {
        if (cod_s != -1) {
            Servico func = new Servico(cod_s);
            return func.excluirServico(func);
        }
        return 0;
    }

    public ArrayList<Servico> findAll() throws DAOexception, SQLException {
        return new Servico().findAllServico();
    }
    
    public Servico findOne(int cod_s) throws DAOexception, SQLException {
        Servico servico = new Servico(cod_s);
        return servico.findOneServico(servico);
    }
    
    public ArrayList<Servico> search(String servico) throws DAOexception, SQLException{
        return new Servico().searchServico(servico);
    }
}
