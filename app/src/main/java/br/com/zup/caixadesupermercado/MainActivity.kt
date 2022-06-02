package br.com.zup.caixadesupermercado

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import br.com.zup.caixadesupermercado.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private val editTextNomeProduto: EditText by lazy { findViewById(R.id.ed_nome) }
    private val editTextQtd: EditText by lazy { findViewById(R.id.ed_qtd) }
    private val editTextValor: EditText by lazy { findViewById(R.id.ed_valor) }
    private val botaoCalcularValor: Button by lazy { findViewById(R.id.botao_calcular) }

    private lateinit var binding: ActivityMainBinding

    private lateinit var nomeProduto: String
    private lateinit var qtdProduto: String
    private lateinit var valorProduto: String


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        botaoCalcularValor.setOnClickListener {
            enviarDadosProduto()

        }
    }

    private fun enviarDadosProduto(){
        recuperarCamposEditText()
        if (!verificarCamposEditText()){
            val novoProduto = Produto(nomeProduto, qtdProduto.toDouble(), valorProduto.toDouble())

            val intent = Intent(this, DetalheCompra::class.java).apply {
                putExtra(PROD, novoProduto)
            }
            startActivity(intent)
            limparCamposEditText()
        }

    }

    private fun recuperarCamposEditText(){
        this.nomeProduto = binding.edNome.text.toString()
        this.qtdProduto = binding.edQtd.text.toString()
        this.valorProduto = binding.edValor.text.toString()
    }

    private fun verificarCamposEditText(): Boolean{
        when {
            this.nomeProduto.isEmpty() -> {
                binding.edNome.error = CAMPO_OBRIGATORIO
                return true
            }
            this.qtdProduto.isEmpty() -> {
                binding.edQtd.error = CAMPO_OBRIGATORIO
                return true
            }
            this.valorProduto.isEmpty() -> {
                binding.edValor.error = CAMPO_OBRIGATORIO
                return true
            }
        }
        return false
    }

    private fun limparCamposEditText() {
        binding.edNome.text.clear()
        binding.edQtd.text.clear()
        binding.edValor.text.clear()
    }
}