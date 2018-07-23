/*

    Classe para implementação da interface e suas interações

 */

package ui;

import business.PostBusiness;
import entity.PostEntity;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.List;

public class PostListForm extends JFrame implements ListSelectionListener
{
    private JTable tablePost;
    private JPanel rootPanel;
    private PostBusiness mPostBusiness = new PostBusiness ( ) ;

    public PostListForm ( )
    {

        super ( ) ;

        this.getAllPost ( ) ;

        // mostrando em qual conteudo ele deve mostrar
        this.setContentPane ( rootPanel );
        this.setSize ( 250, 250 ) ;
        this.setVisible ( true ) ;

        // chamando a chamada para finalizar o programa
        this.setDefaultCloseOperation ( WindowConstants.EXIT_ON_CLOSE ) ;

        this.setEvents ( ) ;

    }

    // cria o evento do click na aplicação
    private void setEvents ( )
    {

        tablePost.getSelectionModel().addListSelectionListener ( this ) ;

    }

    // função que pega todos os posts
    private void getAllPost (  )
    {
        // trecho de exemplo para pegar o código
        String [] columnNames = {"Id", "Título"} ;

        List < PostEntity > lst = this.mPostBusiness.getAllPost() ;

        DefaultTableModel model = new DefaultTableModel( new Object[0][0], columnNames  ) ;

        int i = 0 ;

        for ( PostEntity entity : lst )
        {

            // criando um objeto que contém Id e Título
            Object[] obj = new Object[2] ;
            obj[0] = entity.getId() ;
            obj[1] = entity.getTitle() ;

            // adicionando o objeto na coluna do Jframe
            model.addRow ( obj ) ;

            i++;

            if ( i == 10 )
            {

                break ;

            }

        }

        this.tablePost.setModel ( model ) ;

    }

    @Override
    public void valueChanged(ListSelectionEvent e)
    {

        int postId ;

        // evita que ele não entre no evento enquanto o valor é ajustado
        if ( e.getValueIsAdjusting() )
        {

            // Pegando o id da linha em que ela foi clicada
            postId = Integer.parseInt ( tablePost.getValueAt(tablePost.getSelectedRow(), 0 ).toString() ) ;

            // pegando o id para achar as opções do post específico
            new PostDetailForm ( postId ) ;

        }

    }

}
