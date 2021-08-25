
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import br.edu.ifs.ed2.dados.TesteFila;
import br.edu.ifs.ed2.dados.TestePilha;
import br.edu.ifs.ed2.dados.hash.TesteHashAberto;
import br.edu.ifs.ed2.dados.hash.TesteHashEncadeado;
import br.edu.ifs.ed2.dados.hash.chave.TesteChaveNumerica;
import br.edu.ifs.ed2.dados.hash.chave.TesteChaveTextual;
import br.edu.ifs.ed2.dados.hash.colisao.TesteColisaoEncadeada;
import br.edu.ifs.ed2.dados.hash.colisao.TesteColisaoLinear;
import br.edu.ifs.ed2.dados.hash.espalhamento.TesteEspalhamentoDivisao;
import br.edu.ifs.ed2.dados.lista.TesteListaDupla;
import br.edu.ifs.ed2.dados.lista.TesteListaSimples;

@RunWith(Suite.class)
@SuiteClasses({ TesteFila.class, TestePilha.class, TesteListaDupla.class, TesteListaSimples.class,
		TesteHashAberto.class, TesteHashEncadeado.class, TesteChaveNumerica.class, TesteChaveTextual.class,
		TesteColisaoEncadeada.class, TesteColisaoLinear.class, TesteEspalhamentoDivisao.class })
public class AllTests {

}
