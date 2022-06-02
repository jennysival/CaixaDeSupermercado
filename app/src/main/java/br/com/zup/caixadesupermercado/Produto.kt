package br.com.zup.caixadesupermercado

import android.os.Parcelable
import kotlinx.parcelize.Parcelize
@Parcelize

class Produto(
    private var nome: String,
    private var quantidade: Double,
    private var valor: Double
    ): Parcelable {

    private var valorTotal: Double = 0.0

    fun getNome() = this.nome
    fun getQuantidade() = this.quantidade
    fun getValor() = this.valor
    fun getValorTotal() = this.valorTotal

    fun setValorTotal(valor: Double){
        valorTotal = valor
    }
}