package repository

import entity.FullParameters
import entity.HttpResponce

class PostRepository private constructor( )
{
    companion object : BaseRepository ( )
    {

        fun getAllPost ( fullParameters : FullParameters ) : HttpResponce
        {

            return super.execute ( fullParameters )

        }

        fun getSinglePost ( fullParameters : FullParameters ) : HttpResponce
        {

           return super.execute ( fullParameters )

        }

    }

}