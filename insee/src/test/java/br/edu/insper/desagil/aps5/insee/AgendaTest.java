package br.edu.insper.desagil.aps5.insee;

// Importações necessárias para os testes
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*; // Para usar assertEquals, assertTrue, assertThrows, etc.
import static org.mockito.Mockito.mock;           // Para criar mocks com Mockito
import static org.mockito.Mockito.when;           // Para definir comportamentos de mocks

public class AgendaTest {
    // Objeto que será testado em todos os testes
    private Agenda a;

    // Este método roda antes de cada teste. Ele garante que começamos com uma nova Agenda "limpa".
    @BeforeEach
    void setUp() {
        a = new Agenda();
    }

    // Testa se uma nova Agenda começa vazia
    @Test
    void constroi() {
        // Verifica se a lista de eventos da agenda está vazia
        assertTrue(a.getEventos().isEmpty());
    }

    // Testa se um evento válido é adicionado corretamente
    @Test
    void adicionaValido() {
        // Cria um evento mock que retorna true quando .valido() é chamado
        Evento evento = criaEvento(true);

        // Cria uma lista contendo esse evento, que será usada para comparar depois
        List<Evento> eventos = new ArrayList<>();
        eventos.add(evento);

        // Adiciona o evento à agenda
        a.adiciona(evento);

        // Verifica se a lista de eventos da agenda contém o evento esperado
        assertEquals(eventos, a.getEventos());
    }

    // Testa se um evento inválido lança a exceção correta
    @Test
    void adicionaInvalido() {
        // Cria um evento mock que retorna false quando .valido() é chamado
        Evento evento = criaEvento(false);

        // Verifica se ao tentar adicionar o evento inválido, é lançada uma exceção
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            a.adiciona(evento); // Tenta adicionar o evento inválido
        });

        // Verifica se a mensagem da exceção está correta
        assertEquals("Evento inválido!", exception.getMessage());
    }

    // Método auxiliar para criar um mock de Evento com comportamento controlado
    private Evento criaEvento(boolean valido) {
        // Cria o mock da classe Evento
        Evento evento = mock(Evento.class); //evento class
        // Define o retorno do método .valido()
        when(evento.valido()).thenReturn(valido); //quando voce chamar a funcao ele retorna o que voce coloca no booleano
        // Retorna o mock pronto para ser usado no teste
        return evento;
    }
}
