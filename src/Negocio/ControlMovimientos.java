package Negocio;

import Modelo.Movimiento;

import java.util.ArrayList;
import java.util.Date;

public class ControlMovimientos {

    public ArrayList<Movimiento> _movimientos = new ArrayList<>();

    public ControlMovimientos() {
    }

    public ControlMovimientos(ArrayList<Movimiento> _movimientos) {
        this._movimientos = _movimientos;
    }

    public ArrayList<Movimiento> verIngresos(Date fechaInicio, Date fechaFin){
        ArrayList<Movimiento> aux = new ArrayList<>();

        for (Movimiento movimiento: _movimientos){
            if (movimiento.getFecha().compareTo(fechaInicio) > 0
                    && movimiento.getFecha().compareTo(fechaFin) < 0
                    && movimiento.getTipoMovimientos().getId() == 1){
                aux.add(movimiento);
            }
        }

        return aux;
    }

    public ArrayList<Movimiento> verIngresosSubTipo(String subTipo){
        ArrayList<Movimiento> auxSub = new ArrayList<>();

        for (Movimiento movimiento: _movimientos){
            if (movimiento.getSubTipoMovimiento().getDescripcion() == subTipo){
                auxSub.add(movimiento);
            }
        }

        return auxSub;
    }

}
