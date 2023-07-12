package tienda;

import java.io.Serializable;

public class Traje implements Serializable{
    private String nombre;
    private String paisFabricacion;
    private String material;
    private int precio;

    Traje(String nom, String pai, String mate,int prec){
        nombre = nom;
        paisFabricacion = pai;
        material = mate;
        precio = prec;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setPaisFabricacion(String paisFabricacion) {
        this.paisFabricacion = paisFabricacion;
    }

    public String getPaisFabricacion() {
        return paisFabricacion;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public String getMaterial() {
        return material;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public int getPrecio() {
        return precio;
    }
}
