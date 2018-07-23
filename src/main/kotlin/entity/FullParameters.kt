package entity

import infra.OperationMethod

// parâmetros para a API
data class FullParameters (
        val url : String,
        val method : OperationMethod,
        val parameters : Map < String, String > = emptyMap()

)