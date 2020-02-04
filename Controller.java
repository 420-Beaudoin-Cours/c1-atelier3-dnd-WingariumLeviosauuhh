package sample;

import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.input.*;
import javafx.scene.text.Text;

public class Controller {
	
	public TextField txfSource;
	public ComboBox<String> cmbList;
	
	/**
	 * Fonction qui prenne txfSource et qui demarre une drag
	 * @param mouseEvent
	 */
	public void txfSourceDragDetect(MouseEvent mouseEvent){
		if(!txfSource.getText().isBlank()){
			Dragboard db = txfSource.startDragAndDrop(TransferMode.ANY);
			ClipboardContent content = new ClipboardContent();

			content.putString(txfSource.getText());
			db.setContent(content);
		}
	}
	
	/**
	 * Fonction qui detect si le content est approprier pour l'accepter ou refuser
	 * @param dragEvent
	 */
	public void imgViewDragOver(DragEvent dragEvent){
		//dragEvent.acceptTransferModes(TransferMode.ANY);
	}
	
	/**
	 * Fonction qui efface le contenu dans txfSource
	 * @param dragEvent
	 */
	public void imgViewDragDropped(DragEvent dragEvent){
		//TextField refTarget = (TextField) dragEvent.getGestureSource();
		//refTarget.clear();
	}
	
	//Excercise 2 ----------------------------------------
	
	/**
	 *
	 * @param dragEvent
	 */
	public void cmbListDragOver(DragEvent dragEvent){
		dragEvent.acceptTransferModes(TransferMode.ANY);
	}
	
	public void cmbListDragDropped(DragEvent dragEvent){
		TextField refSource = (TextField) dragEvent.getGestureSource();
		cmbList.getItems().add(refSource.getText());
		cmbList.getSelectionModel().selectLast();
	}
}
