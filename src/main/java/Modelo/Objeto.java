/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *
 * @author sescalo
 */
public class Objeto {
    
    private int idObjeto;
    private String nombreObjeto;
    private String formaAdquisicion;
    private String fechaIngreso;
    private String numRegistro;
    private float valorEconomico;
    private String nombreFuente;
    private String fechaInventario;
    private String numInventario;
    private String otrosNumeros;
    private String direccionFuente;
    private String fechaCatalogo;
    private String numCatalogo;
    private String espesor;
    private float alto;
    private float ancho;
    private float largo;
    private float diametro;
    private float peso;
    private String procedencia;
    private String materiaYTecnica;
    private String numeroNegativo;
    private String autor;
    private int epoca;
    private String descripcion;
    private String documentacion;
    private String observaciones;
    private String recibio;
    private String inventario;
    private String catalogo;
    private String aprobo;

    public Objeto(int idObjeto, String nombreObjeto, String formaAdquisicion, String fechaIngreso, String numRegistro, float valorEconomico, String nombreFuente, String fechaInventario, String numInventario, String otrosNumeros, String direccionFuente, String fechaCatalogo, String numCatalogo, String espesor, float alto, float ancho, float largo, float diametro, float peso, String procedencia, String materiaYTecnica, String numeroNegativo, String autor, int epoca, String descripcion, String documentacion, String observaciones, String recibio, String inventario, String catalogo, String aprobo) {
        this.idObjeto = idObjeto;
        this.nombreObjeto = nombreObjeto;
        this.formaAdquisicion = formaAdquisicion;
        this.fechaIngreso = fechaIngreso;
        this.numRegistro = numRegistro;
        this.valorEconomico = valorEconomico;
        this.nombreFuente = nombreFuente;
        this.fechaInventario = fechaInventario;
        this.numInventario = numInventario;
        this.otrosNumeros = otrosNumeros;
        this.direccionFuente = direccionFuente;
        this.fechaCatalogo = fechaCatalogo;
        this.numCatalogo = numCatalogo;
        this.espesor = espesor;
        this.alto = alto;
        this.ancho = ancho;
        this.largo = largo;
        this.diametro = diametro;
        this.peso = peso;
        this.procedencia = procedencia;
        this.materiaYTecnica = materiaYTecnica;
        this.numeroNegativo = numeroNegativo;
        this.autor = autor;
        this.epoca = epoca;
        this.descripcion = descripcion;
        this.documentacion = documentacion;
        this.observaciones = observaciones;
        this.recibio = recibio;
        this.inventario = inventario;
        this.catalogo = catalogo;
        this.aprobo = aprobo;
    }

    public int getIdObjeto() {
        return idObjeto;
    }

    public void setIdObjeto(int idObjeto) {
        this.idObjeto = idObjeto;
    }

    public String getNombreObjeto() {
        return nombreObjeto;
    }

    public void setNombreObjeto(String nombreObjeto) {
        this.nombreObjeto = nombreObjeto;
    }

    public String getFormaAdquisicion() {
        return formaAdquisicion;
    }

    public void setFormaAdquisicion(String formaAdquisicion) {
        this.formaAdquisicion = formaAdquisicion;
    }

    public String getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(String fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    public String getNumRegistro() {
        return numRegistro;
    }

    public void setNumRegistro(String numRegistro) {
        this.numRegistro = numRegistro;
    }

    public float getValorEconomico() {
        return valorEconomico;
    }

    public void setValorEconomico(float valorEconomico) {
        this.valorEconomico = valorEconomico;
    }

    public String getNombreFuente() {
        return nombreFuente;
    }

    public void setNombreFuente(String nombreFuente) {
        this.nombreFuente = nombreFuente;
    }

    public String getFechaInventario() {
        return fechaInventario;
    }

    public void setFechaInventario(String fechaInventario) {
        this.fechaInventario = fechaInventario;
    }

    public String getNumInventario() {
        return numInventario;
    }

    public void setNumInventario(String numInventario) {
        this.numInventario = numInventario;
    }

    public String getOtrosNumeros() {
        return otrosNumeros;
    }

    public void setOtrosNumeros(String otrosNumeros) {
        this.otrosNumeros = otrosNumeros;
    }

    public String getDireccionFuente() {
        return direccionFuente;
    }

    public void setDireccionFuente(String direccionFuente) {
        this.direccionFuente = direccionFuente;
    }

    public String getFechaCatalogo() {
        return fechaCatalogo;
    }

    public void setFechaCatalogo(String fechaCatalogo) {
        this.fechaCatalogo = fechaCatalogo;
    }

    public String getNumCatalogo() {
        return numCatalogo;
    }

    public void setNumCatalogo(String numCatalogo) {
        this.numCatalogo = numCatalogo;
    }

    public String getEspesor() {
        return espesor;
    }

    public void setEspesor(String espesor) {
        this.espesor = espesor;
    }

    public float getAlto() {
        return alto;
    }

    public void setAlto(float alto) {
        this.alto = alto;
    }

    public float getAncho() {
        return ancho;
    }

    public void setAncho(float ancho) {
        this.ancho = ancho;
    }

    public float getLargo() {
        return largo;
    }

    public void setLargo(float largo) {
        this.largo = largo;
    }

    public float getDiametro() {
        return diametro;
    }

    public void setDiametro(float diametro) {
        this.diametro = diametro;
    }

    public float getPeso() {
        return peso;
    }

    public void setPeso(float peso) {
        this.peso = peso;
    }

    public String getProcedencia() {
        return procedencia;
    }

    public void setProcedencia(String procedencia) {
        this.procedencia = procedencia;
    }

    public String getMateriaYTecnica() {
        return materiaYTecnica;
    }

    public void setMateriaYTecnica(String materiaYTecnica) {
        this.materiaYTecnica = materiaYTecnica;
    }

    public String getNumeroNegativo() {
        return numeroNegativo;
    }

    public void setNumeroNegativo(String numeroNegativo) {
        this.numeroNegativo = numeroNegativo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public int getEpoca() {
        return epoca;
    }

    public void setEpoca(int epoca) {
        this.epoca = epoca;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getDocumentacion() {
        return documentacion;
    }

    public void setDocumentacion(String documentacion) {
        this.documentacion = documentacion;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public String getRecibio() {
        return recibio;
    }

    public void setRecibio(String recibio) {
        this.recibio = recibio;
    }

    public String getInventario() {
        return inventario;
    }

    public void setInventario(String inventario) {
        this.inventario = inventario;
    }

    public String getCatalogo() {
        return catalogo;
    }

    public void setCatalogo(String catalogo) {
        this.catalogo = catalogo;
    }

    public String getAprobo() {
        return aprobo;
    }

    public void setAprobo(String aprobo) {
        this.aprobo = aprobo;
    }   
}