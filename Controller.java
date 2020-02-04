package sample;

import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.input.*;
import javafx.scene.text.Text;

public class Controller {
	
	/**
	 * Fonction qui prenne txfSource et qui demarre une drag
	 * @param mouseEvent
	 */
	public void txfSourceDragDetect(MouseEvent mouseEvent){
		TextField refSource = (TextField) mouseEvent.getSource();
		if(!refSource.getText().isBlank()){
			Dragboard db = refSource.startDragAndDrop(TransferMode.ANY);
			ClipboardContent content = new ClipboardContent();
			content.putString(refSource.getText());
			db.setContent(content);
		}
	}
	
	/**
	 * Fonction qui detect si le content est approprier pour l'accepter ou refuser
	 * @param dragEvent
	 */
	public void txfDragOver(DragEvent dragEvent){
		dragEvent.acceptTransferModes(TransferMode.ANY);
	}
	
	/**
	 * Fonction qui deplace le contenu dans txfSource
	 * @param dragEvent
	 */
	public void txfDragDropped(DragEvent dragEvent){
		TextField refSource = (TextField) dragEvent.getGestureSource();
		TextField refTarget = (TextField) dragEvent.getGestureTarget();
		
		//Eviter qu'ils s'auto effacent
		if(refSource != refTarget){
			refTarget.setText(refSource.getText());
			refSource.clear();
		}
	}
}
