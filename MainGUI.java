import javafx.application.Application;
import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.effect.Effect;
import javafx.scene.effect.Glow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class MainGUI extends Application{

	public static void main(String[] args){
		
		launch(args);
		
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		

		BorderPane theBorderPane = new BorderPane();
		theBorderPane.setCenter(addVBoxPane());
		
		
//		Image niya1 = new Image("Niya1.jpg");
//		ImageView niya1View = new ImageView(niya1);
		
		Scene theScene = new Scene(theBorderPane, 400, 500);
		
		theScene.getStylesheets().add(MainGUI.class.getResource("style.css").toExternalForm());
		primaryStage.setTitle("Niya Game");
		primaryStage.setScene(theScene); 
		primaryStage.show();
		
	}
	private VBox addVBoxPane() {

		VBox theVBox = new VBox();
		
		
		Text theText = new Text("Welcome to Niya");
		theText.setFill(Color.WHITE);
	    theText.setFont(Font.font(java.awt.Font.DIALOG, 40));
	    final Effect glow = new Glow(1.0);
	    theText.setEffect(glow);
	    theText.setTranslateX(50);
	    theText.setTranslateY(100);
		theVBox.getChildren().add(theText);
		 
		
		Button playTheGame = new Button("Play the Game");
		playTheGame.setTranslateX(150);
		playTheGame.setTranslateY(140);
		playTheGame.getStyleClass().add("round-red");
	
		
		Button playWithComputer = new Button("Play against Computer");
		playWithComputer.setTranslateX(130);
		playWithComputer.setTranslateY(390);
		playWithComputer.getStyleClass().add("round-red");
		theVBox.getChildren().add(playWithComputer);
		
		
		playWithComputer.setOnAction(e->{
			

			
			playAgainstComputerHard();
			
			
		});
		
		
		
		playTheGame.setOnAction(e -> {
		
			TheGame playGame = new TheGame();
			playGame.playTheGame();
			
			
		}
		);
		
		
		
		
		Button viewSavedGame = new Button("View Saved Game");
		viewSavedGame.setTranslateX(140);
		viewSavedGame.setTranslateY(150);
		
		viewSavedGame.setOnAction(e ->{
			
			
			
		}	
				);
		
		
		Image niya2 = new Image("niya2.jpg");
		ImageView niya2View = new ImageView(niya2);
		niya2View.setFitWidth(150);
		niya2View.setFitHeight(150);
		niya2View.setTranslateX(120);
		niya2View.setTranslateY(100);
		theVBox.getChildren().add(niya2View);
		
		

		viewSavedGame.getStyleClass().add("round-red");
		
		theVBox.getChildren().add(playTheGame);
		theVBox.getChildren().add(viewSavedGame);
		
		
		
		return theVBox;
	}
	public void playAgainstComputerHard(){
		
		Stage theStage = new Stage();
		StackPane theStackPane = new StackPane();
		
		
		Button hardLevel = new Button("Play the Hard level");
		hardLevel.setTranslateX(0);
		hardLevel.setTranslateY(80);
		
		
		hardLevel.setOnAction(e->{
			
			ComputerOne theHardLevel = new ComputerOne();
			theHardLevel.showTheGameHardLevel();
			
		});
		
		Button easyLevel = new Button("Play the easy level");
		easyLevel.setTranslateX(0);
		easyLevel.setTranslateY(-80);
		
		
		easyLevel.setOnAction(e->{
			
//			ComputerTwo theEasyLevel = new ComputerTwo();
//			theEasyLevel.startTheGame();
//			
		});
		
		theStackPane.getChildren().addAll(hardLevel,easyLevel);
		Scene theScene = new Scene(theStackPane, 200, 200);
		theStage.setScene(theScene);
		theStage.show();
		
	}
	
	
	public static class TheGame{
		
		
		public void playTheGame(){
			
			Stage stage = new Stage();
			
			BorderPane theBorder = new BorderPane();	
			
			HBox hbox = addHBox();
			theBorder.setTop(hbox);
			
			VBox leftVbox = addLeftVBox();
			theBorder.setLeft(leftVbox);
			
			VBox rightVbox = addRightVBox();
			theBorder.setRight(rightVbox);
			
			HBox bottomHBox = bottomHBox();
			theBorder.setBottom(bottomHBox);	
			
			theBorder.setCenter(addGridPane());
			
			
			
			Scene scene = new Scene(theBorder, 700, 600);
			scene.getStylesheets().add("style.css"); 
			stage.setScene(scene);
			stage.show();

			
		}
		private GridPane addGridPane() {

			
		GameBoard theBoard = new GameBoard();
		
		GridPane newGrid = new GridPane();
		newGrid.getChildren().add(theBoard.addGridPane());
		
		
		    return newGrid;
		}
		private HBox bottomHBox() {

			
			HBox bottomHBox = new HBox();
			bottomHBox.setSpacing(5);
			bottomHBox.getStyleClass().add("vbox");
			
			Button quitButton = new Button("Quit");
			quitButton.setPrefSize(100, 20);
			quitButton.getStyleClass().add("dark-blue");
			quitButton.setOnAction((actionEvent) -> Platform.exit());
			
			Button savedGameButton = new Button("Replay saved game");
			savedGameButton.getStyleClass().add("dark-blue");
			
			// save the game in a file 
			
			savedGameButton.setOnAction(e->{
				
				
			});

			
			
			bottomHBox.getChildren().addAll(quitButton, savedGameButton);

			
			return bottomHBox;
		}

		private VBox addRightVBox() {


			VBox vbox = new VBox();
			vbox.getStyleClass().add("vbox");
			
		    vbox.setPadding(new Insets(10));
		    vbox.setSpacing(8);

		    Text theBlackPlayer = new Text("Black Player");
		    theBlackPlayer.setFill(Color.WHITE);
		    theBlackPlayer.setFont(Font.font("Arial", FontWeight.BOLD, 14));
		    vbox.getChildren().add(theBlackPlayer);
		    
		    Circle theBlackCircle = new Circle();
		    theBlackCircle.setFill(Color.BLACK);
		    theBlackCircle.setRadius(30);
		    Tile tileObj = new Tile();
		    
		    
		    StackPane newStackPane = new StackPane();
		    newStackPane.getChildren().addAll(tileObj.getRectangle(), theBlackCircle);
		    vbox.getChildren().add(newStackPane);    
		    
		 
		    return vbox;
		}

		private VBox addLeftVBox() {

			VBox vbox = new VBox();
			vbox.getStyleClass().add("vbox");
			
			
		    vbox.setPadding(new Insets(10));
		    vbox.setSpacing(8);

		    Text theRedPlayer = new Text("Red Player");
		    theRedPlayer.setFill(Color.WHITE);
		    theRedPlayer.setFont(Font.font("Arial", FontWeight.BOLD, 14));
		    vbox.getChildren().add(theRedPlayer);
		    
		    
		    
		    Circle theRedCircle = new Circle();
		    theRedCircle.setFill(Color.RED);
		    theRedCircle.setRadius(30);

		    
		    
		    Tile tileObj = new Tile();
		    StackPane newStackPane = new StackPane();
		    newStackPane.getChildren().addAll(tileObj.getRectangle(), theRedCircle);
		    vbox.getChildren().add(newStackPane);    
		    
		    
		    
		    return vbox;
		    
		}
		

		private HBox addHBox() {

			HBox hbox = new HBox();
			hbox.getStyleClass().add("vbox");
			
			
		    hbox.setPadding(new Insets(15, 12, 15, 12));
		    hbox.setSpacing(10);
	
		    
		    
		    Text newText = new Text("Welcome to Niya game");
		    newText.getStyleClass().add("textStyle");	
		    hbox.getChildren().addAll(newText);
		    
		    
			return hbox;
		}

	}
	
}
	
