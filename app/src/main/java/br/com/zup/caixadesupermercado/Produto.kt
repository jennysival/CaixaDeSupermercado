package br.com.zup.caixadesupermercado

import android.os.Parcelable
import kotlinx.parcelize.Parcelize
@Parcelize

class Produto(
    private var nome: String,
    private var quantidade: Double,
    private var valor: Double
    ): Parcelable {

    fun getNome() = this.nome
    fun getQuantidade() = this.quantidade
    fun getValor() = this.valor
}