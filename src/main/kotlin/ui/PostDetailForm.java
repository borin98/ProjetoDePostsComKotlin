package ui;

import business.PostBusiness;
import entity.PostEntity;

import javax.swing.*;

public class PostDetailForm extends JFrame
{

    private JPanel rootPanel ;
    private JLabel lblTitulo ;
    private JLabel lblBody ;

    private PostBusiness mPostBusiness = new PostBusiness (  ) ;

    public PostDetailForm ( int id )
    {

        super ( ) ;
        this.loadPost ( id ) ;

        this.setContentPane(rootPanel) ;
        this.setSize ( 500, 250 ) ;
        this.setVisible( true ) ;


    }

    // função na qual pega o id e carrega o mesmo para pegar as informações dele
    private void loadPost ( int id )
    {

        PostEntity entity = this.mPostBusiness.getSinglePost ( id ) ;

        // mostrando as informações
        this.lblTitulo.setText( entity.getTitle ( ) ) ;
        this.lblBody.setText ( "<html>" + entity.getBody() + "</html>" ) ;


    }

}
