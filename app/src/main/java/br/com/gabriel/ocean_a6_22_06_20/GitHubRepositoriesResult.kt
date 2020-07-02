package br.com.gabriel.ocean_a6_22_06_20

/**
 * Created by Gabriel Magalhaes on 22/06/2020.
 * @author Paulo Salvatore - Samsung Ocean
 */
data class GitHubRepositoriesResult(val items: List<Repository>)

data class Repository(
    val id: Int,
    val name: String,
    val full_name: String,
    val description: String,
    val owner: Owner,
    val html_url: String
)

data class Owner(
    val id: Int,
    val login: String,
    val avatar_url: String,
    val html_url: String
)

/**
 * Desafio:
 * Adicionar propriedade da classe Owner na classe Repository
 * Criação da classe Owner, com os dados que achar relevante
 * */