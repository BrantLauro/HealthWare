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
    public int insert(String nome_cliente) throws DAOexception, SQLException {
        if (nome_cliente != null) {
            RegistroServico registroservico = new RegistroServico(nome_cliente);
            return registroservico.cadastrarRegistroServico(registroservico);
        }
        return 0;
    }

    public int update(String nome_cliente) throws DAOexception, SQLException {
        if (nome_cliente != null) {
            RegistroServico registroservico = new RegistroServico(nome_cliente);
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
    
    public RegistroServico findOne(int cod_s) throws DAOexception, SQLException {
        RegistroServico registroservico = new RegistroServico(cod_s);
        return registroservico.findOneServico(registroservico);
    }
    
}