package Negocio;

import Modelo.Movimiento;

import java.util.ArrayList;
import java.util.Date;

public class ControlMovimientos {

    private ArrayList<Movimiento> _movimientos = new ArrayList<>();
    private ArrayList<DeudaXClienteProveedor> _movimientoAcreedor = new ArrayList<>();

    public ControlMovimientos() {
    }

    public ControlMovimientos(ArrayList<Movimiento> _movimientos) {
        this._movimientos = _movimientos;
    }

    public ArrayList<Movimiento> verIngresos(Date fechaInicio, Date fechaFin) {
        ArrayList<Movimiento> aux = new ArrayList<>();

        for (Movimiento movimiento : _movimientos) {
            if (movimiento.getFecha().compareTo(fechaInicio) > 0
                    && movimiento.getFecha().compareTo(fechaFin) < 0
                    && movimiento.getTipoMovimientos().getId() == 1) {
                aux.add(movimiento);
            }
        }

        return aux;
    }

    public ArrayList<Movimiento> verEgresos(Date fechaInicio, Date fechaFin) {
        ArrayList<Movimiento> aux = new ArrayList<>();

        for (Movimiento movimiento : _movimientos) {
            if (movimiento.getFecha().compareTo(fechaInicio) > 0
                    && movimiento.getFecha().compareTo(fechaFin) < 0
                    && movimiento.getTipoMovimientos().getId() == 2) {
                aux.add(movimiento);
            }
        }

        return aux;
    }

    public float verEgresosSubTipo(Date fechaInicio, Date fechaFin, int subTipo) {
        ArrayList<Movimiento> auxSub = new ArrayList<>();
        float monto = 0;
        for (Movimiento movimiento : _movimientos) {
            if (movimiento.getFecha().compareTo(fechaInicio) > 0
                    && movimiento.getFecha().compareTo(fechaFin) < 0
                    && movimiento.getSubTipoMovimiento().getId() == subTipo
                    && movimiento.getTipoMovimientos().getId() == 2) {
                monto = monto + movimiento.getMonto();
            }
        }

        return monto;
    }

    public float porcentajeAhorro (Date fechaInicio, Date fechaFin){
        float porcentaje = 0;
        float egresos = 0;
        float ingresos = 0;

        for (Movimiento movimiento: _movimientos){
            if (movimiento.getTipoMovimientos().getId() == 1){
                ingresos = ingresos + movimiento.getMonto();
            }

            if (movimiento.getTipoMovimientos().getId() == 2){
                egresos = egresos + movimiento.getMonto();
            }

        }

       return  porcentaje = (ingresos - egresos)/100;

    }

    public ArrayList<Movimiento> historialMovimientoXClienteProveedor(Date fechaInicio, Date fechaFin, int id) {
        ArrayList<Movimiento> aux = new ArrayList<>();

        for (Movimiento movimiento : _movimientos) {
            if (movimiento.getFecha().compareTo(fechaInicio) > 0
                && movimiento.getFecha().compareTo(fechaFin) < 0) {
                if (movimiento.getCliente() != null
                        && movimiento.getCliente().getId() == id ) {
                    Movimiento movCliente = new Movimiento();
                    movCliente.setFecha(movimiento.getFecha());
                    movCliente.setDescripcion(movimiento.getDescripcion());
                    movCliente.setMonto(movimiento.getMonto());
                    movCliente.setTipoMovimientos(movimiento.getTipoMovimientos());
                    aux.add(movCliente);
                }else if (movimiento.getProveedor() != null
                            && movimiento.getProveedor().getId() == id){
                    Movimiento movProveedor = new Movimiento();
                    movProveedor.setFecha(movimiento.getFecha());
                    movProveedor.setDescripcion(movimiento.getDescripcion());
                    movProveedor.setMonto(movimiento.getMonto());
                    movProveedor.setTipoMovimientos(movimiento.getTipoMovimientos());
                    aux.add(movProveedor);
                }
            }
        }
        return aux;
    }

    public ArrayList<DeudaXClienteProveedor> deudaxAcreedorMovimientos(Date fechaInicio, Date fechaFin) {
        ArrayList<DeudaXClienteProveedor> auxDeuda = new ArrayList<>();

        for (Movimiento movimiento : _movimientos) {
            if (movimiento.getFecha().compareTo(fechaInicio) > 0
                    && movimiento.getFecha().compareTo(fechaFin) < 0) {
                if (movimiento.getCliente() != null) {
                    DeudaXClienteProveedor _deudaCliente = new DeudaXClienteProveedor(movimiento.getCliente(), null, movimiento.getTipoMovimientos(), movimiento.getMonto());
                    auxDeuda.add(_deudaCliente);
                }
                if (movimiento.getProveedor() != null) {
                    DeudaXClienteProveedor _deudaProveedor = new DeudaXClienteProveedor(null, movimiento.getProveedor(), movimiento.getTipoMovimientos(), movimiento.getMonto());
                    auxDeuda.add(_deudaProveedor);
                }
            }
        }

        return auxDeuda;
    }

    public ArrayList<DeudaXClienteProveedor> deudaXAcreedor(Date fechaInicio, Date fechaFin) {
        ArrayList<DeudaXClienteProveedor> aux = this.deudaxAcreedorMovimientos(fechaInicio, fechaFin);
        ArrayList<DeudaXClienteProveedor> deudaFinal = new ArrayList<>();
        ArrayList<DeudaXClienteProveedor> _deudaParcial = new ArrayList<>();

        for (int i = 0; i < aux.size(); i++) {
            if (aux.get(i).get_cliente() != null) {
                float monto = 0;
                for (int j = 0; j < aux.size(); j++) {
                    if (aux.get(i).get_cliente().getId() == aux.get(j).get_cliente().getId() && i != j) {
                        if (aux.get(j).getTipoMovimiento().getId() == 1) {
                            monto = monto - aux.get(j).getDeuda();
                        } else {
                            monto = monto + aux.get(j).getDeuda();
                        }
                    }
                }
                _deudaParcial.add(new DeudaXClienteProveedor(aux.get(i).get_cliente(),
                        null, aux.get(i).getTipoMovimiento(), monto));
            }
            if (aux.get(i).get_proveedor() != null) {
                float monto = 0;
                for (int j = 0; j < aux.size(); j++) {
                    if (aux.get(i).get_proveedor().getId() == aux.get(j).get_proveedor().getId() && i != j) {
                        if (aux.get(j).getTipoMovimiento().getId() == 1) {
                            monto = monto + aux.get(j).getDeuda();
                        } else {
                            monto = monto - aux.get(j).getDeuda();
                        }
                    }
                }
                _deudaParcial.add(new DeudaXClienteProveedor(null, aux.get(i).get_proveedor(),
                        aux.get(i).getTipoMovimiento(), monto));
            }

        }
        return deudaFinal = _deudaParcial;
    }

}