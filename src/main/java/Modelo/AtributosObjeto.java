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
public enum AtributosObjeto {
        nombreObjeto("Nombre Objeto"),
        formaAdquisicion("Forma Adquisición"),
        fechaIngreso("Fecha Ingreso"),
        numRegistro("Número Registro"),
        valorEconomico("Valor Económico"),
        nombreFuente("Nombre Fuente"),
        fechaInventario("Fecha Inventario"),
        numInventario("Número Inventario"),
        otrosNumeros("Otros Números"),
        direccionFuente("Dirección Fuente"),
        fechaCatalogo("Fecha Catálogo"),
        numCatalogo("Número Catálogo"),
        espesor("Espesor"),
        alto("Alto"),
        ancho("Ancho"),
        largo("Largo"),
        diametro("Diámetro"),
        peso("Peso"),
        procedencia("Procedencia"),
        materiaYTecnica("Materia y Técnica"),
        numeroNegativo("Número Negativo"),
        autor("Autor"),
        epoca("Época"),
        descripcion("Descripción"),
        documentacion("Documentación"),
        observaciones("Observaciones"),
        recibio("Recibió"),
        inventario("Inventarió"),
        catalogo("Catalogó"),
        aprobo("Aprobó");
        
        private final String displayName;

        AtributosObjeto(String displayName) {
            this.displayName = displayName;
        }

        public String getDisplayName() {
            return displayName;
        }
}
