package br.com.gabriel.ocean_a6_22_06_20

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * Created by Gabriel Magalhaes on 24/06/2020.
 * @author Paulo Salvatore
 */
interface GitHubService {
    @GET("search/repositories")
    fun searchRepositories(
        @Query("q") query: String
    ): Call<GitHubRepositoriesResult>
}