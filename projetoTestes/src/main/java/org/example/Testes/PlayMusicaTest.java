package org.example.Testes;

import org.example.Biblioteca;
import org.example.Livro;
import org.example.Musica;
import org.example.PlaylistMusica;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class PlayMusicaTest {

    private PlaylistMusica playlistMusica;

    @BeforeEach
    public void setUp() {
        playlistMusica = new PlaylistMusica("playlist");
    }

    @Test
    public void testeADD(){
        Musica musica = new Musica("memories","conan",12);
        playlistMusica.adicionarMusica(musica);
        Assertions.assertEquals(1,playlistMusica.getQuantidadeMusicas());
    }

    @Test
    public void testeRemover(){
        Musica musica = new Musica("memories","conan",12);
        playlistMusica.adicionarMusica(musica);
        playlistMusica.removerMusica(musica);
        Assertions.assertEquals(0,playlistMusica.getQuantidadeMusicas());
    }

    @Test
    public void testeBuscarTitulo(){
        Musica musica = new Musica("memories","conan",12);
        playlistMusica.adicionarMusica(musica);
        Assertions.assertEquals(musica,playlistMusica.buscarMusicaPorTitulo("memories"));
    }

    @Test
    public void testeBuscarArtista(){
        Musica musica = new Musica("memories","conan",123);
        Musica musica2 = new Musica("Maniac","conan",123);
        playlistMusica.adicionarMusica(musica);
        playlistMusica.adicionarMusica(musica2);
        Assertions.assertEquals(2,playlistMusica.buscarMusicasPorArtista("conan").size());
    }

    @Test
    public void getMusicarTest(){
        Musica musica = new Musica("memories","conan",123);
        playlistMusica.adicionarMusica(musica);
        Assertions.assertEquals(1,playlistMusica.getMusicas().size());
    }

    @Test
    public void getNomeTest(){
        Assertions.assertEquals("teca",playlistMusica.getNome());
    }

    @Test
    public void ordenarArtistaTest(){
        Musica musica = new Musica("memories","conan",123);
        Musica musica2 = new Musica("memories","Maron5",123);
        playlistMusica.adicionarMusica(musica);
        playlistMusica.adicionarMusica(musica2);
        playlistMusica.ordenarPorArtista();
        Assertions.assertEquals(musica2,playlistMusica.getMusicas().get(0));
    }

//    @Test
//    public void ordenarTituloTest(){
//        Musica musica = new Musica("memories","conan",123);
//        Musica musica2 = new Musica("memories","Maron5",123);
//        playlistMusica.adicionarMusica(musica);
//        playlistMusica.adicionarMusica(musica2);
//        playlistMusica.ordenarPorTitulo();
//        Assertions.assertEquals(musica2,playlistMusica.getNome());
//    }

    @Test
    public void setNome(){

    }

}
