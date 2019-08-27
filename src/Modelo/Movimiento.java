package Modelo;

import java.util.Date;

public class Movimiento {

    //Cuando hice el gasto
    private Date fecha;
    //Cuanto gasta
    private float monto;
    //algun dato que me ayude a entender el gasto
    private String descripcion;
    //identificar que tipo de movimiento
    //ingreso - egresos
    private TipoMovimiento tipoMovimientos;
    //donde compre o vendi
    //(ejemplo: carniceria - verduleria)
    private SubTipoMovimiento subTipoMovimiento;
    //historial de la cotizacion
    private float cotizacion;
    //tipo de moneda con la que cobre/vendi algo
    private Moneda moneda;
    //forma de pago
    private TipoPago tipoPago;
    //cuando se vence la deuda
    private Date fechaVencimiento;
    private Proveedor proveedor;
    private Cliente cliente;

    public Movimiento() {
    }

    public Movimiento(Date fecha, float monto, String descripcion, TipoMovimiento tipoMovimientos,
                      SubTipoMovimiento subTipoMovimiento, float cotizacion, Moneda moneda, TipoPago tipoPago,
                      Date fechaVencimiento, Proveedor proveedor, Cliente cliente) {
        this.fecha = fecha;
        this.monto = monto;
        this.descripcion = descripcion;
        this.tipoMovimientos = tipoMovimientos;
        this.subTipoMovimiento = subTipoMovimiento;
        this.cotizacion = cotizacion;
        this.moneda = moneda;
        this.tipoPago = tipoPago;
        this.fechaVencimiento = fechaVencimiento;
        this.proveedor = proveedor;
        this.cliente = cliente;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public float getMonto() {
        return monto;
    }

    public void setMonto(float monto) {
        this.monto = monto;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public TipoMovimiento getTipoMovimientos() {
        return tipoMovimientos;
    }

    public void setTipoMovimientos(TipoMovimiento tipoMovimientos) {
        this.tipoMovimientos = tipoMovimientos;
    }

    public SubTipoMovimiento getSubTipoMovimiento() {
        return subTipoMovimiento;
    }

    public void setSubTipoMovimiento(SubTipoMovimiento subTipoMovimiento) {
        this.subTipoMovimiento = subTipoMovimiento;
    }

    public float getCotizacion() {
        return cotizacion;
    }

    public void setCotizacion(float cotizacion) {
        this.cotizacion = cotizacion;
    }

    public Moneda getMoneda() {
        return moneda;
    }

    public void setMoneda(Moneda moneda) {
        this.moneda = moneda;
    }



    public TipoPago getTipoPago() {
        return tipoPago;
    }

    public void setTipoPago(TipoPago tipoPago) {
        this.tipoPago = tipoPago;
    }

    public Date getFechaVencimiento() {
        return fechaVencimiento;
    }

    public void setFechaVencimiento(Date fechaVencimiento) {
        this.fechaVencimiento = fechaVencimiento;
    }

    public Proveedor getProveedor() {
        return proveedor;
    }

    public void setProveedor(Proveedor proveedor) {
        this.proveedor = proveedor;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    @Override
    public String toString() {
        return "Movimiento{" +
                "fecha=" + this.fecha +
                ", monto=" + this.monto +
                ", descripcion='" + this.descripcion + '\'' +
                ", tipoMovimiento=" + this.tipoMovimientos +
                ", SubTipoMovimiento=" + this.subTipoMovimiento +
                ", cotizacion=" + this.cotizacion +
                ", moneda=" + this.moneda +
                ", tipoPago=" + this.tipoPago +
                ", fechaVencimiento=" + this.fechaVencimiento +
                ", proveedor" + this.proveedor +
                ", cliente" + this.cliente +
                '}';
    }
}
