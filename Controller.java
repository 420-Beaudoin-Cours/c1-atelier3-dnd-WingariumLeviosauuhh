package sample;

import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.input.*;

public class Controller {
	
	public TextField txfSource;
	
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
		dragEvent.acceptTransferModes(TransferMode.ANY);
	}
	
	/**
	 * Fonction qui efface le contenu dans txfSource
	 * @param dragEvent
	 */
	public void imgViewDragDropped(DragEvent dragEvent){
		TextField refTarget = (TextField) dragEvent.getGestureSource();
		refTarget.clear();
	}
}
