package com.vaporwarecorp.rest.server;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class ElementoQuimico
{
// ------------------------------ FIELDS ------------------------------

    private String nombre;

    private int numeroAtomico;

    private String simbolo;

// --------------------- GETTER / SETTER METHODS ---------------------

    public ElementoQuimico()
    {

    }

    public String getNombre()
    {
        return nombre;
    }

    public void setNombre( String nombre )
    {
        this.nombre = nombre;
    }

    public int getNumeroAtomico()
    {
        return numeroAtomico;
    }

    public void setNumeroAtomico( int numeroAtomico )
    {
        this.numeroAtomico = numeroAtomico;
    }

    public String getSimbolo()
    {
        return simbolo;
    }

    public void setSimbolo( String simbolo )
    {
        this.simbolo = simbolo;
    }
}
