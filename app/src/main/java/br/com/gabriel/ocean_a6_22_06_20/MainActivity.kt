package br.com.gabriel.ocean_a6_22_06_20

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btPesquisar.setOnClickListener { pesquisar() }
    }

    private fun pesquisar() {
        val language = etLinguagem.text
        if (language.isBlank()) {
            etLinguagem.error = "Digite uma linguagem..."
            return
        }

        textView.text = "Carregando..."

        // Implementação do Retrofit
        val retrofit = Retrofit.Builder()
            .baseUrl("https://api.github.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val service = retrofit.create(GitHubService::class.java)

        val call = service.searchRepositories("language:$language")
        call.enqueue(object : Callback<GitHubRepositoriesResult> {
            override fun onFailure(call: Call<GitHubRepositoriesResult>, t: Throwable) {
                textView.text = "Erro ao carregar os repositórios."
                Log.e("MainActivity", "Erro ao executar API.", t)
            }

            override fun onResponse(
                call: Call<GitHubRepositoriesResult>, response: Response<GitHubRepositoriesResult>
            ) {
                if (response.isSuccessful) response.body()?.items?.let { repositories ->
                    textView.text = ""
                    repositories.forEach {
                        textView.append(it.full_name)
                    }
                }
            }
        })
    }
}
