/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package corp.healthware.controller;

import corp.healthware.model.dao.DAOexception;
import corp.healthware.model.entity.Saida;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author dilce
 */
public class SaidaController {
    public int insert(String data_saida, double valor_saida, String motivo_saida, int resp_saida) throws DAOexception, SQLException {
        if (data_saida != null && valor_saida != -1 && motivo_saida != null && resp_saida != -1){
            Saida saida = new Saida(data_saida, valor_saida, motivo_saida, resp_saida);
            return saida.cadastrarSaida(saida);
        }
        return 0;
    }

    public int update(String data_saida, double valor_saida, String motivo_saida, int resp_saida) throws DAOexception, SQLException {
        if (data_saida != null && valor_saida != -1 && motivo_saida != null && resp_saida != -1) {
            Saida saida = new Saida(data_saida, valor_saida, motivo_saida, resp_saida);
            return saida.updateSaida(saida);
        }
        return 0;
    }

    public int delete(int cod_saida) throws DAOexception, SQLException {
        if (cod_saida != -1) {
            Saida func = new Saida(cod_saida);
            return func.excluirSaida(func);
        }
        return 0;
    }

    public ArrayList<Saida> findAll() throws DAOexception, SQLException {
        return new Saida().findAllSaida();
    }
}
