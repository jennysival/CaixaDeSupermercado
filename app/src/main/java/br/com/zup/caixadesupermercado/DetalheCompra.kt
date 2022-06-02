package br.com.zup.caixadesupermercado

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.Button
import br.com.zup.caixadesupermercado.databinding.ActivityDetalheCompraBinding

class DetalheCompra : AppCompatActivity() {
    private lateinit var binding: ActivityDetalheCompraBinding
    private val botaoRefazerCompra: Button by lazy { findViewById(R.id.botao_refazer) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityDetalheCompraBinding.inflate(layoutInflater)
        setContentView(binding.root)

        exibirDados()

        botaoRefazerCompra.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setTitle(R.string.titulo_detalhe)
    }

    private fun exibirDados(){
        binding.tvValorTotal.text = "O valor total é de: R$ ${recuperarDados()?.getValorTotal()}"
    }

    private fun recuperarDados(): Produto? {
        val produto = intent.getParcelableExtra<Produto>(PROD)

        if(produto != null) {
            val valorTotal = calcularValor(produto.getQuantidade(), produto.getValor())
            produto.setValorTotal(valorTotal)
            return produto
        }

        return produto
    }

    private fun calcularValor(qtd: Double, valor: Double) = valor*qtd

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == android.R.id.home) {
            this.finish()
            return true
        }
        return super.onOptionsItemSelected(item)
    }
}