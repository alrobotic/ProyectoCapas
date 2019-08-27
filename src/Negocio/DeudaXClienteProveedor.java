package Negocio;

import Modelo.Cliente;
import Modelo.Proveedor;
import Modelo.TipoMovimiento;

public class DeudaXClienteProveedor {
    private Cliente _cliente;
    private Proveedor _proveedor;
    private TipoMovimiento tipoMovimiento;
    private float deuda;

    public DeudaXClienteProveedor(){}

    public DeudaXClienteProveedor(Cliente _cliente, Proveedor _proveedor, TipoMovimiento tipoMovimiento, float deuda) {
        this._cliente = _cliente;
        this._proveedor = _proveedor;
        this.tipoMovimiento = tipoMovimiento;
        this.deuda = deuda;
    }

    public Cliente get_cliente() {
        return _cliente;
    }

    public void set_cliente(Cliente _cliente) {
        this._cliente = _cliente;
    }

    public Proveedor get_proveedor() {
        return _proveedor;
    }

    public void set_proveedor(Proveedor _proveedor) {
        this._proveedor = _proveedor;
    }

    public TipoMovimiento getTipoMovimiento() {
        return tipoMovimiento;
    }

    public void setTipoMovimiento(TipoMovimiento tipoMovimiento) {
        this.tipoMovimiento = tipoMovimiento;
    }

    public float getDeuda() {
        return deuda;
    }

    public void setDeuda(float deuda) {
        this.deuda = deuda;
    }

    @Override
    public String toString() {
        return "DeudaXClienteProveedor{" +
                "_cliente=" + _cliente +
                ", _proveedor=" + _proveedor +
                ", tipoMovimiento=" + tipoMovimiento +
                ", deuda=" + deuda +
                '}';
    }
}
