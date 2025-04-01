enum class Nivel { BASICO, INTERMEDIARIO, DIFICIL }

data class Usuario(val nome:String, val idade: Int)

data class ConteudoEducacional(var nome: String, val duracaoHoras: Int)

data class Formacao(val nome: String, val conteudos: List<ConteudoEducacional>, val nivel: Nivel) {

    val inscritos = mutableListOf<Usuario>()
    
    fun matricular(usuario: Usuario) {
        inscritos.add(usuario)
		println("Usuario matriculado com sucesso!")
    }
}

fun main() {
    val usuario1 = Usuario("Alexandre", 20)
    val usuario2 = Usuario("Vera", 60)

    val cursoKotlin = ConteudoEducacional("Curso Kotlin", 95)
    val cursoBanco = ConteudoEducacional("Modelagem de Dados", 130)

    val formacaoKotlin = Formacao("Desenvolvimento Kotlin", listOf(cursoKotlin), Nivel.INTERMEDIARIO)
    val formacaoBancoDados = Formacao("Fundamentos de Banco de Dados", listOf(cursoBanco), Nivel.BASICO)

    formacaoKotlin.matricular(usuario1)
    formacaoBancoDados.matricular(usuario2)

    println("\nInscritos na formação '${formacaoKotlin.nome}':")
    formacaoKotlin.inscritos.forEach { println(it.nome) }

    println("\nInscritos na formação '${formacaoBancoDados.nome}':")
    formacaoBancoDados.inscritos.forEach { println(it.nome) }

    println("\nPrimeiro conteúdo da formação '${formacaoKotlin.nome}': ${formacaoKotlin.conteudos.first().nome} (duração: ${formacaoKotlin.conteudos.first().duracaoHoras} minutos)")
    println("Nível da formação '${formacaoKotlin.nome}': ${formacaoKotlin.nivel}")

    formacaoKotlin.conteudos.first().nome = "Primeiros Passos em Kotlin"
    println("Nome do primeiro conteúdo de '${formacaoKotlin.nome}' após modificação: ${formacaoKotlin.conteudos.first().nome}")

}