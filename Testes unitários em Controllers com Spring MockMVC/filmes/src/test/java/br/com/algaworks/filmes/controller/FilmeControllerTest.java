/* 
 * 
 * Link da aula: https://www.youtube.com/watch?v=ngbKmhXDP4A&t=1814s
 * @author: AlgaWorks
 * 
*/
package br.com.algaworks.filmes.controller;

import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.apache.http.HttpStatus;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import br.com.algaworks.filmes.model.Filme;
import br.com.algaworks.filmes.service.FilmeService;
import io.restassured.http.ContentType;
import io.restassured.module.mockmvc.RestAssuredMockMvc;

import static io.restassured.module.mockmvc.RestAssuredMockMvc.*;

@WebMvcTest
public class FilmeControllerTest {

    @Autowired
    private FilmeController filmeController;

    @MockBean
    private FilmeService filmeService;

    @BeforeEach
    public void setup() {

        RestAssuredMockMvc.standaloneSetup(this.filmeController);
    }

    @Test
    public void deveRetornarSucesso_QuandoBuscarFilme() {

        when(this.filmeService.obterFilme(1L))
            .thenReturn(new Filme(1L, "O Poderoso Chefão", "Sem descrição"));

        given()
            .accept(ContentType.JSON)
            .when()
            .get("/filmes/{codigo}", 1L)
            .then().statusCode(HttpStatus.SC_OK);
    }

    @Test
    public void deveRetornarNaoEncontrado_QuandoBuscarFilme() {

        when(this.filmeService.obterFilme(101L))
            .thenReturn(null);

        given()
            .accept(ContentType.JSON)
            .when()
            .get("/filmes/{codigo}", 101L)
            .then().statusCode(HttpStatus.SC_NOT_FOUND);
    }

    @Test
    public void deveRetornarBadRequest_QuandoBuscarFilme() {

        given()
            .accept(ContentType.JSON)
            .when()
            .get("/filmes/{codigo}", -1L)
            .then()
            .statusCode(HttpStatus.SC_BAD_REQUEST);

        verify(this.filmeService, never()).obterFilme(-1L);
    }
}
