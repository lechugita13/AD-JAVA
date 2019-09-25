/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package serializarficheros;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;

/**
 *
 * @author vesprada
 */
public class Append extends ObjectOutputStream {

    public Append(OutputStream out) throws IOException {
        super(out);
    }
  
    @Override
    protected void writeStreamHeader() throws IOException {
// No hacer nada.
    }

}
