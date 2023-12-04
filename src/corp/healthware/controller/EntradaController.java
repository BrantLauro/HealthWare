/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package corp.healthware.controller;

import corp.healthware.model.dao.DAOexception;
import corp.healthware.model.entity.Entrada;
import java.sql.SQLException;
import java.util.ArrayList;
/**
 *
 * @author dilce
 */
public class EntradaController {
    public int insert(String data_ent, double valor_ent, String motivo_ent, int resp_ent) throws DAOexception, SQLException {
        if (data_ent != null && valor_ent != null && motivo_ent != null && resp_ent){
            Entrada entrada = new Entrada(data_ent, valor_ent, motivo_ent, resp_ent);
            return entrada.cadastrarEntrada(entrada);
        }
        return 0;
    }

    public int update(String data_ent, double valor_ent, String motivo_ent, int resp_ent) throws DAOexception, SQLException {
        if (data_ent != null && valor_ent != null && motivo_ent != null && resp_ent) {
            Entrada entrada = new Entrada(data_ent, valor_ent, motivo_ent, resp_ent);
            return entrada.updateEntrada(entrada);
        }
        return 0;
    }

    public int delete(int cod_ent) throws DAOexception, SQLException {
        if (cod_ent != -1) {
            Entrada func = new Entrada(cod_ent);
            return func.excluirEntrada(func);
        }
        return 0;
    }

    public ArrayList<Entrada> findAll() throws DAOexception, SQLException {
        return new Entrada().findAllEntrada();
    }
}
