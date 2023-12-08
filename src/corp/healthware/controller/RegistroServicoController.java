/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package corp.healthware.controller;


import corp.healthware.model.dao.DAOexception;
import corp.healthware.model.entity.RegistroServico;
import java.sql.SQLException;
import java.util.ArrayList;
/**
 *
 * @author dilce
 */
public class RegistroServicoController {
    public int insert(int codigo, String nome_cliente, String data, String hora) throws DAOexception, SQLException {
        if (nome_cliente != null) {
            RegistroServico registroservico = new RegistroServico(codigo, nome_cliente, data, hora);
            return registroservico.cadastrarRegistroServico(registroservico);
        }
        return 0;
    }

    public int update(int cod, String data, String hora, String nome_cliente) throws DAOexception, SQLException {
        if (cod != -1 && data != null && hora != null && nome_cliente != null) {
            RegistroServico registroservico = new RegistroServico(cod, data, hora, nome_cliente);
            return registroservico.updateRegistroServico(registroservico);
        }
        return 0;
    }

    public int delete(int cod_s, String data, String hora) throws DAOexception, SQLException {
        if (cod_s != -1 && data != null && hora != null) {
            RegistroServico func = new RegistroServico(cod_s, data, hora);
            return func.excluirRegistroServico(func);
        }
        return 0;
    }

    public ArrayList<RegistroServico> findAll() throws DAOexception, SQLException {
        return new RegistroServico().findAllRegistroServico();
    }
    
    public ArrayList<RegistroServico> findAll(int cod) throws DAOexception, SQLException {
        RegistroServico reg = new RegistroServico(cod);
        return new RegistroServico().findAllRegistroServico(reg);
    }
    
    public RegistroServico findOne(int cod) throws DAOexception, SQLException {
        RegistroServico registroservico = new RegistroServico(cod);
        return registroservico.findOneServico(registroservico);
    }

    public ArrayList<RegistroServico> search(String pesquisa) throws SQLException, DAOexception {
        return new RegistroServico().searchRegistroServico(pesquisa);
    }

    
}
