package org.example.Testes;

import org.example.Biblioteca;
import org.example.Livro;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class BibliotecaTest {

    private Biblioteca biblioteca;

    @BeforeEach
    public void setUp() {
        biblioteca = new Biblioteca("teca");
    }

    @Test
    public void testeADD(){
        Livro livro = new Livro("CTW","WEG","Terror",123);
        biblioteca.adicionarLivro(livro);
        Assertions.assertEquals(1 ,biblioteca.getQuantidadeLivros());
    }

    //Buscar por titulo
    @Test
    public void testeBuscarTitulo(){
        Livro livro = new Livro("CTW","WEG","Terror",123);
        biblioteca.adicionarLivro(livro);
        Assertions.assertEquals(livro,biblioteca.buscarLivroPorTitulo("CTW"));
    }

    @Test
    public void testeBuscarTitulo2(){
        Livro livro = new Livro("CTW","WEG","Terror",123);
        biblioteca.adicionarLivro(livro);
        Assertions.assertEquals(livro,biblioteca.buscarLivroPorTitulo("CTW2"));
    }

    @Test
    public void testeBuscarAutor(){
        Livro livro = new Livro("CTW","WEG","Terror",123);
        Livro livro2 = new Livro("CTW2","WEG","Terror",123);
        biblioteca.adicionarLivro(livro);
        biblioteca.adicionarLivro(livro2);
        Assertions.assertEquals(2,biblioteca.buscarLivrosPorAutor("WEG").size());
    }

    @Test
    public void testeBuscarGenero(){
        Livro livro = new Livro("CTW","WEG","Terror",123);
        biblioteca.adicionarLivro(livro);Assertions.assertEquals(1,biblioteca.buscarLivrosPorGenero("Terror").size());
    }

    @Test
    public void testeRemover(){
        Livro livro = new Livro("CTW","WEG","Terror",123);
        biblioteca.adicionarLivro(livro);
        biblioteca.removerLivro(livro);
        Assertions.assertEquals(0,biblioteca.getQuantidadeLivros());
    }


}
