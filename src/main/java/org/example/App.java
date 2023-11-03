package org.example;

import org.example.controller.ProdottoController;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        ProdottoController utenteController = new ProdottoController();
        utenteController.startServices();
    }
}
