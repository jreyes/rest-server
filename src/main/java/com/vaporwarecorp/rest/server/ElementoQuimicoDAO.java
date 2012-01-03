package com.vaporwarecorp.rest.server;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ElementoQuimicoDAO
{
// -------------------------- OTHER METHODS --------------------------

    public List<ElementoQuimico> encontrarTodos()
    {
        List<ElementoQuimico> lista = new ArrayList<ElementoQuimico>();

        Connection c = null;
        String sql = "SELECT * FROM elemento_quimicos ORDER BY numero_atomico";

        try
        {
            c = ConnectionHelper.getConnection();
            Statement s = c.createStatement();
            ResultSet rs = s.executeQuery( sql );
            while ( rs.next() )
            {
                lista.add( procesarElemento( rs ) );
            }
        }
        catch ( SQLException e )
        {
            e.printStackTrace();
            throw new RuntimeException( e );
        }
        finally
        {
            ConnectionHelper.close( c );
        }

        return lista;
    }

    public ElementoQuimico encontratPorNumeroAtomico( int numeroAtomico )
    {
        ElementoQuimico elemento = null;

        Connection c = null;
        String sql = "SELECT * FROM elemento_quimicos WHERE numero_atomico=?";

        try
        {
            c = ConnectionHelper.getConnection();
            PreparedStatement ps = c.prepareStatement( sql );
            ps.setInt( 1, numeroAtomico );
            ResultSet rs = ps.executeQuery();
            if ( rs.next() )
            {
                elemento = procesarElemento( rs );
            }
        }
        catch ( Exception e )
        {
            e.printStackTrace();
            throw new RuntimeException( e );
        }
        finally
        {
            ConnectionHelper.close( c );
        }
        return elemento;
    }

    private ElementoQuimico procesarElemento( ResultSet rs )
        throws SQLException
    {
        ElementoQuimico elemento = new ElementoQuimico();
        elemento.setNumeroAtomico( rs.getInt( "numero_atomico" ) );
        elemento.setNombre( rs.getString( "nombre" ) );
        elemento.setSimbolo( rs.getString( "simbolo" ) );
        return elemento;
    }
}
