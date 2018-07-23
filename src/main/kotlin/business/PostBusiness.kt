/*

    Classe responsável por ditar qual será a regra do negócio que será seguido

 */

package business

import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import entity.FullParameters
import entity.HttpResponce
import entity.PostEntity
import infra.EndPointConstants
import infra.OperationMethod
import javafx.geometry.Pos
import repository.PostRepository

class PostBusiness ( )
{

    fun getAllPost (  ) : List < PostEntity >
    {

       val url : String = EndPointConstants.BASE.URL + EndPointConstants.POST.ALL_POSTS
       val fullParameters : FullParameters = FullParameters ( url, OperationMethod.GET )
       val responce : HttpResponce = PostRepository.getAllPost ( fullParameters )

        // fazendo a conversão para arquivo Gson
        return Gson().fromJson<List < PostEntity > >(responce.jsonResponce,object : TypeToken < List < PostEntity > > ( ){}.type)

    }

    fun getSinglePost ( id : Int ) : PostEntity
    {

        val url : String = EndPointConstants.BASE.URL + EndPointConstants.POST.SINGLE_POST
        val fullParameters : FullParameters = FullParameters ( url, OperationMethod.GET, mapOf ( Pair("id", id.toString ( ) ) ) )
        val responce : HttpResponce = PostRepository.getSinglePost ( fullParameters )

        return Gson().fromJson<List < PostEntity > >(responce.jsonResponce,object : TypeToken < List < PostEntity > > ( ) {}.type)[0]


    }

}